package com.order.system.order.service.domain.entity;

import com.order.system.domain.value.Money;
import com.order.system.domain.value.OrderId;
import com.order.system.order.service.domain.value.OrderItemId;
import lombok.*;

@Data
@Builder
public class OrderItem {
  @EqualsAndHashCode.Include private OrderItemId id;
  private OrderId orderId;
  private final Product product;
  private final int quantity;
  private final Money price;
  private final Money total;

  void initializeItem(OrderId orderId, OrderItemId id) {
    this.id = id;
    this.orderId = orderId;
  }

  boolean isPriceValid() {
    return price.isGreaterThanZero()
        && price.equals(product.getPrice())
        && price.multiply(quantity).equals(total);
  }
}
