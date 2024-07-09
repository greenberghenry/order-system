package com.order.system.order.service.domain.dto.message;

import com.order.system.domain.value.PaymentStatus;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class PaymentResponse {
  UUID id;
  UUID sagaId;
  UUID orderId;
  UUID paymentId;
  UUID customerId;
  BigDecimal price;
  Instant createdAt;
  PaymentStatus paymentStatus;
  List<String> failureMessages;
}
