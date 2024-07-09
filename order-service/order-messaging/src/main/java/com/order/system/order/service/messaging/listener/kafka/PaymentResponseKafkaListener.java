package com.order.system.order.service.messaging.listener.kafka;

import com.order.system.kafka.consumer.service.KafkaConsumer;
import com.order.system.kafka.model.avro.PaymentResponseAvroModel;
import com.order.system.kafka.model.avro.PaymentStatus;
import com.order.system.order.service.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import com.order.system.order.service.messaging.mapper.OrderMessagingDataMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentResponseKafkaListener implements KafkaConsumer<PaymentResponseAvroModel> {

  private final PaymentResponseMessageListener messageListener;
  private final OrderMessagingDataMapper orderDataMapper;

  @Override
  @KafkaListener(
      id = "${kafka-consumer-config.payment-consumer-group-id}",
      topics = "${order-service.payment-response-topic-name}")
  public void receive(
      @Payload List<PaymentResponseAvroModel> messages,
      @Header(KafkaHeaders.RECEIVED_KEY) List<String> keys,
      @Header(KafkaHeaders.RECEIVED_PARTITION) List<Integer> partitions,
      @Header(KafkaHeaders.OFFSET) List<Long> offsets) {
    log.info(
        "{} number of payment responses received with keys {}, partitions {} and offsets {}",
        messages.size(),
        keys.toString(),
        partitions.toString(),
        offsets.toString());

    messages.forEach(
        avro -> {
          if (PaymentStatus.COMPLETED == avro.getPaymentStatus()) {

            log.info("Processing successful payment for order {}", avro.getOrderId());
            val paymentResponse = orderDataMapper.paymentResponseAvroModelToPaymentResponse(avro);
            messageListener.paymentCompleted(paymentResponse);

          } else if (PaymentStatus.CANCELLED == avro.getPaymentStatus()
              || PaymentStatus.FAILED == avro.getPaymentStatus()) {

            log.info("Processing unsuccessful payment for order {}", avro.getOrderId());
            val paymentResponse = orderDataMapper.paymentResponseAvroModelToPaymentResponse(avro);
            messageListener.paymentCancelled(paymentResponse);
          }
        });
  }
}
