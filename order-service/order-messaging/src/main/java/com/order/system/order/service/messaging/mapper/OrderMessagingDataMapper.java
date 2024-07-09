package com.order.system.order.service.messaging.mapper;

import com.order.system.kafka.model.avro.*;
import com.order.system.order.service.domain.dto.message.PaymentResponse;
import com.order.system.order.service.domain.dto.message.StoreApprovalResponse;
import com.order.system.order.service.domain.event.OrderCancelledEvent;
import com.order.system.order.service.domain.event.OrderCreatedEvent;
import com.order.system.order.service.domain.event.OrderPaidEvent;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class OrderMessagingDataMapper {

  public PaymentRequestAvroModel orderCreatedEventToPaymentRequestAvroModel(
      OrderCreatedEvent orderCreatedEvent) {
    val order = orderCreatedEvent.getOrder();
    return PaymentRequestAvroModel.newBuilder()
        .setId(UUID.randomUUID())
        .setSagaId(null)
        .setCustomerId(order.getCustomerId())
        .setOrderId(order.getOrderId())
        .setPrice(order.getPrice().amount())
        .setOrderStatus(OrderStatus.PENDING)
        .setCreatedAt(orderCreatedEvent.getCreatedAt().toInstant())
        .build();
  }

  public PaymentRequestAvroModel orderCancelledEventToPaymentRequestAvroModel(
      OrderCancelledEvent orderCancelledEvent) {
    val order = orderCancelledEvent.getOrder();
    return PaymentRequestAvroModel.newBuilder()
        .setId(UUID.randomUUID())
        .setSagaId(null)
        .setCustomerId(order.getCustomerId())
        .setOrderId(order.getOrderId())
        .setPrice(order.getPrice().amount())
        .setOrderStatus(OrderStatus.CANCELLED)
        .setCreatedAt(orderCancelledEvent.getCreatedAt().toInstant())
        .build();
  }

  public StoreApprovalRequestAvroModel orderPaidEventToRestaurantApprovalRequestAvroModel(
      OrderPaidEvent orderPaidEvent) {
    val order = orderPaidEvent.getOrder();
    return StoreApprovalRequestAvroModel.newBuilder()
        .setId(UUID.randomUUID())
        .setSagaId(null)
        .setOrderId(order.getOrderId())
        .setStoreId(order.getStoreId())
        .setProducts(
            order.getItems().stream()
                .map(
                    orderItem ->
                        Product.newBuilder()
                            .setId(orderItem.getProduct().getProductId())
                            .setQuantity(orderItem.getQuantity())
                            .build())
                .collect(Collectors.toList()))
        .setPrice(order.getPrice().amount())
        .setCreatedAt(orderPaidEvent.getCreatedAt().toInstant())
        .setStoreOrderStatus(StoreOrderStatus.PAID)
        .build();
  }

  public PaymentResponse paymentResponseAvroModelToPaymentResponse(
      PaymentResponseAvroModel paymentResponseAvroModel) {
    return PaymentResponse.builder()
        .id(paymentResponseAvroModel.getId())
        .sagaId(paymentResponseAvroModel.getSagaId())
        .paymentId(paymentResponseAvroModel.getPaymentId())
        .customerId(paymentResponseAvroModel.getCustomerId())
        .orderId(paymentResponseAvroModel.getOrderId())
        .price(paymentResponseAvroModel.getPrice())
        .createdAt(paymentResponseAvroModel.getCreatedAt())
        .paymentStatus(
            com.order.system.domain.value.PaymentStatus.valueOf(
                paymentResponseAvroModel.getPaymentStatus().name()))
        .failureMessages(paymentResponseAvroModel.getFailureMessages())
        .build();
  }

  public StoreApprovalResponse approvalResponseAvroModelToApprovalResponse(
      StoreApprovalResponseAvroModel restaurantApprovalResponseAvroModel) {
    return StoreApprovalResponse.builder()
        .id(restaurantApprovalResponseAvroModel.getId())
        .sagaId(restaurantApprovalResponseAvroModel.getSagaId())
        .storeId(restaurantApprovalResponseAvroModel.getStoreId())
        .orderId(restaurantApprovalResponseAvroModel.getOrderId())
        .createdAt(restaurantApprovalResponseAvroModel.getCreatedAt())
        .orderApprovalStatus(
            com.order.system.domain.value.OrderApprovalStatus.valueOf(
                restaurantApprovalResponseAvroModel.getOrderApprovalStatus().name()))
        .failureMessages(restaurantApprovalResponseAvroModel.getFailureMessages())
        .build();
  }
}
