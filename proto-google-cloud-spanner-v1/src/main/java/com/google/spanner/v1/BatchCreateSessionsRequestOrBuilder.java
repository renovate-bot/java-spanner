/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/spanner/v1/spanner.proto

// Protobuf Java Version: 3.25.8
package com.google.spanner.v1;

public interface BatchCreateSessionsRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.v1.BatchCreateSessionsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The database in which the new sessions are created.
   * </pre>
   *
   * <code>
   * string database = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The database.
   */
  java.lang.String getDatabase();

  /**
   *
   *
   * <pre>
   * Required. The database in which the new sessions are created.
   * </pre>
   *
   * <code>
   * string database = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for database.
   */
  com.google.protobuf.ByteString getDatabaseBytes();

  /**
   *
   *
   * <pre>
   * Parameters to be applied to each created session.
   * </pre>
   *
   * <code>.google.spanner.v1.Session session_template = 2;</code>
   *
   * @return Whether the sessionTemplate field is set.
   */
  boolean hasSessionTemplate();

  /**
   *
   *
   * <pre>
   * Parameters to be applied to each created session.
   * </pre>
   *
   * <code>.google.spanner.v1.Session session_template = 2;</code>
   *
   * @return The sessionTemplate.
   */
  com.google.spanner.v1.Session getSessionTemplate();

  /**
   *
   *
   * <pre>
   * Parameters to be applied to each created session.
   * </pre>
   *
   * <code>.google.spanner.v1.Session session_template = 2;</code>
   */
  com.google.spanner.v1.SessionOrBuilder getSessionTemplateOrBuilder();

  /**
   *
   *
   * <pre>
   * Required. The number of sessions to be created in this batch call.
   * The API may return fewer than the requested number of sessions. If a
   * specific number of sessions are desired, the client can make additional
   * calls to BatchCreateSessions (adjusting
   * [session_count][google.spanner.v1.BatchCreateSessionsRequest.session_count]
   * as necessary).
   * </pre>
   *
   * <code>int32 session_count = 3 [(.google.api.field_behavior) = REQUIRED];</code>
   *
   * @return The sessionCount.
   */
  int getSessionCount();
}
