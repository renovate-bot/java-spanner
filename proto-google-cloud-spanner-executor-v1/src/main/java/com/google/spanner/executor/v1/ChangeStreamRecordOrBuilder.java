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

public interface ChangeStreamRecordOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.executor.v1.ChangeStreamRecord)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Data change record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.DataChangeRecord data_change = 1;</code>
   *
   * @return Whether the dataChange field is set.
   */
  boolean hasDataChange();

  /**
   *
   *
   * <pre>
   * Data change record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.DataChangeRecord data_change = 1;</code>
   *
   * @return The dataChange.
   */
  com.google.spanner.executor.v1.DataChangeRecord getDataChange();

  /**
   *
   *
   * <pre>
   * Data change record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.DataChangeRecord data_change = 1;</code>
   */
  com.google.spanner.executor.v1.DataChangeRecordOrBuilder getDataChangeOrBuilder();

  /**
   *
   *
   * <pre>
   * Child partitions record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ChildPartitionsRecord child_partition = 2;</code>
   *
   * @return Whether the childPartition field is set.
   */
  boolean hasChildPartition();

  /**
   *
   *
   * <pre>
   * Child partitions record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ChildPartitionsRecord child_partition = 2;</code>
   *
   * @return The childPartition.
   */
  com.google.spanner.executor.v1.ChildPartitionsRecord getChildPartition();

  /**
   *
   *
   * <pre>
   * Child partitions record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ChildPartitionsRecord child_partition = 2;</code>
   */
  com.google.spanner.executor.v1.ChildPartitionsRecordOrBuilder getChildPartitionOrBuilder();

  /**
   *
   *
   * <pre>
   * Heartbeat record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.HeartbeatRecord heartbeat = 3;</code>
   *
   * @return Whether the heartbeat field is set.
   */
  boolean hasHeartbeat();

  /**
   *
   *
   * <pre>
   * Heartbeat record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.HeartbeatRecord heartbeat = 3;</code>
   *
   * @return The heartbeat.
   */
  com.google.spanner.executor.v1.HeartbeatRecord getHeartbeat();

  /**
   *
   *
   * <pre>
   * Heartbeat record.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.HeartbeatRecord heartbeat = 3;</code>
   */
  com.google.spanner.executor.v1.HeartbeatRecordOrBuilder getHeartbeatOrBuilder();

  com.google.spanner.executor.v1.ChangeStreamRecord.RecordCase getRecordCase();
}
