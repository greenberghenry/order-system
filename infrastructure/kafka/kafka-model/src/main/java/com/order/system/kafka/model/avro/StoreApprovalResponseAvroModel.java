/**
 * Autogenerated by Avro
 *
 * <p>DO NOT EDIT DIRECTLY
 */
package com.order.system.kafka.model.avro;

import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.SchemaStore;
import org.apache.avro.specific.SpecificData;

@org.apache.avro.specific.AvroGenerated
public class StoreApprovalResponseAvroModel extends org.apache.avro.specific.SpecificRecordBase
    implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -1659038641401101269L;

  public static final org.apache.avro.Schema SCHEMA$ =
      new org.apache.avro.Schema.Parser()
          .parse(
              "{\"type\":\"record\",\"name\":\"StoreApprovalResponseAvroModel\",\"namespace\":\"com.order.system.kafka.model.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"storeId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"orderId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"orderApprovalStatus\",\"type\":{\"type\":\"enum\",\"name\":\"OrderApprovalStatus\",\"symbols\":[\"APPROVED\",\"REJECTED\"]}},{\"name\":\"failureMessages\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}}]}");

  public static org.apache.avro.Schema getClassSchema() {
    return SCHEMA$;
  }

  private static final SpecificData MODEL$ = new SpecificData();

  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(
        new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
  }

  private static final BinaryMessageEncoder<StoreApprovalResponseAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<StoreApprovalResponseAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   *
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<StoreApprovalResponseAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   *
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<StoreApprovalResponseAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link
   * SchemaStore}.
   *
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<StoreApprovalResponseAvroModel> createDecoder(
      SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this StoreApprovalResponseAvroModel to a ByteBuffer.
   *
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a StoreApprovalResponseAvroModel from a ByteBuffer.
   *
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a StoreApprovalResponseAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of
   *     this class
   */
  public static StoreApprovalResponseAvroModel fromByteBuffer(java.nio.ByteBuffer b)
      throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID id;
  private java.util.UUID sagaId;
  private java.util.UUID storeId;
  private java.util.UUID orderId;
  private java.time.Instant createdAt;
  private com.order.system.kafka.model.avro.OrderApprovalStatus orderApprovalStatus;
  private java.util.List<java.lang.String> failureMessages;

  /**
   * Default constructor. Note that this does not initialize fields to their default values from the
   * schema. If that is desired then one should use <code>newBuilder()</code>.
   */
  public StoreApprovalResponseAvroModel() {}

  /**
   * All-args constructor.
   *
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param storeId The new value for storeId
   * @param orderId The new value for orderId
   * @param createdAt The new value for createdAt
   * @param orderApprovalStatus The new value for orderApprovalStatus
   * @param failureMessages The new value for failureMessages
   */
  public StoreApprovalResponseAvroModel(
      java.util.UUID id,
      java.util.UUID sagaId,
      java.util.UUID storeId,
      java.util.UUID orderId,
      java.time.Instant createdAt,
      com.order.system.kafka.model.avro.OrderApprovalStatus orderApprovalStatus,
      java.util.List<java.lang.String> failureMessages) {
    this.id = id;
    this.sagaId = sagaId;
    this.storeId = storeId;
    this.orderId = orderId;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.orderApprovalStatus = orderApprovalStatus;
    this.failureMessages = failureMessages;
  }

  @Override
  public org.apache.avro.specific.SpecificData getSpecificData() {
    return MODEL$;
  }

  @Override
  public org.apache.avro.Schema getSchema() {
    return SCHEMA$;
  }

  // Used by DatumWriter.  Applications should not call.
  @Override
  public java.lang.Object get(int field$) {
    switch (field$) {
      case 0:
        return id;
      case 1:
        return sagaId;
      case 2:
        return storeId;
      case 3:
        return orderId;
      case 4:
        return createdAt;
      case 5:
        return orderApprovalStatus;
      case 6:
        return failureMessages;
      default:
        throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  private static final org.apache.avro.Conversion<?>[] conversions =
      new org.apache.avro.Conversion<?>[] {
        new org.apache.avro.Conversions.UUIDConversion(),
        new org.apache.avro.Conversions.UUIDConversion(),
        new org.apache.avro.Conversions.UUIDConversion(),
        new org.apache.avro.Conversions.UUIDConversion(),
        new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
        null,
        null,
        null
      };

  @Override
  public org.apache.avro.Conversion<?> getConversion(int field) {
    return conversions[field];
  }

  // Used by DatumReader.  Applications should not call.
  @Override
  @SuppressWarnings(value = "unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
      case 0:
        id = (java.util.UUID) value$;
        break;
      case 1:
        sagaId = (java.util.UUID) value$;
        break;
      case 2:
        storeId = (java.util.UUID) value$;
        break;
      case 3:
        orderId = (java.util.UUID) value$;
        break;
      case 4:
        createdAt = (java.time.Instant) value$;
        break;
      case 5:
        orderApprovalStatus = (com.order.system.kafka.model.avro.OrderApprovalStatus) value$;
        break;
      case 6:
        failureMessages = (java.util.List<java.lang.String>) value$;
        break;
      default:
        throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'id' field.
   *
   * @return The value of the 'id' field.
   */
  public java.util.UUID getId() {
    return id;
  }

  /**
   * Sets the value of the 'id' field.
   *
   * @param value the value to set.
   */
  public void setId(java.util.UUID value) {
    this.id = value;
  }

  /**
   * Gets the value of the 'sagaId' field.
   *
   * @return The value of the 'sagaId' field.
   */
  public java.util.UUID getSagaId() {
    return sagaId;
  }

  /**
   * Sets the value of the 'sagaId' field.
   *
   * @param value the value to set.
   */
  public void setSagaId(java.util.UUID value) {
    this.sagaId = value;
  }

  /**
   * Gets the value of the 'storeId' field.
   *
   * @return The value of the 'storeId' field.
   */
  public java.util.UUID getStoreId() {
    return storeId;
  }

  /**
   * Sets the value of the 'storeId' field.
   *
   * @param value the value to set.
   */
  public void setStoreId(java.util.UUID value) {
    this.storeId = value;
  }

  /**
   * Gets the value of the 'orderId' field.
   *
   * @return The value of the 'orderId' field.
   */
  public java.util.UUID getOrderId() {
    return orderId;
  }

  /**
   * Sets the value of the 'orderId' field.
   *
   * @param value the value to set.
   */
  public void setOrderId(java.util.UUID value) {
    this.orderId = value;
  }

  /**
   * Gets the value of the 'createdAt' field.
   *
   * @return The value of the 'createdAt' field.
   */
  public java.time.Instant getCreatedAt() {
    return createdAt;
  }

  /**
   * Sets the value of the 'createdAt' field.
   *
   * @param value the value to set.
   */
  public void setCreatedAt(java.time.Instant value) {
    this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
  }

  /**
   * Gets the value of the 'orderApprovalStatus' field.
   *
   * @return The value of the 'orderApprovalStatus' field.
   */
  public com.order.system.kafka.model.avro.OrderApprovalStatus getOrderApprovalStatus() {
    return orderApprovalStatus;
  }

  /**
   * Sets the value of the 'orderApprovalStatus' field.
   *
   * @param value the value to set.
   */
  public void setOrderApprovalStatus(com.order.system.kafka.model.avro.OrderApprovalStatus value) {
    this.orderApprovalStatus = value;
  }

  /**
   * Gets the value of the 'failureMessages' field.
   *
   * @return The value of the 'failureMessages' field.
   */
  public java.util.List<java.lang.String> getFailureMessages() {
    return failureMessages;
  }

  /**
   * Sets the value of the 'failureMessages' field.
   *
   * @param value the value to set.
   */
  public void setFailureMessages(java.util.List<java.lang.String> value) {
    this.failureMessages = value;
  }

  /**
   * Creates a new StoreApprovalResponseAvroModel RecordBuilder.
   *
   * @return A new StoreApprovalResponseAvroModel RecordBuilder
   */
  public static com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder
      newBuilder() {
    return new com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder();
  }

  /**
   * Creates a new StoreApprovalResponseAvroModel RecordBuilder by copying an existing Builder.
   *
   * @param other The existing builder to copy.
   * @return A new StoreApprovalResponseAvroModel RecordBuilder
   */
  public static com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder newBuilder(
      com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder other) {
    if (other == null) {
      return new com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder();
    } else {
      return new com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new StoreApprovalResponseAvroModel RecordBuilder by copying an existing
   * StoreApprovalResponseAvroModel instance.
   *
   * @param other The existing instance to copy.
   * @return A new StoreApprovalResponseAvroModel RecordBuilder
   */
  public static com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder newBuilder(
      com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel other) {
    if (other == null) {
      return new com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder();
    } else {
      return new com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder(other);
    }
  }

  /** RecordBuilder for StoreApprovalResponseAvroModel instances. */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder
      extends org.apache.avro.specific.SpecificRecordBuilderBase<StoreApprovalResponseAvroModel>
      implements org.apache.avro.data.RecordBuilder<StoreApprovalResponseAvroModel> {

    private java.util.UUID id;
    private java.util.UUID sagaId;
    private java.util.UUID storeId;
    private java.util.UUID orderId;
    private java.time.Instant createdAt;
    private com.order.system.kafka.model.avro.OrderApprovalStatus orderApprovalStatus;
    private java.util.List<java.lang.String> failureMessages;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     *
     * @param other The existing Builder to copy.
     */
    private Builder(
        com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.storeId)) {
        this.storeId = data().deepCopy(fields()[2].schema(), other.storeId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.orderId)) {
        this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.orderApprovalStatus)) {
        this.orderApprovalStatus = data().deepCopy(fields()[5].schema(), other.orderApprovalStatus);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.failureMessages)) {
        this.failureMessages = data().deepCopy(fields()[6].schema(), other.failureMessages);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing StoreApprovalResponseAvroModel instance
     *
     * @param other The existing instance to copy.
     */
    private Builder(com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.storeId)) {
        this.storeId = data().deepCopy(fields()[2].schema(), other.storeId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.orderId)) {
        this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[4].schema(), other.createdAt);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.orderApprovalStatus)) {
        this.orderApprovalStatus = data().deepCopy(fields()[5].schema(), other.orderApprovalStatus);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.failureMessages)) {
        this.failureMessages = data().deepCopy(fields()[6].schema(), other.failureMessages);
        fieldSetFlags()[6] = true;
      }
    }

    /**
     * Gets the value of the 'id' field.
     *
     * @return The value.
     */
    public java.util.UUID getId() {
      return id;
    }

    /**
     * Sets the value of the 'id' field.
     *
     * @param value The value of 'id'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder setId(
        java.util.UUID value) {
      validate(fields()[0], value);
      this.id = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
     * Checks whether the 'id' field has been set.
     *
     * @return True if the 'id' field has been set, false otherwise.
     */
    public boolean hasId() {
      return fieldSetFlags()[0];
    }

    /**
     * Clears the value of the 'id' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder clearId() {
      id = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
     * Gets the value of the 'sagaId' field.
     *
     * @return The value.
     */
    public java.util.UUID getSagaId() {
      return sagaId;
    }

    /**
     * Sets the value of the 'sagaId' field.
     *
     * @param value The value of 'sagaId'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder setSagaId(
        java.util.UUID value) {
      validate(fields()[1], value);
      this.sagaId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
     * Checks whether the 'sagaId' field has been set.
     *
     * @return True if the 'sagaId' field has been set, false otherwise.
     */
    public boolean hasSagaId() {
      return fieldSetFlags()[1];
    }

    /**
     * Clears the value of the 'sagaId' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
     * Gets the value of the 'storeId' field.
     *
     * @return The value.
     */
    public java.util.UUID getStoreId() {
      return storeId;
    }

    /**
     * Sets the value of the 'storeId' field.
     *
     * @param value The value of 'storeId'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder setStoreId(
        java.util.UUID value) {
      validate(fields()[2], value);
      this.storeId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
     * Checks whether the 'storeId' field has been set.
     *
     * @return True if the 'storeId' field has been set, false otherwise.
     */
    public boolean hasStoreId() {
      return fieldSetFlags()[2];
    }

    /**
     * Clears the value of the 'storeId' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder clearStoreId() {
      storeId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
     * Gets the value of the 'orderId' field.
     *
     * @return The value.
     */
    public java.util.UUID getOrderId() {
      return orderId;
    }

    /**
     * Sets the value of the 'orderId' field.
     *
     * @param value The value of 'orderId'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder setOrderId(
        java.util.UUID value) {
      validate(fields()[3], value);
      this.orderId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
     * Checks whether the 'orderId' field has been set.
     *
     * @return True if the 'orderId' field has been set, false otherwise.
     */
    public boolean hasOrderId() {
      return fieldSetFlags()[3];
    }

    /**
     * Clears the value of the 'orderId' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder clearOrderId() {
      orderId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
     * Gets the value of the 'createdAt' field.
     *
     * @return The value.
     */
    public java.time.Instant getCreatedAt() {
      return createdAt;
    }

    /**
     * Sets the value of the 'createdAt' field.
     *
     * @param value The value of 'createdAt'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder setCreatedAt(
        java.time.Instant value) {
      validate(fields()[4], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
     * Checks whether the 'createdAt' field has been set.
     *
     * @return True if the 'createdAt' field has been set, false otherwise.
     */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[4];
    }

    /**
     * Clears the value of the 'createdAt' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder
        clearCreatedAt() {
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
     * Gets the value of the 'orderApprovalStatus' field.
     *
     * @return The value.
     */
    public com.order.system.kafka.model.avro.OrderApprovalStatus getOrderApprovalStatus() {
      return orderApprovalStatus;
    }

    /**
     * Sets the value of the 'orderApprovalStatus' field.
     *
     * @param value The value of 'orderApprovalStatus'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder
        setOrderApprovalStatus(com.order.system.kafka.model.avro.OrderApprovalStatus value) {
      validate(fields()[5], value);
      this.orderApprovalStatus = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
     * Checks whether the 'orderApprovalStatus' field has been set.
     *
     * @return True if the 'orderApprovalStatus' field has been set, false otherwise.
     */
    public boolean hasOrderApprovalStatus() {
      return fieldSetFlags()[5];
    }

    /**
     * Clears the value of the 'orderApprovalStatus' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder
        clearOrderApprovalStatus() {
      orderApprovalStatus = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
     * Gets the value of the 'failureMessages' field.
     *
     * @return The value.
     */
    public java.util.List<java.lang.String> getFailureMessages() {
      return failureMessages;
    }

    /**
     * Sets the value of the 'failureMessages' field.
     *
     * @param value The value of 'failureMessages'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder
        setFailureMessages(java.util.List<java.lang.String> value) {
      validate(fields()[6], value);
      this.failureMessages = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
     * Checks whether the 'failureMessages' field has been set.
     *
     * @return True if the 'failureMessages' field has been set, false otherwise.
     */
    public boolean hasFailureMessages() {
      return fieldSetFlags()[6];
    }

    /**
     * Clears the value of the 'failureMessages' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel.Builder
        clearFailureMessages() {
      failureMessages = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StoreApprovalResponseAvroModel build() {
      try {
        StoreApprovalResponseAvroModel record = new StoreApprovalResponseAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.sagaId =
            fieldSetFlags()[1] ? this.sagaId : (java.util.UUID) defaultValue(fields()[1]);
        record.storeId =
            fieldSetFlags()[2] ? this.storeId : (java.util.UUID) defaultValue(fields()[2]);
        record.orderId =
            fieldSetFlags()[3] ? this.orderId : (java.util.UUID) defaultValue(fields()[3]);
        record.createdAt =
            fieldSetFlags()[4] ? this.createdAt : (java.time.Instant) defaultValue(fields()[4]);
        record.orderApprovalStatus =
            fieldSetFlags()[5]
                ? this.orderApprovalStatus
                : (com.order.system.kafka.model.avro.OrderApprovalStatus) defaultValue(fields()[5]);
        record.failureMessages =
            fieldSetFlags()[6]
                ? this.failureMessages
                : (java.util.List<java.lang.String>) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<StoreApprovalResponseAvroModel> WRITER$ =
      (org.apache.avro.io.DatumWriter<StoreApprovalResponseAvroModel>)
          MODEL$.createDatumWriter(SCHEMA$);

  @Override
  public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<StoreApprovalResponseAvroModel> READER$ =
      (org.apache.avro.io.DatumReader<StoreApprovalResponseAvroModel>)
          MODEL$.createDatumReader(SCHEMA$);

  @Override
  public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }
}
