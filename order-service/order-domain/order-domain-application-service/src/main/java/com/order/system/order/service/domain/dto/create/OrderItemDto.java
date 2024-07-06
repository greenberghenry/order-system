package com.order.system.order.service.domain.dto.create;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OrderItemDto {
  @NotNull UUID productId;
  @NotNull Integer quantity;
  @NotNull BigDecimal price;
  @NotNull BigDecimal total;
}
