package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.BaseEntity;
import com.order.system.domain.value.Money;
import com.order.system.domain.value.ProductId;

public class Product extends BaseEntity<ProductId> {
  private String name;
  private Money price;

  public Product(ProductId productId) {
    super.setId(productId);
  }

  public Product(ProductId productId, Money price, String name) {
    super.setId(productId);
    this.price = price;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public Money getPrice() {
    return price;
  }

  public void updateWithConfirmedNameAndPrice(String name, Money price) {
    this.name = name;
    this.price = price;
  }
}
