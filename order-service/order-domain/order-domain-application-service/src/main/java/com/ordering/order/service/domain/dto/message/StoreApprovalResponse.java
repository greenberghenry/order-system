package com.ordering.order.service.domain.dto.message;

import com.ordering.domain.value.OrderApprovalStatus;
import java.time.Instant;
import java.util.List;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StoreApprovalResponse {
  String id;
  String sagaId;
  String orderId;
  String storeId;
  Instant createdAt;
  OrderApprovalStatus orderApprovalStatus;
  List<String> failureMessages;
}
