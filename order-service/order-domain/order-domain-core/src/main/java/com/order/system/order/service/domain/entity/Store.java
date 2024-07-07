package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.AggregateRoot;
import java.util.Map;
import java.util.UUID;
import lombok.*;

@Data
@Builder
public class Store implements AggregateRoot {
  @EqualsAndHashCode.Include private final UUID sroreId;
  private final Map<UUID, Product> products;
  private boolean active;
}
