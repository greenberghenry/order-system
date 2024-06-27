package com.ordering.order.service.domain.handler;

import com.ordering.order.service.domain.dto.create.CreateOrderCommand;
import com.ordering.order.service.domain.dto.create.CreateOrderResponse;
import com.ordering.order.service.domain.helper.OrderCreateHelper;
import com.ordering.order.service.domain.mapper.OrderDataMapper;
import com.ordering.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrderCreateCommandHandler {

  private final OrderCreateHelper orderCreateHelper;
  private final OrderDataMapper orderDataMapper;
  private final OrderCreatedPaymentRequestMessagePublisher
      orderCreatedPaymentRequestMessagePublisher;

  public CreateOrderResponse createOrder(CreateOrderCommand command) {
    val orderCreatedEvent = orderCreateHelper.persistOrder(command);
    orderCreatedPaymentRequestMessagePublisher.publish(orderCreatedEvent);

    return orderDataMapper.orderCreatedEventToCreateOrderResponse(
        orderCreatedEvent, "Order created successfully");
  }
}
