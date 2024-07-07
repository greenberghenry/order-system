package com.order.system.order.service.domain.entity;

import com.order.system.domain.value.Money;
import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
public class Product {
  @EqualsAndHashCode.Include private final UUID productId;
  private String name;
  private Money price;

  public void updateWithConfirmedNameAndPrice(String name, Money price) {
    this.name = name;
    this.price = price;
  }
}
