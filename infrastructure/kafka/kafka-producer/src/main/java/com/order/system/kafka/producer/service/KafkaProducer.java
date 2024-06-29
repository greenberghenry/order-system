package com.order.system.kafka.producer.service;

import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.support.SendResult;

public interface KafkaProducer<K extends Serializable, V extends SpecificRecordBase> {

  CompletableFuture<SendResult<K, V>> send(String topic, K key, V value);
}
