package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.AggregateRoot;
import com.order.system.domain.value.ProductId;
import com.order.system.domain.value.StoreId;
import java.util.Map;
import lombok.*;

@Data
@Builder
public class Store implements AggregateRoot {
  @EqualsAndHashCode.Include private final StoreId id;
  private final Map<ProductId, Product> products;
  private boolean active;
}
