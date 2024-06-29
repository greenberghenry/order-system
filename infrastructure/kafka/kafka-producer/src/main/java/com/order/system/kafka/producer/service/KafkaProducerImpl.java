package com.order.system.kafka.producer.service;

import com.order.system.kafka.producer.exception.KafkaProducerException;
import jakarta.annotation.PreDestroy;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.specific.SpecificRecordBase;
import org.springframework.kafka.KafkaException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class KafkaProducerImpl<K extends Serializable, V extends SpecificRecordBase>
    implements KafkaProducer<K, V> {

  private final KafkaTemplate<K, V> kafkaTemplate;

  @Override
  public CompletableFuture<SendResult<K, V>> send(String topic, K key, V value) {
    log.info("Sending message={} to topic={}", value, topic);
    try {
      return kafkaTemplate.send(topic, key, value);
    } catch (KafkaException ex) {
      log.error(
          "Error occurred while sending message={} to topic={} with key={}", value, topic, key, ex);
      throw new KafkaProducerException(
          "Error occurred while sending message=" + value + " with key=" + key);
    }
  }

  @PreDestroy
  public void close() {
    if (kafkaTemplate != null) {
      log.info("Closing kafka producer");
      kafkaTemplate.destroy();
    }
  }
}
