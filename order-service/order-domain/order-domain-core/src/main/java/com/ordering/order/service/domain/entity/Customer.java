package com.ordering.order.service.domain.entity;

import com.ordering.domain.entity.AggregateRoot;
import com.ordering.domain.value.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {

  private Customer(Builder builder) {
    super.setId(builder.customerId);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private CustomerId customerId;

    private Builder() {}

    public Builder customerId(CustomerId val) {
      customerId = val;
      return this;
    }

    public Customer build() {
      return new Customer(this);
    }
  }
}
