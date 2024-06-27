package com.ordering.order.service.domain.mapper;

import com.ordering.domain.value.CustomerId;
import com.ordering.domain.value.Money;
import com.ordering.domain.value.ProductId;
import com.ordering.domain.value.StoreId;
import com.ordering.order.service.domain.dto.create.CreateOrderCommand;
import com.ordering.order.service.domain.dto.create.CreateOrderResponse;
import com.ordering.order.service.domain.dto.create.OrderAddress;
import com.ordering.order.service.domain.dto.track.TrackOrderResponse;
import com.ordering.order.service.domain.entity.Order;
import com.ordering.order.service.domain.entity.OrderItem;
import com.ordering.order.service.domain.entity.Product;
import com.ordering.order.service.domain.entity.Store;
import com.ordering.order.service.domain.event.OrderCreatedEvent;
import com.ordering.order.service.domain.value.StreetAddress;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderDataMapper {

  public Store createOrderCommandToStore(CreateOrderCommand command) {
    return Store.builder()
        .storeId(new StoreId(command.getStoreId()))
        .products(
            command.getItems().stream()
                .map(c -> new ProductId(c.getProductId()))
                .collect(Collectors.toMap(Function.identity(), Product::new)))
        .build();
  }

  public Order createOrderCommandToOrder(CreateOrderCommand command) {
    return Order.builder()
        .customerId(new CustomerId(command.getCustomerId()))
        .storeId(new StoreId(command.getStoreId()))
        .deliveryAddress(orderAddressToStreetAddress(command.getAddress()))
        .price(new Money(command.getPrice()))
        .items(orderItemsToOrderItemEntities(command.getItems()))
        .build();
  }

  public CreateOrderResponse orderCreatedEventToCreateOrderResponse(
      OrderCreatedEvent event, String message) {
    return CreateOrderResponse.builder()
        .trackingId(event.getOrder().getTrackingId().value())
        .status(event.getOrder().getOrderStatus())
        .message(message)
        .build();
  }

  public TrackOrderResponse orderToTrackOrderResponse(Order order) {
    return TrackOrderResponse.builder()
        .trackingId(order.getTrackingId().value())
        .failureMessages(order.getFailureMessages())
        .status(order.getOrderStatus())
        .build();
  }

  private List<OrderItem> orderItemsToOrderItemEntities(
      List<com.ordering.order.service.domain.dto.create.OrderItem> orderItems) {
    return orderItems.stream()
        .map(
            orderItem ->
                OrderItem.builder()
                    .product(new Product(new ProductId(orderItem.getProductId())))
                    .price(new Money(orderItem.getPrice()))
                    .quantity(orderItem.getQuantity())
                    .total(new Money(orderItem.getTotal()))
                    .build())
        .toList();
  }

  private StreetAddress orderAddressToStreetAddress(OrderAddress address) {
    return StreetAddress.builder()
        .id(UUID.randomUUID())
        .street(address.getStreet())
        .city(address.getCity())
        .state(address.getState())
        .zip(address.getZip())
        .build();
  }
}
