package com.order.system.order.service.messaging.helper;

import java.util.concurrent.CompletableFuture;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.kafka.support.SendResult;

@Slf4j
@UtilityClass
public class OrderKafkaMessageHelper {

  public static <T> void setUpKafkaCallback(
      String orderId, String requestAvroModel, CompletableFuture<SendResult<String, T>> future) {
    future.whenComplete(
        (result, ex) -> {
          if (ex == null) {
            val metadata = result.getRecordMetadata();
            log.info(
                "Successfully published {} for order {} to topic {} partition {} offset {} timestamp {}",
                requestAvroModel,
                orderId,
                metadata.topic(),
                metadata.partition(),
                metadata.offset(),
                metadata.timestamp());
          } else {
            log.error(
                "Failed to publish {} for order {} due to {}",
                requestAvroModel,
                orderId,
                ex.getMessage(),
                ex);
          }
        });
  }
}
