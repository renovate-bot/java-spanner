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
// source: google/spanner/executor/v1/cloud_executor.proto

// Protobuf Java Version: 3.25.8
package com.google.spanner.executor.v1;

public interface GenerateDbPartitionsForQueryActionOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.executor.v1.GenerateDbPartitionsForQueryAction)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Query to generate partitions for.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryAction query = 1;</code>
   *
   * @return Whether the query field is set.
   */
  boolean hasQuery();

  /**
   *
   *
   * <pre>
   * Query to generate partitions for.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryAction query = 1;</code>
   *
   * @return The query.
   */
  com.google.spanner.executor.v1.QueryAction getQuery();

  /**
   *
   *
   * <pre>
   * Query to generate partitions for.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryAction query = 1;</code>
   */
  com.google.spanner.executor.v1.QueryActionOrBuilder getQueryOrBuilder();

  /**
   *
   *
   * <pre>
   * Desired size of data in each partition. Spanner doesn't guarantee to
   * respect this value.
   * </pre>
   *
   * <code>optional int64 desired_bytes_per_partition = 2;</code>
   *
   * @return Whether the desiredBytesPerPartition field is set.
   */
  boolean hasDesiredBytesPerPartition();

  /**
   *
   *
   * <pre>
   * Desired size of data in each partition. Spanner doesn't guarantee to
   * respect this value.
   * </pre>
   *
   * <code>optional int64 desired_bytes_per_partition = 2;</code>
   *
   * @return The desiredBytesPerPartition.
   */
  long getDesiredBytesPerPartition();
}
