package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.BaseEntity;
import com.order.system.domain.value.Money;
import com.order.system.domain.value.OrderId;
import com.order.system.order.service.domain.value.OrderItemId;

public class OrderItem extends BaseEntity<OrderItemId> {
  private OrderId orderId;

  private final Product product;
  private final int quantity;
  private final Money price;
  private final Money total;

  private OrderItem(Builder builder) {
    super.setId(builder.orderItemId);
    this.product = builder.product;
    this.quantity = builder.quantity;
    this.price = builder.price;
    this.total = builder.total;
  }

  public Product getProduct() {
    return product;
  }

  public int getQuantity() {
    return quantity;
  }

  public Money getPrice() {
    return price;
  }

  public Money getTotal() {
    return total;
  }

  void initializeItem(OrderId orderId, OrderItemId orderItemId) {
    super.setId(orderItemId);
    this.orderId = orderId;
  }

  boolean isPriceValid() {
    return price.isGreaterThanZero()
        && price.equals(product.getPrice())
        && price.multiply(quantity).equals(total);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private OrderItemId orderItemId;
    private Product product;
    private int quantity;
    private Money price;
    private Money total;

    private Builder() {}

    public Builder orderItemId(OrderItemId val) {
      orderItemId = val;
      return this;
    }

    public Builder product(Product val) {
      product = val;
      return this;
    }

    public Builder quantity(int val) {
      quantity = val;
      return this;
    }

    public Builder price(Money val) {
      price = val;
      return this;
    }

    public Builder total(Money val) {
      total = val;
      return this;
    }

    public OrderItem build() {
      return new OrderItem(this);
    }
  }
}
