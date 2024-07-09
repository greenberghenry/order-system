package com.order.system.order.service.messaging.publisher.kafka;

import com.order.system.kafka.model.avro.StoreApprovalRequestAvroModel;
import com.order.system.kafka.producer.service.KafkaProducer;
import com.order.system.order.service.domain.config.OrderServiceConfigData;
import com.order.system.order.service.domain.event.OrderPaidEvent;
import com.order.system.order.service.domain.ports.output.message.publisher.approval.OrderPaidStoreRequestMessagePublisher;
import com.order.system.order.service.messaging.helper.OrderKafkaMessageHelper;
import com.order.system.order.service.messaging.mapper.OrderMessagingDataMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PayOrderKafkaMessagePublisher implements OrderPaidStoreRequestMessagePublisher {

  private final OrderMessagingDataMapper orderMessagingDataMapper;
  private final OrderServiceConfigData orderServiceConfigData;
  private final KafkaProducer<String, StoreApprovalRequestAvroModel> kafkaProducer;

  @Override
  public void publish(OrderPaidEvent event) {
    val orderId = event.getOrder().getOrderId().toString();
    log.info("Received OrderPaidEvent for order {}", orderId);

    try {
      val storeApprovalRequestAvroModel =
          orderMessagingDataMapper.orderPaidEventToRestaurantApprovalRequestAvroModel(event);
      val future =
          kafkaProducer.send(
              orderServiceConfigData.getStoreApprovalRequestTopicName(),
              orderId,
              storeApprovalRequestAvroModel);

      OrderKafkaMessageHelper.setUpKafkaCallback(
          orderId, storeApprovalRequestAvroModel.getClass().getSimpleName(), future);
      log.info("Successfully published OrderPaidEvent for order {}", orderId);
    } catch (Exception ex) {
      log.error("Error while publishing OrderPaidEvent for order {}", orderId, ex);
    }
  }
}
