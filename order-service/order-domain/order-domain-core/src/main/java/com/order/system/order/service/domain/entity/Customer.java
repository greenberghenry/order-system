package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.AggregateRoot;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class Customer implements AggregateRoot {
  @EqualsAndHashCode.Include private final UUID customerId;
}
