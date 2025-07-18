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
// source: google/spanner/admin/instance/v1/spanner_instance_admin.proto

// Protobuf Java Version: 3.25.8
package com.google.spanner.admin.instance.v1;

public interface ListInstanceConfigOperationsResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.instance.v1.ListInstanceConfigOperationsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The list of matching instance configuration long-running operations. Each
   * operation's name will be
   * prefixed by the name of the instance configuration. The operation's
   * metadata field type
   * `metadata.type_url` describes the type of the metadata.
   * </pre>
   *
   * <code>repeated .google.longrunning.Operation operations = 1;</code>
   */
  java.util.List<com.google.longrunning.Operation> getOperationsList();

  /**
   *
   *
   * <pre>
   * The list of matching instance configuration long-running operations. Each
   * operation's name will be
   * prefixed by the name of the instance configuration. The operation's
   * metadata field type
   * `metadata.type_url` describes the type of the metadata.
   * </pre>
   *
   * <code>repeated .google.longrunning.Operation operations = 1;</code>
   */
  com.google.longrunning.Operation getOperations(int index);

  /**
   *
   *
   * <pre>
   * The list of matching instance configuration long-running operations. Each
   * operation's name will be
   * prefixed by the name of the instance configuration. The operation's
   * metadata field type
   * `metadata.type_url` describes the type of the metadata.
   * </pre>
   *
   * <code>repeated .google.longrunning.Operation operations = 1;</code>
   */
  int getOperationsCount();

  /**
   *
   *
   * <pre>
   * The list of matching instance configuration long-running operations. Each
   * operation's name will be
   * prefixed by the name of the instance configuration. The operation's
   * metadata field type
   * `metadata.type_url` describes the type of the metadata.
   * </pre>
   *
   * <code>repeated .google.longrunning.Operation operations = 1;</code>
   */
  java.util.List<? extends com.google.longrunning.OperationOrBuilder> getOperationsOrBuilderList();

  /**
   *
   *
   * <pre>
   * The list of matching instance configuration long-running operations. Each
   * operation's name will be
   * prefixed by the name of the instance configuration. The operation's
   * metadata field type
   * `metadata.type_url` describes the type of the metadata.
   * </pre>
   *
   * <code>repeated .google.longrunning.Operation operations = 1;</code>
   */
  com.google.longrunning.OperationOrBuilder getOperationsOrBuilder(int index);

  /**
   *
   *
   * <pre>
   * `next_page_token` can be sent in a subsequent
   * [ListInstanceConfigOperations][google.spanner.admin.instance.v1.InstanceAdmin.ListInstanceConfigOperations]
   * call to fetch more of the matching metadata.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The nextPageToken.
   */
  java.lang.String getNextPageToken();

  /**
   *
   *
   * <pre>
   * `next_page_token` can be sent in a subsequent
   * [ListInstanceConfigOperations][google.spanner.admin.instance.v1.InstanceAdmin.ListInstanceConfigOperations]
   * call to fetch more of the matching metadata.
   * </pre>
   *
   * <code>string next_page_token = 2;</code>
   *
   * @return The bytes for nextPageToken.
   */
  com.google.protobuf.ByteString getNextPageTokenBytes();
}
