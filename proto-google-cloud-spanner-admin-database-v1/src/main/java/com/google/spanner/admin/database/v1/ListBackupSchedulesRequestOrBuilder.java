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
// source: google/spanner/admin/database/v1/backup_schedule.proto

// Protobuf Java Version: 3.25.8
package com.google.spanner.admin.database.v1;

public interface ListBackupSchedulesRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.database.v1.ListBackupSchedulesRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. Database is the parent resource whose backup schedules should be
   * listed. Values are of the form
   * projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The parent.
   */
  java.lang.String getParent();

  /**
   *
   *
   * <pre>
   * Required. Database is the parent resource whose backup schedules should be
   * listed. Values are of the form
   * projects/&lt;project&gt;/instances/&lt;instance&gt;/databases/&lt;database&gt;
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * Optional. Number of backup schedules to be returned in the response. If 0
   * or less, defaults to the server's maximum allowed page size.
   * </pre>
   *
   * <code>int32 page_size = 2 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The pageSize.
   */
  int getPageSize();

  /**
   *
   *
   * <pre>
   * Optional. If non-empty, `page_token` should contain a
   * [next_page_token][google.spanner.admin.database.v1.ListBackupSchedulesResponse.next_page_token]
   * from a previous
   * [ListBackupSchedulesResponse][google.spanner.admin.database.v1.ListBackupSchedulesResponse]
   * to the same `parent`.
   * </pre>
   *
   * <code>string page_token = 4 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The pageToken.
   */
  java.lang.String getPageToken();

  /**
   *
   *
   * <pre>
   * Optional. If non-empty, `page_token` should contain a
   * [next_page_token][google.spanner.admin.database.v1.ListBackupSchedulesResponse.next_page_token]
   * from a previous
   * [ListBackupSchedulesResponse][google.spanner.admin.database.v1.ListBackupSchedulesResponse]
   * to the same `parent`.
   * </pre>
   *
   * <code>string page_token = 4 [(.google.api.field_behavior) = OPTIONAL];</code>
   *
   * @return The bytes for pageToken.
   */
  com.google.protobuf.ByteString getPageTokenBytes();
}
