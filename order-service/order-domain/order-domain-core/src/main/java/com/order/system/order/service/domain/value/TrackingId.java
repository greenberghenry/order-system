package com.order.system.order.service.domain.value;

import java.util.UUID;

public record TrackingId(UUID value) {

  public static TrackingId of(UUID value) {
    return new TrackingId(value);
  }
}
