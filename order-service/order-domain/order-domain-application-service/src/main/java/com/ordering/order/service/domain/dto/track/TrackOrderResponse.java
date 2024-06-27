package com.ordering.order.service.domain.dto.track;

import com.ordering.domain.value.OrderStatus;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TrackOrderResponse {
  @NotNull UUID trackingId;
  @NotNull OrderStatus status;
  List<String> failureMessages;
}
