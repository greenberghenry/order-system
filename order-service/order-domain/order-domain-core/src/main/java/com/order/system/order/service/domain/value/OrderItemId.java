package com.order.system.order.service.domain.value;

public record OrderItemId(Long value) {

  public static OrderItemId of(Long value) {
    return new OrderItemId(value);
  }
}
