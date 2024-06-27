package com.ordering.order.service.domain.dto.create;

import com.ordering.domain.value.OrderStatus;
import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateOrderResponse {
  @NotNull UUID trackingId;
  @NotNull OrderStatus status;
  @NotNull String message;
}
