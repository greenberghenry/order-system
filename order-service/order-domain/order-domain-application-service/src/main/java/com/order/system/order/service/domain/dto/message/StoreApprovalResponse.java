package com.order.system.order.service.domain.dto.message;

import com.order.system.domain.value.OrderApprovalStatus;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StoreApprovalResponse {
  UUID id;
  UUID sagaId;
  UUID orderId;
  UUID storeId;
  Instant createdAt;
  OrderApprovalStatus orderApprovalStatus;
  List<String> failureMessages;
}
