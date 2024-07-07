package com.order.system.order.service.domain.entity;

import com.order.system.domain.value.Money;
import java.util.UUID;
import lombok.*;

@Data
@Builder
public class OrderItem {
  @EqualsAndHashCode.Include private Long orderItemId;
  private UUID orderId;
  private final Product product;
  private final int quantity;
  private final Money price;
  private final Money total;

  void initializeItem(UUID orderId, Long orderItemId) {
    this.orderItemId = orderItemId;
    this.orderId = orderId;
  }

  boolean isPriceValid() {
    return price.isGreaterThanZero()
        && price.equals(product.getPrice())
        && price.multiply(quantity).equals(total);
  }
}
