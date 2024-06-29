package com.order.system.order.service.domain.dto.track;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class TrackOrderQuery {
  @NotNull UUID trackingId;
}
