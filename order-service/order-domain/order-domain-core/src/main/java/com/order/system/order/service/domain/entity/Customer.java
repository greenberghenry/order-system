package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.AggregateRoot;
import com.order.system.domain.value.CustomerId;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class Customer implements AggregateRoot {
  @EqualsAndHashCode.Include private final CustomerId id;
}
