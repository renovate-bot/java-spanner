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

/**
 *
 *
 * <pre>
 * The request for
 * [UpdateInstance][google.spanner.admin.instance.v1.InstanceAdmin.UpdateInstance].
 * </pre>
 *
 * Protobuf type {@code google.spanner.admin.instance.v1.UpdateInstanceRequest}
 */
public final class UpdateInstanceRequest extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.spanner.admin.instance.v1.UpdateInstanceRequest)
    UpdateInstanceRequestOrBuilder {
  private static final long serialVersionUID = 0L;

  // Use UpdateInstanceRequest.newBuilder() to construct.
  private UpdateInstanceRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private UpdateInstanceRequest() {}

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new UpdateInstanceRequest();
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.spanner.admin.instance.v1.SpannerInstanceAdminProto
        .internal_static_google_spanner_admin_instance_v1_UpdateInstanceRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.spanner.admin.instance.v1.SpannerInstanceAdminProto
        .internal_static_google_spanner_admin_instance_v1_UpdateInstanceRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.spanner.admin.instance.v1.UpdateInstanceRequest.class,
            com.google.spanner.admin.instance.v1.UpdateInstanceRequest.Builder.class);
  }

  private int bitField0_;
  public static final int INSTANCE_FIELD_NUMBER = 1;
  private com.google.spanner.admin.instance.v1.Instance instance_;

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
  @java.lang.Override
  public boolean hasInstance() {
    return ((bitField0_ & 0x00000001) != 0);
  }

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
  @java.lang.Override
  public com.google.spanner.admin.instance.v1.Instance getInstance() {
    return instance_ == null
        ? com.google.spanner.admin.instance.v1.Instance.getDefaultInstance()
        : instance_;
  }

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
  @java.lang.Override
  public com.google.spanner.admin.instance.v1.InstanceOrBuilder getInstanceOrBuilder() {
    return instance_ == null
        ? com.google.spanner.admin.instance.v1.Instance.getDefaultInstance()
        : instance_;
  }

  public static final int FIELD_MASK_FIELD_NUMBER = 2;
  private com.google.protobuf.FieldMask fieldMask_;

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
  @java.lang.Override
  public boolean hasFieldMask() {
    return ((bitField0_ & 0x00000002) != 0);
  }

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
  @java.lang.Override
  public com.google.protobuf.FieldMask getFieldMask() {
    return fieldMask_ == null ? com.google.protobuf.FieldMask.getDefaultInstance() : fieldMask_;
  }

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
  @java.lang.Override
  public com.google.protobuf.FieldMaskOrBuilder getFieldMaskOrBuilder() {
    return fieldMask_ == null ? com.google.protobuf.FieldMask.getDefaultInstance() : fieldMask_;
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(1, getInstance());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getFieldMask());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, getInstance());
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getFieldMask());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.spanner.admin.instance.v1.UpdateInstanceRequest)) {
      return super.equals(obj);
    }
    com.google.spanner.admin.instance.v1.UpdateInstanceRequest other =
        (com.google.spanner.admin.instance.v1.UpdateInstanceRequest) obj;

    if (hasInstance() != other.hasInstance()) return false;
    if (hasInstance()) {
      if (!getInstance().equals(other.getInstance())) return false;
    }
    if (hasFieldMask() != other.hasFieldMask()) return false;
    if (hasFieldMask()) {
      if (!getFieldMask().equals(other.getFieldMask())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasInstance()) {
      hash = (37 * hash) + INSTANCE_FIELD_NUMBER;
      hash = (53 * hash) + getInstance().hashCode();
    }
    if (hasFieldMask()) {
      hash = (37 * hash) + FIELD_MASK_FIELD_NUMBER;
      hash = (53 * hash) + getFieldMask().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      java.nio.ByteBuffer data) throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(
      com.google.spanner.admin.instance.v1.UpdateInstanceRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }

  /**
   *
   *
   * <pre>
   * The request for
   * [UpdateInstance][google.spanner.admin.instance.v1.InstanceAdmin.UpdateInstance].
   * </pre>
   *
   * Protobuf type {@code google.spanner.admin.instance.v1.UpdateInstanceRequest}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.spanner.admin.instance.v1.UpdateInstanceRequest)
      com.google.spanner.admin.instance.v1.UpdateInstanceRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.spanner.admin.instance.v1.SpannerInstanceAdminProto
          .internal_static_google_spanner_admin_instance_v1_UpdateInstanceRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.spanner.admin.instance.v1.SpannerInstanceAdminProto
          .internal_static_google_spanner_admin_instance_v1_UpdateInstanceRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.spanner.admin.instance.v1.UpdateInstanceRequest.class,
              com.google.spanner.admin.instance.v1.UpdateInstanceRequest.Builder.class);
    }

    // Construct using com.google.spanner.admin.instance.v1.UpdateInstanceRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }

    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders) {
        getInstanceFieldBuilder();
        getFieldMaskFieldBuilder();
      }
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      instance_ = null;
      if (instanceBuilder_ != null) {
        instanceBuilder_.dispose();
        instanceBuilder_ = null;
      }
      fieldMask_ = null;
      if (fieldMaskBuilder_ != null) {
        fieldMaskBuilder_.dispose();
        fieldMaskBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.spanner.admin.instance.v1.SpannerInstanceAdminProto
          .internal_static_google_spanner_admin_instance_v1_UpdateInstanceRequest_descriptor;
    }

    @java.lang.Override
    public com.google.spanner.admin.instance.v1.UpdateInstanceRequest getDefaultInstanceForType() {
      return com.google.spanner.admin.instance.v1.UpdateInstanceRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.spanner.admin.instance.v1.UpdateInstanceRequest build() {
      com.google.spanner.admin.instance.v1.UpdateInstanceRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.spanner.admin.instance.v1.UpdateInstanceRequest buildPartial() {
      com.google.spanner.admin.instance.v1.UpdateInstanceRequest result =
          new com.google.spanner.admin.instance.v1.UpdateInstanceRequest(this);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.google.spanner.admin.instance.v1.UpdateInstanceRequest result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.instance_ = instanceBuilder_ == null ? instance_ : instanceBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.fieldMask_ = fieldMaskBuilder_ == null ? fieldMask_ : fieldMaskBuilder_.build();
        to_bitField0_ |= 0x00000002;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.spanner.admin.instance.v1.UpdateInstanceRequest) {
        return mergeFrom((com.google.spanner.admin.instance.v1.UpdateInstanceRequest) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.spanner.admin.instance.v1.UpdateInstanceRequest other) {
      if (other == com.google.spanner.admin.instance.v1.UpdateInstanceRequest.getDefaultInstance())
        return this;
      if (other.hasInstance()) {
        mergeInstance(other.getInstance());
      }
      if (other.hasFieldMask()) {
        mergeFieldMask(other.getFieldMask());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10:
              {
                input.readMessage(getInstanceFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000001;
                break;
              } // case 10
            case 18:
              {
                input.readMessage(getFieldMaskFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private com.google.spanner.admin.instance.v1.Instance instance_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.spanner.admin.instance.v1.Instance,
            com.google.spanner.admin.instance.v1.Instance.Builder,
            com.google.spanner.admin.instance.v1.InstanceOrBuilder>
        instanceBuilder_;

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
    public boolean hasInstance() {
      return ((bitField0_ & 0x00000001) != 0);
    }

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
    public com.google.spanner.admin.instance.v1.Instance getInstance() {
      if (instanceBuilder_ == null) {
        return instance_ == null
            ? com.google.spanner.admin.instance.v1.Instance.getDefaultInstance()
            : instance_;
      } else {
        return instanceBuilder_.getMessage();
      }
    }

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
    public Builder setInstance(com.google.spanner.admin.instance.v1.Instance value) {
      if (instanceBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        instance_ = value;
      } else {
        instanceBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

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
    public Builder setInstance(
        com.google.spanner.admin.instance.v1.Instance.Builder builderForValue) {
      if (instanceBuilder_ == null) {
        instance_ = builderForValue.build();
      } else {
        instanceBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

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
    public Builder mergeInstance(com.google.spanner.admin.instance.v1.Instance value) {
      if (instanceBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)
            && instance_ != null
            && instance_ != com.google.spanner.admin.instance.v1.Instance.getDefaultInstance()) {
          getInstanceBuilder().mergeFrom(value);
        } else {
          instance_ = value;
        }
      } else {
        instanceBuilder_.mergeFrom(value);
      }
      if (instance_ != null) {
        bitField0_ |= 0x00000001;
        onChanged();
      }
      return this;
    }

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
    public Builder clearInstance() {
      bitField0_ = (bitField0_ & ~0x00000001);
      instance_ = null;
      if (instanceBuilder_ != null) {
        instanceBuilder_.dispose();
        instanceBuilder_ = null;
      }
      onChanged();
      return this;
    }

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
    public com.google.spanner.admin.instance.v1.Instance.Builder getInstanceBuilder() {
      bitField0_ |= 0x00000001;
      onChanged();
      return getInstanceFieldBuilder().getBuilder();
    }

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
    public com.google.spanner.admin.instance.v1.InstanceOrBuilder getInstanceOrBuilder() {
      if (instanceBuilder_ != null) {
        return instanceBuilder_.getMessageOrBuilder();
      } else {
        return instance_ == null
            ? com.google.spanner.admin.instance.v1.Instance.getDefaultInstance()
            : instance_;
      }
    }

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
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.spanner.admin.instance.v1.Instance,
            com.google.spanner.admin.instance.v1.Instance.Builder,
            com.google.spanner.admin.instance.v1.InstanceOrBuilder>
        getInstanceFieldBuilder() {
      if (instanceBuilder_ == null) {
        instanceBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.spanner.admin.instance.v1.Instance,
                com.google.spanner.admin.instance.v1.Instance.Builder,
                com.google.spanner.admin.instance.v1.InstanceOrBuilder>(
                getInstance(), getParentForChildren(), isClean());
        instance_ = null;
      }
      return instanceBuilder_;
    }

    private com.google.protobuf.FieldMask fieldMask_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.FieldMask,
            com.google.protobuf.FieldMask.Builder,
            com.google.protobuf.FieldMaskOrBuilder>
        fieldMaskBuilder_;

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
    public boolean hasFieldMask() {
      return ((bitField0_ & 0x00000002) != 0);
    }

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
    public com.google.protobuf.FieldMask getFieldMask() {
      if (fieldMaskBuilder_ == null) {
        return fieldMask_ == null ? com.google.protobuf.FieldMask.getDefaultInstance() : fieldMask_;
      } else {
        return fieldMaskBuilder_.getMessage();
      }
    }

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
    public Builder setFieldMask(com.google.protobuf.FieldMask value) {
      if (fieldMaskBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        fieldMask_ = value;
      } else {
        fieldMaskBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

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
    public Builder setFieldMask(com.google.protobuf.FieldMask.Builder builderForValue) {
      if (fieldMaskBuilder_ == null) {
        fieldMask_ = builderForValue.build();
      } else {
        fieldMaskBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }

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
    public Builder mergeFieldMask(com.google.protobuf.FieldMask value) {
      if (fieldMaskBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)
            && fieldMask_ != null
            && fieldMask_ != com.google.protobuf.FieldMask.getDefaultInstance()) {
          getFieldMaskBuilder().mergeFrom(value);
        } else {
          fieldMask_ = value;
        }
      } else {
        fieldMaskBuilder_.mergeFrom(value);
      }
      if (fieldMask_ != null) {
        bitField0_ |= 0x00000002;
        onChanged();
      }
      return this;
    }

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
    public Builder clearFieldMask() {
      bitField0_ = (bitField0_ & ~0x00000002);
      fieldMask_ = null;
      if (fieldMaskBuilder_ != null) {
        fieldMaskBuilder_.dispose();
        fieldMaskBuilder_ = null;
      }
      onChanged();
      return this;
    }

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
    public com.google.protobuf.FieldMask.Builder getFieldMaskBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getFieldMaskFieldBuilder().getBuilder();
    }

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
    public com.google.protobuf.FieldMaskOrBuilder getFieldMaskOrBuilder() {
      if (fieldMaskBuilder_ != null) {
        return fieldMaskBuilder_.getMessageOrBuilder();
      } else {
        return fieldMask_ == null ? com.google.protobuf.FieldMask.getDefaultInstance() : fieldMask_;
      }
    }

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
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.protobuf.FieldMask,
            com.google.protobuf.FieldMask.Builder,
            com.google.protobuf.FieldMaskOrBuilder>
        getFieldMaskFieldBuilder() {
      if (fieldMaskBuilder_ == null) {
        fieldMaskBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.protobuf.FieldMask,
                com.google.protobuf.FieldMask.Builder,
                com.google.protobuf.FieldMaskOrBuilder>(
                getFieldMask(), getParentForChildren(), isClean());
        fieldMask_ = null;
      }
      return fieldMaskBuilder_;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.spanner.admin.instance.v1.UpdateInstanceRequest)
  }

  // @@protoc_insertion_point(class_scope:google.spanner.admin.instance.v1.UpdateInstanceRequest)
  private static final com.google.spanner.admin.instance.v1.UpdateInstanceRequest DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.spanner.admin.instance.v1.UpdateInstanceRequest();
  }

  public static com.google.spanner.admin.instance.v1.UpdateInstanceRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<UpdateInstanceRequest> PARSER =
      new com.google.protobuf.AbstractParser<UpdateInstanceRequest>() {
        @java.lang.Override
        public UpdateInstanceRequest parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<UpdateInstanceRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<UpdateInstanceRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.spanner.admin.instance.v1.UpdateInstanceRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
