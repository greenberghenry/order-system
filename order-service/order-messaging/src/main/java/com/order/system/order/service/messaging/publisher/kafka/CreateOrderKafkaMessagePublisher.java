package com.order.system.order.service.messaging.publisher.kafka;

import com.order.system.kafka.model.avro.PaymentRequestAvroModel;
import com.order.system.kafka.producer.service.KafkaProducer;
import com.order.system.order.service.domain.config.OrderServiceConfigData;
import com.order.system.order.service.domain.event.OrderCreatedEvent;
import com.order.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import com.order.system.order.service.messaging.helper.OrderKafkaMessageHelper;
import com.order.system.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class CreateOrderKafkaMessagePublisher
    implements OrderCreatedPaymentRequestMessagePublisher {

  private final OrderMessagingDataMapper orderMessagingDataMapper;
  private final OrderServiceConfigData orderServiceConfigData;
  private final KafkaProducer<String, PaymentRequestAvroModel> kafkaProducer;

  @Override
  public void publish(OrderCreatedEvent event) {
    val orderId = event.getOrder().getOrderId().toString();
    log.info("Received OrderCreatedEvent for order {}", orderId);

    try {
      val paymentRequestAvroModel =
          orderMessagingDataMapper.orderCreatedEventToPaymentRequestAvroModel(event);
      val future =
          kafkaProducer.send(
              orderServiceConfigData.getPaymentRequestTopicName(),
              orderId,
              paymentRequestAvroModel);

      OrderKafkaMessageHelper.setUpKafkaCallback(
          orderId, paymentRequestAvroModel.getClass().getSimpleName(), future);
      log.info("Successfully published OrderCreatedEvent for order {}", orderId);
    } catch (Exception ex) {
      log.error("Error while publishing OrderCreatedEvent for order {}", orderId, ex);
    }
  }
}
