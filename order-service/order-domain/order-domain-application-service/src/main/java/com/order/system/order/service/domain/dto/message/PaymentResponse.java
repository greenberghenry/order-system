package com.order.system.order.service.domain.dto.message;

import com.order.system.domain.value.PaymentStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentResponse {
  String id;
  String sagaId;
  String orderId;
  String paymentId;
  String customerId;
  BigDecimal price;
  Instant createAt;
  PaymentStatus paymentStatus;
  List<String> failureMessages;
}
