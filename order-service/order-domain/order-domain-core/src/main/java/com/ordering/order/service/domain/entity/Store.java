package com.ordering.order.service.domain.entity;

import com.ordering.domain.entity.AggregateRoot;
import com.ordering.domain.value.ProductId;
import com.ordering.domain.value.StoreId;
import java.util.Map;

public class Store extends AggregateRoot<StoreId> {
  private final Map<ProductId, Product> products;

  private boolean active;

  private Store(Builder builder) {
    super.setId(builder.storeId);
    this.products = builder.products;
    this.active = builder.active;
  }

  public Map<ProductId, Product> getProducts() {
    return products;
  }

  public boolean isActive() {
    return active;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private StoreId storeId;
    private Map<ProductId, Product> products;
    private boolean active;

    private Builder() {}

    public Builder storeId(StoreId val) {
      storeId = val;
      return this;
    }

    public Builder products(Map<ProductId, Product> val) {
      products = val;
      return this;
    }

    public Builder active(boolean val) {
      active = val;
      return this;
    }

    public Store build() {
      return new Store(this);
    }
  }
}
