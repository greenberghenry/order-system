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
import lombok.*;

@Data
@Builder
public class Order implements AggregateRoot {
  @EqualsAndHashCode.Include private OrderId id;
  private TrackingId trackingId;
  private OrderStatus orderStatus;
  private List<String> failureMessages;
  private final CustomerId customerId;
  private final StoreId storeId;
  private final StreetAddress deliveryAddress;
  private final Money price;
  private final List<OrderItem> items;

  public void initializeOrder() {
    id = OrderId.of(UUID.randomUUID());
    trackingId = TrackingId.of(UUID.randomUUID());
    orderStatus = OrderStatus.PENDING;
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
    if (orderStatus != null || id != null) {
      throw new OrderDomainException("Order is not in correct state for initialization");
    }
  }

  private void initializeOrderItems() {
    var itemId = 1L;
    for (OrderItem item : items) {
      item.initializeItem(id, OrderItemId.of(itemId++));
    }
  }
}
