package com.order.system.order.service.domain.entity;

import com.order.system.domain.entity.AggregateRoot;
import com.order.system.domain.value.*;
import com.order.system.order.service.domain.exception.OrderDomainException;
import com.order.system.order.service.domain.value.OrderItemId;
import com.order.system.order.service.domain.value.StreetAddress;
import com.order.system.order.service.domain.value.TrackingId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.val;

public class Order extends AggregateRoot<OrderId> {
  private final CustomerId customerId;
  private final StoreId storeId;
  private final StreetAddress deliveryAddress;
  private final Money price;
  private final List<OrderItem> items;

  private TrackingId trackingId;
  private OrderStatus orderStatus;
  private List<String> failureMessages;

  public void initializeOrder() {
    super.setId(new OrderId(UUID.randomUUID()));
    this.trackingId = new TrackingId(UUID.randomUUID());
    this.orderStatus = OrderStatus.PENDING;
    initializeOrderItems();
  }

  public void validateOrder() {
    validateInitialOrder();
    validateTotalPrice();
    validateItemsPrice();
  }

  public void pay() {
    if (orderStatus != OrderStatus.PENDING) {
      throw new OrderDomainException("Order is not in correct state for pay operation");
    }
    orderStatus = OrderStatus.PAID;
  }

  public void approve() {
    if (orderStatus != OrderStatus.PAID) {
      throw new OrderDomainException("Order is not in correct state for approve operation");
    }
    orderStatus = OrderStatus.APPROVED;
  }

  public void initCancel(List<String> messages) {
    if (orderStatus != OrderStatus.PAID) {
      throw new OrderDomainException(
          "Order is not in correct state for initializing cancel operation");
    }
    orderStatus = OrderStatus.CANCELLING;
    updateFailureMessages(messages);
  }

  private void updateFailureMessages(List<String> messages) {
    if (messages != null && !messages.isEmpty()) {
      if (failureMessages == null) {
        failureMessages = new ArrayList<>(messages);
      } else {
        failureMessages.addAll(messages);
      }
    }
  }

  public void cancel(List<String> messages) {
    if (!(orderStatus == OrderStatus.PENDING || orderStatus == OrderStatus.CANCELLING)) {
      throw new OrderDomainException("Order is not in correct state for cancel operation");
    }
    orderStatus = OrderStatus.CANCELLED;
    updateFailureMessages(messages);
  }

  private void validateItemsPrice() {
    val itemsTotal =
        items.stream()
            .map(
                item -> {
                  validateItemPrice(item);
                  return item.getTotal();
                })
            .reduce(Money.ZERO, Money::add);
    if (!itemsTotal.equals(price)) {
      throw new OrderDomainException(
          "Total price: " + price.amount() + " is not equal to " + itemsTotal.amount());
    }
  }

  private void validateItemPrice(OrderItem item) {
    if (!item.isPriceValid()) {
      throw new OrderDomainException(
          "Order item price: "
              + item.getPrice().amount()
              + " is not valid for product "
              + item.getProduct().getId().value());
    }
  }

  private void validateTotalPrice() {
    if (price == null || !price.isGreaterThanZero()) {
      throw new OrderDomainException("Total price must be greater than zero");
    }
  }

  private void validateInitialOrder() {
    if (orderStatus != null || super.getId() != null) {
      throw new OrderDomainException("Order is not in correct state for initialization");
    }
  }

  private void initializeOrderItems() {
    var itemId = 1L;
    for (OrderItem item : items) {
      item.initializeItem(super.getId(), new OrderItemId(itemId++));
    }
  }

  private Order(Builder builder) {
    super.setId(builder.orderId);
    this.customerId = builder.customerId;
    this.storeId = builder.storeId;
    this.deliveryAddress = builder.deliveryAddress;
    this.price = builder.price;
    this.items = builder.items;
    this.trackingId = builder.trackingId;
    this.orderStatus = builder.orderStatus;
    this.failureMessages = builder.failureMessages;
  }

  public CustomerId getCustomerId() {
    return customerId;
  }

  public StoreId getStoreId() {
    return storeId;
  }

  public StreetAddress getDeliveryAddress() {
    return deliveryAddress;
  }

  public Money getPrice() {
    return price;
  }

  public List<OrderItem> getItems() {
    return items;
  }

  public TrackingId getTrackingId() {
    return trackingId;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public List<String> getFailureMessages() {
    return failureMessages;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private OrderId orderId;
    private CustomerId customerId;
    private StoreId storeId;
    private StreetAddress deliveryAddress;
    private Money price;
    private List<OrderItem> items;
    private TrackingId trackingId;
    private OrderStatus orderStatus;
    private List<String> failureMessages;

    private Builder() {}

    public Builder orderId(OrderId val) {
      orderId = val;
      return this;
    }

    public Builder customerId(CustomerId val) {
      customerId = val;
      return this;
    }

    public Builder storeId(StoreId val) {
      storeId = val;
      return this;
    }

    public Builder deliveryAddress(StreetAddress val) {
      deliveryAddress = val;
      return this;
    }

    public Builder price(Money val) {
      price = val;
      return this;
    }

    public Builder items(List<OrderItem> val) {
      items = val;
      return this;
    }

    public Builder trackingId(TrackingId val) {
      trackingId = val;
      return this;
    }

    public Builder orderStatus(OrderStatus val) {
      orderStatus = val;
      return this;
    }

    public Builder failureMessages(List<String> val) {
      failureMessages = val;
      return this;
    }

    public Order build() {
      return new Order(this);
    }
  }
}
