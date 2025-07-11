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

public interface UpdateInstanceRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.instance.v1.UpdateInstanceRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The instance to update, which must always include the instance
   * name.  Otherwise, only fields mentioned in
   * [field_mask][google.spanner.admin.instance.v1.UpdateInstanceRequest.field_mask]
   * need be included.
   * </pre>
   *
   * <code>
   * .google.spanner.admin.instance.v1.Instance instance = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return Whether the instance field is set.
   */
  boolean hasInstance();

  /**
   *
   *
   * <pre>
   * Required. The instance to update, which must always include the instance
   * name.  Otherwise, only fields mentioned in
   * [field_mask][google.spanner.admin.instance.v1.UpdateInstanceRequest.field_mask]
   * need be included.
   * </pre>
   *
   * <code>
   * .google.spanner.admin.instance.v1.Instance instance = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The instance.
   */
  com.google.spanner.admin.instance.v1.Instance getInstance();

  /**
   *
   *
   * <pre>
   * Required. The instance to update, which must always include the instance
   * name.  Otherwise, only fields mentioned in
   * [field_mask][google.spanner.admin.instance.v1.UpdateInstanceRequest.field_mask]
   * need be included.
   * </pre>
   *
   * <code>
   * .google.spanner.admin.instance.v1.Instance instance = 1 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.spanner.admin.instance.v1.InstanceOrBuilder getInstanceOrBuilder();

  /**
   *
   *
   * <pre>
   * Required. A mask specifying which fields in
   * [Instance][google.spanner.admin.instance.v1.Instance] should be updated.
   * The field mask must always be specified; this prevents any future fields in
   * [Instance][google.spanner.admin.instance.v1.Instance] from being erased
   * accidentally by clients that do not know about them.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask field_mask = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return Whether the fieldMask field is set.
   */
  boolean hasFieldMask();

  /**
   *
   *
   * <pre>
   * Required. A mask specifying which fields in
   * [Instance][google.spanner.admin.instance.v1.Instance] should be updated.
   * The field mask must always be specified; this prevents any future fields in
   * [Instance][google.spanner.admin.instance.v1.Instance] from being erased
   * accidentally by clients that do not know about them.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask field_mask = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   *
   * @return The fieldMask.
   */
  com.google.protobuf.FieldMask getFieldMask();

  /**
   *
   *
   * <pre>
   * Required. A mask specifying which fields in
   * [Instance][google.spanner.admin.instance.v1.Instance] should be updated.
   * The field mask must always be specified; this prevents any future fields in
   * [Instance][google.spanner.admin.instance.v1.Instance] from being erased
   * accidentally by clients that do not know about them.
   * </pre>
   *
   * <code>.google.protobuf.FieldMask field_mask = 2 [(.google.api.field_behavior) = REQUIRED];
   * </code>
   */
  com.google.protobuf.FieldMaskOrBuilder getFieldMaskOrBuilder();
}
