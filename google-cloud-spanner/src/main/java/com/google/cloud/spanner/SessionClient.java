/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.grpc.GrpcTransportOptions.ExecutorFactory;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import io.opentelemetry.api.common.Attributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;

/** Client for creating single sessions and batches of sessions. */
class SessionClient implements AutoCloseable, XGoogSpannerRequestId.RequestIdCreator {
  static class SessionId {
    private static final PathTemplate NAME_TEMPLATE =
        PathTemplate.create(
            "projects/{project}/instances/{instance}/databases/{database}/sessions/{session}");
    private final DatabaseId db;
    private final String name;

    private SessionId(DatabaseId db, String name) {
      this.db = Preconditions.checkNotNull(db);
      this.name = Preconditions.checkNotNull(name);
    }

    static SessionId of(String name) {
      Preconditions.checkNotNull(name);
      Map<String, String> parts = NAME_TEMPLATE.match(name);
      Preconditions.checkArgument(
          parts != null, "Name should conform to pattern %s: %s", NAME_TEMPLATE, name);
      return of(
          parts.get("project"), parts.get("instance"), parts.get("database"), parts.get("session"));
    }

    /** Creates a {@code SessionId} given project, instance, database and session IDs. */
    static SessionId of(String project, String instance, String database, String session) {
      return new SessionId(new DatabaseId(new InstanceId(project, instance), database), session);
    }

    DatabaseId getDatabaseId() {
      return db;
    }

    String getName() {
      return name;
    }
  }

  /**
   * Encapsulates state to be passed to the {@link SpannerRpc} layer for a given session. Currently
   * used to select the {@link io.grpc.Channel} to be used in issuing the RPCs in a Session.
   */
  static class SessionOption {
    private final SpannerRpc.Option rpcOption;
    private final Object value;

    SessionOption(SpannerRpc.Option option, Object value) {
      this.rpcOption = checkNotNull(option);
      this.value = value;
    }

    static SessionOption channelHint(long hint) {
      return new SessionOption(SpannerRpc.Option.CHANNEL_HINT, hint);
    }

    SpannerRpc.Option rpcOption() {
      return rpcOption;
    }

    Object value() {
      return value;
    }
  }

  static Map<SpannerRpc.Option, ?> optionMap(SessionOption... options) {
    if (options.length == 0) {
      return Collections.emptyMap();
    }
    Map<SpannerRpc.Option, Object> tmp = Maps.newEnumMap(SpannerRpc.Option.class);
    for (SessionOption option : options) {
      Object prev = tmp.put(option.rpcOption(), option.value());
      checkArgument(prev == null, "Duplicate option %s", option.rpcOption());
    }
    return ImmutableMap.copyOf(tmp);
  }

  static Map<SpannerRpc.Option, ?> createRequestOptions(
      long channelId, XGoogSpannerRequestId requestId) {
    return ImmutableMap.of(
        Option.CHANNEL_HINT, channelId,
        Option.REQUEST_ID, requestId);
  }

  static Map<SpannerRpc.Option, ?> createRequestOptions(XGoogSpannerRequestId requestId) {
    return ImmutableMap.of(Option.REQUEST_ID, requestId);
  }

  private final class BatchCreateSessionsRunnable implements Runnable {
    private final long channelHint;
    private final int sessionCount;
    private final SessionConsumer consumer;

    private BatchCreateSessionsRunnable(
        int sessionCount, long channelHint, SessionConsumer consumer) {
      Preconditions.checkNotNull(consumer);
      Preconditions.checkArgument(sessionCount > 0, "sessionCount must be > 0");
      this.channelHint = channelHint;
      this.sessionCount = sessionCount;
      this.consumer = consumer;
    }

    @Override
    public void run() {
      List<SessionImpl> sessions;
      int remainingSessionsToCreate = sessionCount;
      ISpan span =
          spanner.getTracer().spanBuilder(SpannerImpl.BATCH_CREATE_SESSIONS, commonAttributes);
      try (IScope s = spanner.getTracer().withSpan(span)) {
        spanner
            .getTracer()
            .getCurrentSpan()
            .addAnnotation(String.format("Creating %d sessions", sessionCount));
        while (remainingSessionsToCreate > 0) {
          try {
            sessions = internalBatchCreateSessions(remainingSessionsToCreate, channelHint);
          } catch (Throwable t) {
            spanner.getTracer().getCurrentSpan().setStatus(t);
            consumer.onSessionCreateFailure(t, remainingSessionsToCreate);
            break;
          }
          for (SessionImpl session : sessions) {
            consumer.onSessionReady(session);
          }
          remainingSessionsToCreate -= sessions.size();
        }
      } finally {
        span.end();
      }
    }
  }

  /**
   * Callback interface to be used for Sessions. When sessions become available or session creation
   * fails, one of the callback methods will be called.
   */
  interface SessionConsumer {
    /** Called when a session has been created and is ready for use. */
    void onSessionReady(SessionImpl session);

    /**
     * Called when an error occurred during session creation. The createFailureForSessionCount
     * indicates the number of sessions that could not be created, so that the consumer knows how
     * many sessions it should still expect.
     */
    void onSessionCreateFailure(Throwable t, int createFailureForSessionCount);
  }

  private final SpannerImpl spanner;
  private final ExecutorFactory<ScheduledExecutorService> executorFactory;
  private final ScheduledExecutorService executor;
  private final DatabaseId db;
  private final Attributes commonAttributes;

  // SessionClient is created long before a DatabaseClientImpl is created,
  // as batch sessions are firstly created then later attached to each Client.
  private static final AtomicInteger NTH_ID = new AtomicInteger(0);
  private final int nthId = NTH_ID.incrementAndGet();
  private final AtomicInteger nthRequest = new AtomicInteger(0);

  @GuardedBy("this")
  private volatile long sessionChannelCounter;

  SessionClient(
      SpannerImpl spanner,
      DatabaseId db,
      ExecutorFactory<ScheduledExecutorService> executorFactory) {
    this.spanner = spanner;
    this.db = db;
    this.executorFactory = executorFactory;
    this.executor = executorFactory.get();
    this.commonAttributes = spanner.getTracer().createCommonAttributes(db);
  }

  @Override
  public void close() {
    executorFactory.release(executor);
  }

  SpannerImpl getSpanner() {
    return spanner;
  }

  DatabaseId getDatabaseId() {
    return db;
  }

  @Override
  public XGoogSpannerRequestId nextRequestId(long channelId, int attempt) {
    return XGoogSpannerRequestId.of(
        this.nthId, channelId, this.nthRequest.incrementAndGet(), attempt);
  }

  /** Create a single session. */
  SessionImpl createSession() {
    // The sessionChannelCounter could overflow, but that will just flip it to Integer.MIN_VALUE,
    // which is also a valid channel hint.
    final long channelId;
    synchronized (this) {
      channelId = sessionChannelCounter;
      sessionChannelCounter++;
    }
    XGoogSpannerRequestId reqId = nextRequestId(channelId, 1);
    ISpan span = spanner.getTracer().spanBuilder(SpannerImpl.CREATE_SESSION, this.commonAttributes);
    try (IScope s = spanner.getTracer().withSpan(span)) {
      com.google.spanner.v1.Session session =
          spanner
              .getRpc()
              .createSession(
                  db.getName(),
                  spanner.getOptions().getDatabaseRole(),
                  spanner.getOptions().getSessionLabels(),
                  createRequestOptions(channelId, reqId));
      SessionReference sessionReference =
          new SessionReference(
              session.getName(),
              session.getCreateTime(),
              session.getMultiplexed(),
              optionMap(SessionOption.channelHint(channelId)));
      SessionImpl sessionImpl = new SessionImpl(spanner, sessionReference);
      sessionImpl.setRequestIdCreator(this);
      return sessionImpl;
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  /**
   * Create a multiplexed session and returns it to the given {@link SessionConsumer}. A multiplexed
   * session is not affiliated with any GRPC channel. The given {@link SessionConsumer} is
   * guaranteed to eventually get exactly 1 multiplexed session unless an error occurs. In case of
   * an error on the gRPC calls, the consumer will receive one {@link
   * SessionConsumer#onSessionCreateFailure(Throwable, int)} calls with the error.
   *
   * @param consumer The {@link SessionConsumer} to use for callbacks when sessions are available.
   */
  void createMultiplexedSession(SessionConsumer consumer) {
    try {
      SessionImpl sessionImpl = createMultiplexedSession();
      consumer.onSessionReady(sessionImpl);
    } catch (Throwable t) {
      consumer.onSessionCreateFailure(t, 1);
    }
  }

  /**
   * Creates a multiplexed session and returns it. A multiplexed session is not affiliated with any
   * GRPC channel. In case of an error during the gRPC calls, an exception will be thrown.
   */
  SessionImpl createMultiplexedSession() {
    ISpan span =
        spanner
            .getTracer()
            .spanBuilder(SpannerImpl.CREATE_MULTIPLEXED_SESSION, this.commonAttributes);
    // MultiplexedSession doesn't use a channelId hence this hard-coded value.
    int channelId = 0;
    XGoogSpannerRequestId reqId = nextRequestId(channelId, 1);
    try (IScope s = spanner.getTracer().withSpan(span)) {
      com.google.spanner.v1.Session session =
          spanner
              .getRpc()
              .createSession(
                  db.getName(),
                  spanner.getOptions().getDatabaseRole(),
                  spanner.getOptions().getSessionLabels(),
                  createRequestOptions(reqId),
                  true);
      SessionImpl sessionImpl =
          new SessionImpl(
              spanner,
              new SessionReference(
                  session.getName(), session.getCreateTime(), session.getMultiplexed(), null));
      sessionImpl.setRequestIdCreator(this);
      span.addAnnotation(
          String.format("Request for %d multiplexed session returned %d session", 1, 1));
      return sessionImpl;
    } catch (Throwable t) {
      span.setStatus(t);
      throw t;
    } finally {
      span.end();
    }
  }

  /**
   * Create a multiplexed session asynchronously and returns it to the given {@link
   * SessionConsumer}. A multiplexed session is not affiliated with any GRPC channel. The given
   * {@link SessionConsumer} is guaranteed to eventually get exactly 1 multiplexed session unless an
   * error occurs. In case of an error on the gRPC calls, the consumer will receive one {@link
   * SessionConsumer#onSessionCreateFailure(Throwable, int)} call with the error.
   *
   * @param consumer The {@link SessionConsumer} to use for callbacks when sessions are available.
   */
  void asyncCreateMultiplexedSession(SessionConsumer consumer) {
    try {
      executor.submit(new CreateMultiplexedSessionsRunnable(consumer));
    } catch (Throwable t) {
      consumer.onSessionCreateFailure(t, 1);
    }
  }

  private final class CreateMultiplexedSessionsRunnable implements Runnable {
    private final SessionConsumer consumer;

    private CreateMultiplexedSessionsRunnable(SessionConsumer consumer) {
      Preconditions.checkNotNull(consumer);
      this.consumer = consumer;
    }

    @Override
    public void run() {
      createMultiplexedSession(consumer);
    }
  }

  /**
   * Asynchronously creates a batch of sessions and returns these to the given {@link
   * SessionConsumer}. This method may split the actual session creation over several gRPC calls in
   * order to distribute the sessions evenly over all available channels and to parallelize the
   * session creation. The given {@link SessionConsumer} is guaranteed to eventually get exactly the
   * number of requested sessions unless an error occurs. In case of an error on one or more of the
   * gRPC calls, the consumer will receive one or more {@link
   * SessionConsumer#onSessionCreateFailure(Throwable, int)} calls with the error and the number of
   * sessions that could not be created.
   *
   * @param sessionCount The number of sessions to create.
   * @param distributeOverChannels Whether to distribute the sessions over all available channels
   *     (true) or create all for the next channel round robin.
   * @param consumer The {@link SessionConsumer} to use for callbacks when sessions are available.
   */
  void asyncBatchCreateSessions(
      final int sessionCount, boolean distributeOverChannels, SessionConsumer consumer) {
    int sessionCountPerChannel;
    int remainder;
    if (distributeOverChannels) {
      sessionCountPerChannel = sessionCount / spanner.getOptions().getNumChannels();
      remainder = sessionCount % spanner.getOptions().getNumChannels();
    } else {
      sessionCountPerChannel = sessionCount;
      remainder = 0;
    }
    int numBeingCreated = 0;
    synchronized (this) {
      for (int channelIndex = 0;
          channelIndex < spanner.getOptions().getNumChannels();
          channelIndex++) {
        int createCountForChannel = sessionCountPerChannel;
        // Add the remainder of the division to the creation count of the first channel to make sure
        // we are creating the requested number of sessions. This will cause a slightly less
        // efficient distribution of sessions over the channels than spreading the remainder over
        // all channels as well, but it will also reduce the number of requests when less than
        // numChannels sessions are requested (i.e. with 4 channels and 3 requested sessions, the 3
        // sessions will be requested in one rpc call).
        if (channelIndex == 0) {
          createCountForChannel = sessionCountPerChannel + remainder;
        }
        if (createCountForChannel > 0 && numBeingCreated < sessionCount) {
          try {
            executor.submit(
                new BatchCreateSessionsRunnable(
                    createCountForChannel, sessionChannelCounter++, consumer));
            numBeingCreated += createCountForChannel;
          } catch (Throwable t) {
            consumer.onSessionCreateFailure(t, sessionCount - numBeingCreated);
          }
        } else {
          break;
        }
      }
    }
  }

  /**
   * Creates a batch of sessions that will all be affiliated with the same gRPC channel. It is the
   * responsibility of the caller to make multiple calls to this method in order to create sessions
   * that are distributed over multiple channels.
   */
  private List<SessionImpl> internalBatchCreateSessions(
      final int sessionCount, final long channelHint) throws SpannerException {
    ISpan parent = spanner.getTracer().getCurrentSpan();
    ISpan span =
        spanner
            .getTracer()
            .spanBuilderWithExplicitParent(SpannerImpl.BATCH_CREATE_SESSIONS_REQUEST, parent);
    span.addAnnotation(String.format("Requesting %d sessions", sessionCount));
    try (IScope s = spanner.getTracer().withSpan(span)) {
      XGoogSpannerRequestId reqId =
          XGoogSpannerRequestId.of(this.nthId, channelHint, this.nthRequest.incrementAndGet(), 1);
      List<com.google.spanner.v1.Session> sessions =
          spanner
              .getRpc()
              .batchCreateSessions(
                  db.getName(),
                  sessionCount,
                  spanner.getOptions().getDatabaseRole(),
                  spanner.getOptions().getSessionLabels(),
                  createRequestOptions(channelHint, reqId));
      span.addAnnotation(
          String.format(
              "Request for %d sessions returned %d sessions", sessionCount, sessions.size()));
      span.end();
      List<SessionImpl> res = new ArrayList<>(sessionCount);
      for (com.google.spanner.v1.Session session : sessions) {
        SessionImpl sessionImpl =
            new SessionImpl(
                spanner,
                new SessionReference(
                    session.getName(),
                    session.getCreateTime(),
                    session.getMultiplexed(),
                    optionMap(SessionOption.channelHint(channelHint))));
        sessionImpl.setRequestIdCreator(this);
        res.add(sessionImpl);
      }
      return res;
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  /** Returns a {@link SessionImpl} that references the existing session with the given name. */
  SessionImpl sessionWithId(String name) {
    final Map<SpannerRpc.Option, ?> options;
    synchronized (this) {
      options = optionMap(SessionOption.channelHint(sessionChannelCounter++));
    }
    SessionImpl sessionImpl = new SessionImpl(spanner, new SessionReference(name, options));
    sessionImpl.setRequestIdCreator(this);
    return sessionImpl;
  }
}
