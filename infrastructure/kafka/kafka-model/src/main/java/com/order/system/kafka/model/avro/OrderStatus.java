/**
 * Autogenerated by Avro
 *
 * <p>DO NOT EDIT DIRECTLY
 */
package com.order.system.kafka.model.avro;

@org.apache.avro.specific.AvroGenerated
public enum OrderStatus implements org.apache.avro.generic.GenericEnumSymbol<OrderStatus> {
  PENDING,
  CANCELLED;
  public static final org.apache.avro.Schema SCHEMA$ =
      new org.apache.avro.Schema.Parser()
          .parse(
              "{\"type\":\"enum\",\"name\":\"OrderStatus\",\"namespace\":\"com.order.system.kafka.model.avro\",\"symbols\":[\"PENDING\",\"CANCELLED\"]}");

  public static org.apache.avro.Schema getClassSchema() {
    return SCHEMA$;
  }

  @Override
  public org.apache.avro.Schema getSchema() {
    return SCHEMA$;
  }
}
