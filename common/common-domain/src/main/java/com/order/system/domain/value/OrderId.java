package com.order.system.domain.value;

import java.util.UUID;

public record OrderId(UUID value) {

  public static OrderId of(UUID value) {
    return new OrderId(value);
  }
}
