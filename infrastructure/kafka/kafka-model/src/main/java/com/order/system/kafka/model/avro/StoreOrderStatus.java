/**
 * Autogenerated by Avro
 *
 * <p>DO NOT EDIT DIRECTLY
 */
package com.order.system.kafka.model.avro;

@org.apache.avro.specific.AvroGenerated
public enum StoreOrderStatus
    implements org.apache.avro.generic.GenericEnumSymbol<StoreOrderStatus> {
  PAID;
  public static final org.apache.avro.Schema SCHEMA$ =
      new org.apache.avro.Schema.Parser()
          .parse(
              "{\"type\":\"enum\",\"name\":\"StoreOrderStatus\",\"namespace\":\"com.order.system.kafka.model.avro\",\"symbols\":[\"PAID\"]}");

  public static org.apache.avro.Schema getClassSchema() {
    return SCHEMA$;
  }

  @Override
  public org.apache.avro.Schema getSchema() {
    return SCHEMA$;
  }
}