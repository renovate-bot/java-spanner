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
// source: google/spanner/v1/change_stream.proto

// Protobuf Java Version: 3.25.8
package com.google.spanner.v1;

public interface ChangeStreamRecordOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.v1.ChangeStreamRecord)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Data change record describing a data change for a change stream
   * partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.DataChangeRecord data_change_record = 1;</code>
   *
   * @return Whether the dataChangeRecord field is set.
   */
  boolean hasDataChangeRecord();

  /**
   *
   *
   * <pre>
   * Data change record describing a data change for a change stream
   * partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.DataChangeRecord data_change_record = 1;</code>
   *
   * @return The dataChangeRecord.
   */
  com.google.spanner.v1.ChangeStreamRecord.DataChangeRecord getDataChangeRecord();

  /**
   *
   *
   * <pre>
   * Data change record describing a data change for a change stream
   * partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.DataChangeRecord data_change_record = 1;</code>
   */
  com.google.spanner.v1.ChangeStreamRecord.DataChangeRecordOrBuilder getDataChangeRecordOrBuilder();

  /**
   *
   *
   * <pre>
   * Heartbeat record describing a heartbeat for a change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.HeartbeatRecord heartbeat_record = 2;</code>
   *
   * @return Whether the heartbeatRecord field is set.
   */
  boolean hasHeartbeatRecord();

  /**
   *
   *
   * <pre>
   * Heartbeat record describing a heartbeat for a change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.HeartbeatRecord heartbeat_record = 2;</code>
   *
   * @return The heartbeatRecord.
   */
  com.google.spanner.v1.ChangeStreamRecord.HeartbeatRecord getHeartbeatRecord();

  /**
   *
   *
   * <pre>
   * Heartbeat record describing a heartbeat for a change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.HeartbeatRecord heartbeat_record = 2;</code>
   */
  com.google.spanner.v1.ChangeStreamRecord.HeartbeatRecordOrBuilder getHeartbeatRecordOrBuilder();

  /**
   *
   *
   * <pre>
   * Partition start record describing a new change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionStartRecord partition_start_record = 3;
   * </code>
   *
   * @return Whether the partitionStartRecord field is set.
   */
  boolean hasPartitionStartRecord();

  /**
   *
   *
   * <pre>
   * Partition start record describing a new change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionStartRecord partition_start_record = 3;
   * </code>
   *
   * @return The partitionStartRecord.
   */
  com.google.spanner.v1.ChangeStreamRecord.PartitionStartRecord getPartitionStartRecord();

  /**
   *
   *
   * <pre>
   * Partition start record describing a new change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionStartRecord partition_start_record = 3;
   * </code>
   */
  com.google.spanner.v1.ChangeStreamRecord.PartitionStartRecordOrBuilder
      getPartitionStartRecordOrBuilder();

  /**
   *
   *
   * <pre>
   * Partition end record describing a terminated change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionEndRecord partition_end_record = 4;</code>
   *
   * @return Whether the partitionEndRecord field is set.
   */
  boolean hasPartitionEndRecord();

  /**
   *
   *
   * <pre>
   * Partition end record describing a terminated change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionEndRecord partition_end_record = 4;</code>
   *
   * @return The partitionEndRecord.
   */
  com.google.spanner.v1.ChangeStreamRecord.PartitionEndRecord getPartitionEndRecord();

  /**
   *
   *
   * <pre>
   * Partition end record describing a terminated change stream partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionEndRecord partition_end_record = 4;</code>
   */
  com.google.spanner.v1.ChangeStreamRecord.PartitionEndRecordOrBuilder
      getPartitionEndRecordOrBuilder();

  /**
   *
   *
   * <pre>
   * Partition event record describing key range changes for a change stream
   * partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionEventRecord partition_event_record = 5;
   * </code>
   *
   * @return Whether the partitionEventRecord field is set.
   */
  boolean hasPartitionEventRecord();

  /**
   *
   *
   * <pre>
   * Partition event record describing key range changes for a change stream
   * partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionEventRecord partition_event_record = 5;
   * </code>
   *
   * @return The partitionEventRecord.
   */
  com.google.spanner.v1.ChangeStreamRecord.PartitionEventRecord getPartitionEventRecord();

  /**
   *
   *
   * <pre>
   * Partition event record describing key range changes for a change stream
   * partition.
   * </pre>
   *
   * <code>.google.spanner.v1.ChangeStreamRecord.PartitionEventRecord partition_event_record = 5;
   * </code>
   */
  com.google.spanner.v1.ChangeStreamRecord.PartitionEventRecordOrBuilder
      getPartitionEventRecordOrBuilder();

  com.google.spanner.v1.ChangeStreamRecord.RecordCase getRecordCase();
}
