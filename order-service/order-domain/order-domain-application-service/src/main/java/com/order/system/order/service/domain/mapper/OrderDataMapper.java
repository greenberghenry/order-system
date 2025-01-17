package com.order.system.order.service.domain.mapper;

import com.order.system.domain.value.Money;
import com.order.system.order.service.domain.dto.create.CreateOrderCommand;
import com.order.system.order.service.domain.dto.create.CreateOrderResponse;
import com.order.system.order.service.domain.dto.create.OrderItemDto;
import com.order.system.order.service.domain.dto.create.StreetAddressDto;
import com.order.system.order.service.domain.dto.track.TrackOrderResponse;
import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.entity.OrderItem;
import com.order.system.order.service.domain.entity.Product;
import com.order.system.order.service.domain.entity.Store;
import com.order.system.order.service.domain.event.OrderCreatedEvent;
import com.order.system.order.service.domain.value.StreetAddress;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderDataMapper {

  public Store createOrderCommandToStore(CreateOrderCommand command) {
    return Store.builder()
        .sroreId(command.getStoreId())
        .products(
            command.getItems().stream()
                .map(OrderItemDto::getProductId)
                .collect(
                    Collectors.toMap(
                        Function.identity(), id -> Product.builder().productId(id).build())))
        .build();
  }

  public Order createOrderCommandToOrder(CreateOrderCommand command) {
    return Order.builder()
        .customerId(command.getCustomerId())
        .storeId(command.getStoreId())
        .deliveryAddress(orderAddressToStreetAddress(command.getAddress()))
        .price(Money.of(command.getPrice()))
        .items(orderItemsToOrderItemEntities(command.getItems()))
        .build();
  }

  public CreateOrderResponse orderCreatedEventToCreateOrderResponse(
      OrderCreatedEvent event, String message) {
    return CreateOrderResponse.builder()
        .trackingId(event.getOrder().getTrackingId())
        .status(event.getOrder().getOrderStatus())
        .message(message)
        .build();
  }

  public TrackOrderResponse orderToTrackOrderResponse(Order order) {
    return TrackOrderResponse.builder()
        .trackingId(order.getTrackingId())
        .failureMessages(order.getFailureMessages())
        .status(order.getOrderStatus())
        .build();
  }

  private List<OrderItem> orderItemsToOrderItemEntities(List<OrderItemDto> orderItemDtos) {
    return orderItemDtos.stream()
        .map(
            orderItemDto ->
                OrderItem.builder()
                    .product(Product.builder().productId(orderItemDto.getProductId()).build())
                    .price(Money.of(orderItemDto.getPrice()))
                    .quantity(orderItemDto.getQuantity())
                    .total(Money.of(orderItemDto.getTotal()))
                    .build())
        .toList();
  }

  private StreetAddress orderAddressToStreetAddress(StreetAddressDto address) {
    return StreetAddress.builder()
        .id(UUID.randomUUID())
        .street(address.getStreet())
        .city(address.getCity())
        .state(address.getState())
        .zip(address.getZip())
        .build();
  }
}
