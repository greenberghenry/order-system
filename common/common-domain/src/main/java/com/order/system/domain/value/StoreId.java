package com.order.system.domain.value;

import java.util.UUID;

public record StoreId(UUID value) {

  public static StoreId of(UUID value) {
    return new StoreId(value);
  }
}
