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
public class PaymentRequestAvroModel extends org.apache.avro.specific.SpecificRecordBase
    implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2236831685046599644L;

  public static final org.apache.avro.Schema SCHEMA$ =
      new org.apache.avro.Schema.Parser()
          .parse(
              "{\"type\":\"record\",\"name\":\"PaymentRequestAvroModel\",\"namespace\":\"com.order.system.kafka.model.avro\",\"fields\":[{\"name\":\"id\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"sagaId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"customerId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"orderId\",\"type\":{\"type\":\"string\",\"logicalType\":\"uuid\"}},{\"name\":\"price\",\"type\":{\"type\":\"bytes\",\"logicalType\":\"decimal\",\"precision\":10,\"scale\":2}},{\"name\":\"createdAt\",\"type\":{\"type\":\"long\",\"logicalType\":\"timestamp-millis\"}},{\"name\":\"orderStatus\",\"type\":{\"type\":\"enum\",\"name\":\"OrderStatus\",\"symbols\":[\"PENDING\",\"CANCELLED\"]}}]}");

  public static org.apache.avro.Schema getClassSchema() {
    return SCHEMA$;
  }

  private static final SpecificData MODEL$ = new SpecificData();

  static {
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.UUIDConversion());
    MODEL$.addLogicalTypeConversion(
        new org.apache.avro.data.TimeConversions.TimestampMillisConversion());
    MODEL$.addLogicalTypeConversion(new org.apache.avro.Conversions.DecimalConversion());
  }

  private static final BinaryMessageEncoder<PaymentRequestAvroModel> ENCODER =
      new BinaryMessageEncoder<>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<PaymentRequestAvroModel> DECODER =
      new BinaryMessageDecoder<>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   *
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<PaymentRequestAvroModel> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   *
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<PaymentRequestAvroModel> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link
   * SchemaStore}.
   *
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<PaymentRequestAvroModel> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this PaymentRequestAvroModel to a ByteBuffer.
   *
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a PaymentRequestAvroModel from a ByteBuffer.
   *
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a PaymentRequestAvroModel instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of
   *     this class
   */
  public static PaymentRequestAvroModel fromByteBuffer(java.nio.ByteBuffer b)
      throws java.io.IOException {
    return DECODER.decode(b);
  }

  private java.util.UUID id;
  private java.util.UUID sagaId;
  private java.util.UUID customerId;
  private java.util.UUID orderId;
  private java.math.BigDecimal price;
  private java.time.Instant createdAt;
  private com.order.system.kafka.model.avro.OrderStatus orderStatus;

  /**
   * Default constructor. Note that this does not initialize fields to their default values from the
   * schema. If that is desired then one should use <code>newBuilder()</code>.
   */
  public PaymentRequestAvroModel() {}

  /**
   * All-args constructor.
   *
   * @param id The new value for id
   * @param sagaId The new value for sagaId
   * @param customerId The new value for customerId
   * @param orderId The new value for orderId
   * @param price The new value for price
   * @param createdAt The new value for createdAt
   * @param orderStatus The new value for orderStatus
   */
  public PaymentRequestAvroModel(
      java.util.UUID id,
      java.util.UUID sagaId,
      java.util.UUID customerId,
      java.util.UUID orderId,
      java.math.BigDecimal price,
      java.time.Instant createdAt,
      com.order.system.kafka.model.avro.OrderStatus orderStatus) {
    this.id = id;
    this.sagaId = sagaId;
    this.customerId = customerId;
    this.orderId = orderId;
    this.price = price;
    this.createdAt = createdAt.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
    this.orderStatus = orderStatus;
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
        return customerId;
      case 3:
        return orderId;
      case 4:
        return price;
      case 5:
        return createdAt;
      case 6:
        return orderStatus;
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
        new org.apache.avro.Conversions.DecimalConversion(),
        new org.apache.avro.data.TimeConversions.TimestampMillisConversion(),
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
        customerId = (java.util.UUID) value$;
        break;
      case 3:
        orderId = (java.util.UUID) value$;
        break;
      case 4:
        price = (java.math.BigDecimal) value$;
        break;
      case 5:
        createdAt = (java.time.Instant) value$;
        break;
      case 6:
        orderStatus = (com.order.system.kafka.model.avro.OrderStatus) value$;
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
   * Gets the value of the 'customerId' field.
   *
   * @return The value of the 'customerId' field.
   */
  public java.util.UUID getCustomerId() {
    return customerId;
  }

  /**
   * Sets the value of the 'customerId' field.
   *
   * @param value the value to set.
   */
  public void setCustomerId(java.util.UUID value) {
    this.customerId = value;
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
   * Gets the value of the 'price' field.
   *
   * @return The value of the 'price' field.
   */
  public java.math.BigDecimal getPrice() {
    return price;
  }

  /**
   * Sets the value of the 'price' field.
   *
   * @param value the value to set.
   */
  public void setPrice(java.math.BigDecimal value) {
    this.price = value;
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
   * Gets the value of the 'orderStatus' field.
   *
   * @return The value of the 'orderStatus' field.
   */
  public com.order.system.kafka.model.avro.OrderStatus getOrderStatus() {
    return orderStatus;
  }

  /**
   * Sets the value of the 'orderStatus' field.
   *
   * @param value the value to set.
   */
  public void setOrderStatus(com.order.system.kafka.model.avro.OrderStatus value) {
    this.orderStatus = value;
  }

  /**
   * Creates a new PaymentRequestAvroModel RecordBuilder.
   *
   * @return A new PaymentRequestAvroModel RecordBuilder
   */
  public static com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder newBuilder() {
    return new com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder();
  }

  /**
   * Creates a new PaymentRequestAvroModel RecordBuilder by copying an existing Builder.
   *
   * @param other The existing builder to copy.
   * @return A new PaymentRequestAvroModel RecordBuilder
   */
  public static com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder newBuilder(
      com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder other) {
    if (other == null) {
      return new com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder();
    } else {
      return new com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder(other);
    }
  }

  /**
   * Creates a new PaymentRequestAvroModel RecordBuilder by copying an existing
   * PaymentRequestAvroModel instance.
   *
   * @param other The existing instance to copy.
   * @return A new PaymentRequestAvroModel RecordBuilder
   */
  public static com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder newBuilder(
      com.order.system.kafka.model.avro.PaymentRequestAvroModel other) {
    if (other == null) {
      return new com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder();
    } else {
      return new com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder(other);
    }
  }

  /** RecordBuilder for PaymentRequestAvroModel instances. */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder
      extends org.apache.avro.specific.SpecificRecordBuilderBase<PaymentRequestAvroModel>
      implements org.apache.avro.data.RecordBuilder<PaymentRequestAvroModel> {

    private java.util.UUID id;
    private java.util.UUID sagaId;
    private java.util.UUID customerId;
    private java.util.UUID orderId;
    private java.math.BigDecimal price;
    private java.time.Instant createdAt;
    private com.order.system.kafka.model.avro.OrderStatus orderStatus;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$, MODEL$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     *
     * @param other The existing Builder to copy.
     */
    private Builder(com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.customerId)) {
        this.customerId = data().deepCopy(fields()[2].schema(), other.customerId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.orderId)) {
        this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.price)) {
        this.price = data().deepCopy(fields()[4].schema(), other.price);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
      if (isValidValue(fields()[5], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[5].schema(), other.createdAt);
        fieldSetFlags()[5] = other.fieldSetFlags()[5];
      }
      if (isValidValue(fields()[6], other.orderStatus)) {
        this.orderStatus = data().deepCopy(fields()[6].schema(), other.orderStatus);
        fieldSetFlags()[6] = other.fieldSetFlags()[6];
      }
    }

    /**
     * Creates a Builder by copying an existing PaymentRequestAvroModel instance
     *
     * @param other The existing instance to copy.
     */
    private Builder(com.order.system.kafka.model.avro.PaymentRequestAvroModel other) {
      super(SCHEMA$, MODEL$);
      if (isValidValue(fields()[0], other.id)) {
        this.id = data().deepCopy(fields()[0].schema(), other.id);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.sagaId)) {
        this.sagaId = data().deepCopy(fields()[1].schema(), other.sagaId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.customerId)) {
        this.customerId = data().deepCopy(fields()[2].schema(), other.customerId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.orderId)) {
        this.orderId = data().deepCopy(fields()[3].schema(), other.orderId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.price)) {
        this.price = data().deepCopy(fields()[4].schema(), other.price);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.createdAt)) {
        this.createdAt = data().deepCopy(fields()[5].schema(), other.createdAt);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.orderStatus)) {
        this.orderStatus = data().deepCopy(fields()[6].schema(), other.orderStatus);
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setId(
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearId() {
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setSagaId(
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearSagaId() {
      sagaId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
     * Gets the value of the 'customerId' field.
     *
     * @return The value.
     */
    public java.util.UUID getCustomerId() {
      return customerId;
    }

    /**
     * Sets the value of the 'customerId' field.
     *
     * @param value The value of 'customerId'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setCustomerId(
        java.util.UUID value) {
      validate(fields()[2], value);
      this.customerId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
     * Checks whether the 'customerId' field has been set.
     *
     * @return True if the 'customerId' field has been set, false otherwise.
     */
    public boolean hasCustomerId() {
      return fieldSetFlags()[2];
    }

    /**
     * Clears the value of the 'customerId' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearCustomerId() {
      customerId = null;
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setOrderId(
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearOrderId() {
      orderId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
     * Gets the value of the 'price' field.
     *
     * @return The value.
     */
    public java.math.BigDecimal getPrice() {
      return price;
    }

    /**
     * Sets the value of the 'price' field.
     *
     * @param value The value of 'price'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setPrice(
        java.math.BigDecimal value) {
      validate(fields()[4], value);
      this.price = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
     * Checks whether the 'price' field has been set.
     *
     * @return True if the 'price' field has been set, false otherwise.
     */
    public boolean hasPrice() {
      return fieldSetFlags()[4];
    }

    /**
     * Clears the value of the 'price' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearPrice() {
      price = null;
      fieldSetFlags()[4] = false;
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
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setCreatedAt(
        java.time.Instant value) {
      validate(fields()[5], value);
      this.createdAt = value.truncatedTo(java.time.temporal.ChronoUnit.MILLIS);
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
     * Checks whether the 'createdAt' field has been set.
     *
     * @return True if the 'createdAt' field has been set, false otherwise.
     */
    public boolean hasCreatedAt() {
      return fieldSetFlags()[5];
    }

    /**
     * Clears the value of the 'createdAt' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearCreatedAt() {
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
     * Gets the value of the 'orderStatus' field.
     *
     * @return The value.
     */
    public com.order.system.kafka.model.avro.OrderStatus getOrderStatus() {
      return orderStatus;
    }

    /**
     * Sets the value of the 'orderStatus' field.
     *
     * @param value The value of 'orderStatus'.
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder setOrderStatus(
        com.order.system.kafka.model.avro.OrderStatus value) {
      validate(fields()[6], value);
      this.orderStatus = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
     * Checks whether the 'orderStatus' field has been set.
     *
     * @return True if the 'orderStatus' field has been set, false otherwise.
     */
    public boolean hasOrderStatus() {
      return fieldSetFlags()[6];
    }

    /**
     * Clears the value of the 'orderStatus' field.
     *
     * @return This builder.
     */
    public com.order.system.kafka.model.avro.PaymentRequestAvroModel.Builder clearOrderStatus() {
      orderStatus = null;
      fieldSetFlags()[6] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public PaymentRequestAvroModel build() {
      try {
        PaymentRequestAvroModel record = new PaymentRequestAvroModel();
        record.id = fieldSetFlags()[0] ? this.id : (java.util.UUID) defaultValue(fields()[0]);
        record.sagaId =
            fieldSetFlags()[1] ? this.sagaId : (java.util.UUID) defaultValue(fields()[1]);
        record.customerId =
            fieldSetFlags()[2] ? this.customerId : (java.util.UUID) defaultValue(fields()[2]);
        record.orderId =
            fieldSetFlags()[3] ? this.orderId : (java.util.UUID) defaultValue(fields()[3]);
        record.price =
            fieldSetFlags()[4] ? this.price : (java.math.BigDecimal) defaultValue(fields()[4]);
        record.createdAt =
            fieldSetFlags()[5] ? this.createdAt : (java.time.Instant) defaultValue(fields()[5]);
        record.orderStatus =
            fieldSetFlags()[6]
                ? this.orderStatus
                : (com.order.system.kafka.model.avro.OrderStatus) defaultValue(fields()[6]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<PaymentRequestAvroModel> WRITER$ =
      (org.apache.avro.io.DatumWriter<PaymentRequestAvroModel>) MODEL$.createDatumWriter(SCHEMA$);

  @Override
  public void writeExternal(java.io.ObjectOutput out) throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<PaymentRequestAvroModel> READER$ =
      (org.apache.avro.io.DatumReader<PaymentRequestAvroModel>) MODEL$.createDatumReader(SCHEMA$);

  @Override
  public void readExternal(java.io.ObjectInput in) throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }
}
