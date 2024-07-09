package com.order.system.order.service.messaging.listener.kafka;

import com.order.system.kafka.consumer.service.KafkaConsumer;
import com.order.system.kafka.model.avro.OrderApprovalStatus;
import com.order.system.kafka.model.avro.StoreApprovalResponseAvroModel;
import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.ports.input.message.listener.approval.StoreApprovalResponseMessageListener;
import com.order.system.order.service.messaging.mapper.OrderMessagingDataMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class StoreApprovalResponseKafkaListener
    implements KafkaConsumer<StoreApprovalResponseAvroModel> {

  private final StoreApprovalResponseMessageListener messageListener;
  private final OrderMessagingDataMapper orderDataMapper;

  @Override
  @KafkaListener(
      id = "${kafka-consumer-config.store-approval-consumer-group-id}",
      topics = "${order-service.store-approval-response-topic-name}")
  public void receive(
      List<StoreApprovalResponseAvroModel> messages,
      List<String> keys,
      List<Integer> partitions,
      List<Long> offsets) {
    log.info(
        "{} number of store approval responses received with keys {}, partitions {} and offsets {}",
        messages.size(),
        keys.toString(),
        partitions.toString(),
        offsets.toString());

    messages.forEach(
        avro -> {
          if (OrderApprovalStatus.APPROVED == avro.getOrderApprovalStatus()) {

            log.info("Processing approved order for order {}", avro.getOrderId());
            val approvalResponse =
                orderDataMapper.approvalResponseAvroModelToApprovalResponse(avro);
            messageListener.orderApproved(approvalResponse);

          } else if (OrderApprovalStatus.REJECTED == avro.getOrderApprovalStatus()) {

            log.info(
                "Processing rejected order for order {}, with failure messages {}",
                avro.getOrderId(),
                String.join(Order.FAILURE_MESSAGES_DELIMITER, avro.getFailureMessages()));
            val approvalResponse =
                orderDataMapper.approvalResponseAvroModelToApprovalResponse(avro);
            messageListener.orderRejected(approvalResponse);
          }
        });
  }
}
