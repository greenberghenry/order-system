package com.order.system.domain.value;

import java.util.UUID;

public record ProductId(UUID value) {

  public static ProductId of(UUID value) {
    return new ProductId(value);
  }
}
