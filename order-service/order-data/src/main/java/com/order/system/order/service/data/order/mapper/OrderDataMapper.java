package com.order.system.order.service.data.order.mapper;

import static com.order.system.order.service.domain.entity.Order.FAILURE_MESSAGES_DELIMITER;

import com.order.system.domain.value.*;
import com.order.system.order.service.data.order.entity.OrderAddressEntity;
import com.order.system.order.service.data.order.entity.OrderEntity;
import com.order.system.order.service.data.order.entity.OrderItemEntity;
import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.entity.OrderItem;
import com.order.system.order.service.domain.entity.Product;
import com.order.system.order.service.domain.value.StreetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class OrderDataMapper {

  public OrderEntity orderToOrderEntity(Order order) {
    val orderEntity =
        OrderEntity.builder()
            .id(order.getOrderId())
            .customerId(order.getCustomerId())
            .trackingId(order.getTrackingId())
            .storeId(order.getStoreId())
            .address(deliveryAddressToAddressEntity(order.getDeliveryAddress()))
            .price(order.getPrice().amount())
            .items(orderItemsToOrderItemEntities(order.getItems()))
            .orderStatus(order.getOrderStatus())
            .failureMessages(
                CollectionUtils.isEmpty(order.getFailureMessages())
                    ? ""
                    : String.join(FAILURE_MESSAGES_DELIMITER, order.getFailureMessages()))
            .build();
    orderEntity.getAddress().setOrder(orderEntity);
    orderEntity.getItems().forEach(orderItemEntity -> orderItemEntity.setOrder(orderEntity));
    return orderEntity;
  }

  public Order orderEntityToOrder(OrderEntity orderEntity) {
    return Order.builder()
        .orderId(orderEntity.getId())
        .customerId(orderEntity.getCustomerId())
        .storeId(orderEntity.getStoreId())
        .trackingId(orderEntity.getTrackingId())
        .deliveryAddress(addressEntityToDeliveryAddress(orderEntity.getAddress()))
        .price(Money.of(orderEntity.getPrice()))
        .items(orderItemEntitiesToOrderItem(orderEntity.getItems()))
        .orderStatus(orderEntity.getOrderStatus())
        .failureMessages(
            orderEntity.getFailureMessages().isEmpty()
                ? new ArrayList<>()
                : new ArrayList<>(
                    Arrays.asList(
                        orderEntity.getFailureMessages().split(FAILURE_MESSAGES_DELIMITER))))
        .build();
  }

  private List<OrderItem> orderItemEntitiesToOrderItem(List<OrderItemEntity> items) {
    return items.stream()
        .map(
            orderItemEntity ->
                OrderItem.builder()
                    .orderItemId(orderItemEntity.getId())
                    .total(Money.of(orderItemEntity.getTotal()))
                    .quantity(orderItemEntity.getQuantity())
                    .price(Money.of(orderItemEntity.getPrice()))
                    .product(
                        Product.builder()
                            .productId(orderItemEntity.getProductId())
                            .build())
                    .build())
        .collect(Collectors.toList());
  }

  private StreetAddress addressEntityToDeliveryAddress(OrderAddressEntity address) {
    return StreetAddress.builder()
        .street(address.getStreet())
        .city(address.getCity())
        .id(address.getId())
        .state(address.getState())
        .zip(address.getZip())
        .build();
  }

  private List<OrderItemEntity> orderItemsToOrderItemEntities(List<OrderItem> items) {
    return items.stream()
        .map(
            orderItem ->
                OrderItemEntity.builder()
                    .total(orderItem.getTotal().amount())
                    .quantity(orderItem.getQuantity())
                    .productId(orderItem.getProduct().getProductId())
                    .id(orderItem.getOrderItemId())
                    .price(orderItem.getPrice().amount())
                    .build())
        .collect(Collectors.toList());
  }

  private OrderAddressEntity deliveryAddressToAddressEntity(StreetAddress deliveryAddress) {
    return OrderAddressEntity.builder()
        .zip(deliveryAddress.getZip())
        .city(deliveryAddress.getCity())
        .state(deliveryAddress.getState())
        .street(deliveryAddress.getStreet())
        .id(deliveryAddress.getId())
        .build();
  }
}
