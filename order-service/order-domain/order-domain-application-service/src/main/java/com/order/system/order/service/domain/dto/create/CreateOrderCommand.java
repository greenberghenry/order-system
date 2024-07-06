package com.order.system.order.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class CreateOrderCommand {
  @NotNull UUID customerId;
  @NotNull UUID storeId;
  @NotNull BigDecimal price;
  @NotNull List<OrderItemDto> items;
  @NotNull StreetAddressDto address;
}
