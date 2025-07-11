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

public interface SpannerActionOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.executor.v1.SpannerAction)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Database against which to perform action.
   * In a context where a series of actions take place, an action may omit
   * database path if it applies to the same database as the previous action.
   * </pre>
   *
   * <code>string database_path = 1;</code>
   *
   * @return The databasePath.
   */
  java.lang.String getDatabasePath();

  /**
   *
   *
   * <pre>
   * Database against which to perform action.
   * In a context where a series of actions take place, an action may omit
   * database path if it applies to the same database as the previous action.
   * </pre>
   *
   * <code>string database_path = 1;</code>
   *
   * @return The bytes for databasePath.
   */
  com.google.protobuf.ByteString getDatabasePathBytes();

  /**
   *
   *
   * <pre>
   * Configuration options for Spanner backend
   * </pre>
   *
   * <code>.google.spanner.executor.v1.SpannerOptions spanner_options = 2;</code>
   *
   * @return Whether the spannerOptions field is set.
   */
  boolean hasSpannerOptions();

  /**
   *
   *
   * <pre>
   * Configuration options for Spanner backend
   * </pre>
   *
   * <code>.google.spanner.executor.v1.SpannerOptions spanner_options = 2;</code>
   *
   * @return The spannerOptions.
   */
  com.google.spanner.executor.v1.SpannerOptions getSpannerOptions();

  /**
   *
   *
   * <pre>
   * Configuration options for Spanner backend
   * </pre>
   *
   * <code>.google.spanner.executor.v1.SpannerOptions spanner_options = 2;</code>
   */
  com.google.spanner.executor.v1.SpannerOptionsOrBuilder getSpannerOptionsOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to start a transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.StartTransactionAction start = 10;</code>
   *
   * @return Whether the start field is set.
   */
  boolean hasStart();

  /**
   *
   *
   * <pre>
   * Action to start a transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.StartTransactionAction start = 10;</code>
   *
   * @return The start.
   */
  com.google.spanner.executor.v1.StartTransactionAction getStart();

  /**
   *
   *
   * <pre>
   * Action to start a transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.StartTransactionAction start = 10;</code>
   */
  com.google.spanner.executor.v1.StartTransactionActionOrBuilder getStartOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to finish a transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.FinishTransactionAction finish = 11;</code>
   *
   * @return Whether the finish field is set.
   */
  boolean hasFinish();

  /**
   *
   *
   * <pre>
   * Action to finish a transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.FinishTransactionAction finish = 11;</code>
   *
   * @return The finish.
   */
  com.google.spanner.executor.v1.FinishTransactionAction getFinish();

  /**
   *
   *
   * <pre>
   * Action to finish a transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.FinishTransactionAction finish = 11;</code>
   */
  com.google.spanner.executor.v1.FinishTransactionActionOrBuilder getFinishOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to do a normal read.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ReadAction read = 20;</code>
   *
   * @return Whether the read field is set.
   */
  boolean hasRead();

  /**
   *
   *
   * <pre>
   * Action to do a normal read.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ReadAction read = 20;</code>
   *
   * @return The read.
   */
  com.google.spanner.executor.v1.ReadAction getRead();

  /**
   *
   *
   * <pre>
   * Action to do a normal read.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ReadAction read = 20;</code>
   */
  com.google.spanner.executor.v1.ReadActionOrBuilder getReadOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to do a query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryAction query = 21;</code>
   *
   * @return Whether the query field is set.
   */
  boolean hasQuery();

  /**
   *
   *
   * <pre>
   * Action to do a query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryAction query = 21;</code>
   *
   * @return The query.
   */
  com.google.spanner.executor.v1.QueryAction getQuery();

  /**
   *
   *
   * <pre>
   * Action to do a query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryAction query = 21;</code>
   */
  com.google.spanner.executor.v1.QueryActionOrBuilder getQueryOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to buffer a mutation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.MutationAction mutation = 22;</code>
   *
   * @return Whether the mutation field is set.
   */
  boolean hasMutation();

  /**
   *
   *
   * <pre>
   * Action to buffer a mutation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.MutationAction mutation = 22;</code>
   *
   * @return The mutation.
   */
  com.google.spanner.executor.v1.MutationAction getMutation();

  /**
   *
   *
   * <pre>
   * Action to buffer a mutation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.MutationAction mutation = 22;</code>
   */
  com.google.spanner.executor.v1.MutationActionOrBuilder getMutationOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to a DML.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.DmlAction dml = 23;</code>
   *
   * @return Whether the dml field is set.
   */
  boolean hasDml();

  /**
   *
   *
   * <pre>
   * Action to a DML.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.DmlAction dml = 23;</code>
   *
   * @return The dml.
   */
  com.google.spanner.executor.v1.DmlAction getDml();

  /**
   *
   *
   * <pre>
   * Action to a DML.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.DmlAction dml = 23;</code>
   */
  com.google.spanner.executor.v1.DmlActionOrBuilder getDmlOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to a batch DML.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.BatchDmlAction batch_dml = 24;</code>
   *
   * @return Whether the batchDml field is set.
   */
  boolean hasBatchDml();

  /**
   *
   *
   * <pre>
   * Action to a batch DML.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.BatchDmlAction batch_dml = 24;</code>
   *
   * @return The batchDml.
   */
  com.google.spanner.executor.v1.BatchDmlAction getBatchDml();

  /**
   *
   *
   * <pre>
   * Action to a batch DML.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.BatchDmlAction batch_dml = 24;</code>
   */
  com.google.spanner.executor.v1.BatchDmlActionOrBuilder getBatchDmlOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to write a mutation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.WriteMutationsAction write = 25;</code>
   *
   * @return Whether the write field is set.
   */
  boolean hasWrite();

  /**
   *
   *
   * <pre>
   * Action to write a mutation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.WriteMutationsAction write = 25;</code>
   *
   * @return The write.
   */
  com.google.spanner.executor.v1.WriteMutationsAction getWrite();

  /**
   *
   *
   * <pre>
   * Action to write a mutation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.WriteMutationsAction write = 25;</code>
   */
  com.google.spanner.executor.v1.WriteMutationsActionOrBuilder getWriteOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to a partitioned update.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.PartitionedUpdateAction partitioned_update = 27;</code>
   *
   * @return Whether the partitionedUpdate field is set.
   */
  boolean hasPartitionedUpdate();

  /**
   *
   *
   * <pre>
   * Action to a partitioned update.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.PartitionedUpdateAction partitioned_update = 27;</code>
   *
   * @return The partitionedUpdate.
   */
  com.google.spanner.executor.v1.PartitionedUpdateAction getPartitionedUpdate();

  /**
   *
   *
   * <pre>
   * Action to a partitioned update.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.PartitionedUpdateAction partitioned_update = 27;</code>
   */
  com.google.spanner.executor.v1.PartitionedUpdateActionOrBuilder getPartitionedUpdateOrBuilder();

  /**
   *
   *
   * <pre>
   * Action that contains any administrative operation, like database,
   * instance manipulation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.AdminAction admin = 30;</code>
   *
   * @return Whether the admin field is set.
   */
  boolean hasAdmin();

  /**
   *
   *
   * <pre>
   * Action that contains any administrative operation, like database,
   * instance manipulation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.AdminAction admin = 30;</code>
   *
   * @return The admin.
   */
  com.google.spanner.executor.v1.AdminAction getAdmin();

  /**
   *
   *
   * <pre>
   * Action that contains any administrative operation, like database,
   * instance manipulation.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.AdminAction admin = 30;</code>
   */
  com.google.spanner.executor.v1.AdminActionOrBuilder getAdminOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to start a batch transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.StartBatchTransactionAction start_batch_txn = 40;</code>
   *
   * @return Whether the startBatchTxn field is set.
   */
  boolean hasStartBatchTxn();

  /**
   *
   *
   * <pre>
   * Action to start a batch transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.StartBatchTransactionAction start_batch_txn = 40;</code>
   *
   * @return The startBatchTxn.
   */
  com.google.spanner.executor.v1.StartBatchTransactionAction getStartBatchTxn();

  /**
   *
   *
   * <pre>
   * Action to start a batch transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.StartBatchTransactionAction start_batch_txn = 40;</code>
   */
  com.google.spanner.executor.v1.StartBatchTransactionActionOrBuilder getStartBatchTxnOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to close a batch transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.CloseBatchTransactionAction close_batch_txn = 41;</code>
   *
   * @return Whether the closeBatchTxn field is set.
   */
  boolean hasCloseBatchTxn();

  /**
   *
   *
   * <pre>
   * Action to close a batch transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.CloseBatchTransactionAction close_batch_txn = 41;</code>
   *
   * @return The closeBatchTxn.
   */
  com.google.spanner.executor.v1.CloseBatchTransactionAction getCloseBatchTxn();

  /**
   *
   *
   * <pre>
   * Action to close a batch transaction.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.CloseBatchTransactionAction close_batch_txn = 41;</code>
   */
  com.google.spanner.executor.v1.CloseBatchTransactionActionOrBuilder getCloseBatchTxnOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to generate database partitions for batch read.
   * </pre>
   *
   * <code>
   * .google.spanner.executor.v1.GenerateDbPartitionsForReadAction generate_db_partitions_read = 42;
   * </code>
   *
   * @return Whether the generateDbPartitionsRead field is set.
   */
  boolean hasGenerateDbPartitionsRead();

  /**
   *
   *
   * <pre>
   * Action to generate database partitions for batch read.
   * </pre>
   *
   * <code>
   * .google.spanner.executor.v1.GenerateDbPartitionsForReadAction generate_db_partitions_read = 42;
   * </code>
   *
   * @return The generateDbPartitionsRead.
   */
  com.google.spanner.executor.v1.GenerateDbPartitionsForReadAction getGenerateDbPartitionsRead();

  /**
   *
   *
   * <pre>
   * Action to generate database partitions for batch read.
   * </pre>
   *
   * <code>
   * .google.spanner.executor.v1.GenerateDbPartitionsForReadAction generate_db_partitions_read = 42;
   * </code>
   */
  com.google.spanner.executor.v1.GenerateDbPartitionsForReadActionOrBuilder
      getGenerateDbPartitionsReadOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to generate database partitions for batch query.
   * </pre>
   *
   * <code>
   * .google.spanner.executor.v1.GenerateDbPartitionsForQueryAction generate_db_partitions_query = 43;
   * </code>
   *
   * @return Whether the generateDbPartitionsQuery field is set.
   */
  boolean hasGenerateDbPartitionsQuery();

  /**
   *
   *
   * <pre>
   * Action to generate database partitions for batch query.
   * </pre>
   *
   * <code>
   * .google.spanner.executor.v1.GenerateDbPartitionsForQueryAction generate_db_partitions_query = 43;
   * </code>
   *
   * @return The generateDbPartitionsQuery.
   */
  com.google.spanner.executor.v1.GenerateDbPartitionsForQueryAction getGenerateDbPartitionsQuery();

  /**
   *
   *
   * <pre>
   * Action to generate database partitions for batch query.
   * </pre>
   *
   * <code>
   * .google.spanner.executor.v1.GenerateDbPartitionsForQueryAction generate_db_partitions_query = 43;
   * </code>
   */
  com.google.spanner.executor.v1.GenerateDbPartitionsForQueryActionOrBuilder
      getGenerateDbPartitionsQueryOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to execute batch actions on generated partitions.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ExecutePartitionAction execute_partition = 44;</code>
   *
   * @return Whether the executePartition field is set.
   */
  boolean hasExecutePartition();

  /**
   *
   *
   * <pre>
   * Action to execute batch actions on generated partitions.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ExecutePartitionAction execute_partition = 44;</code>
   *
   * @return The executePartition.
   */
  com.google.spanner.executor.v1.ExecutePartitionAction getExecutePartition();

  /**
   *
   *
   * <pre>
   * Action to execute batch actions on generated partitions.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ExecutePartitionAction execute_partition = 44;</code>
   */
  com.google.spanner.executor.v1.ExecutePartitionActionOrBuilder getExecutePartitionOrBuilder();

  /**
   *
   *
   * <pre>
   * Action to execute change stream query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ExecuteChangeStreamQuery execute_change_stream_query = 50;
   * </code>
   *
   * @return Whether the executeChangeStreamQuery field is set.
   */
  boolean hasExecuteChangeStreamQuery();

  /**
   *
   *
   * <pre>
   * Action to execute change stream query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ExecuteChangeStreamQuery execute_change_stream_query = 50;
   * </code>
   *
   * @return The executeChangeStreamQuery.
   */
  com.google.spanner.executor.v1.ExecuteChangeStreamQuery getExecuteChangeStreamQuery();

  /**
   *
   *
   * <pre>
   * Action to execute change stream query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.ExecuteChangeStreamQuery execute_change_stream_query = 50;
   * </code>
   */
  com.google.spanner.executor.v1.ExecuteChangeStreamQueryOrBuilder
      getExecuteChangeStreamQueryOrBuilder();

  /**
   *
   *
   * <pre>
   * Query cancellation action for testing the cancellation of a query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryCancellationAction query_cancellation = 51;</code>
   *
   * @return Whether the queryCancellation field is set.
   */
  boolean hasQueryCancellation();

  /**
   *
   *
   * <pre>
   * Query cancellation action for testing the cancellation of a query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryCancellationAction query_cancellation = 51;</code>
   *
   * @return The queryCancellation.
   */
  com.google.spanner.executor.v1.QueryCancellationAction getQueryCancellation();

  /**
   *
   *
   * <pre>
   * Query cancellation action for testing the cancellation of a query.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.QueryCancellationAction query_cancellation = 51;</code>
   */
  com.google.spanner.executor.v1.QueryCancellationActionOrBuilder getQueryCancellationOrBuilder();

  com.google.spanner.executor.v1.SpannerAction.ActionCase getActionCase();
}
