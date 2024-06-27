package com.ordering.order.service.domain.ports.output.message.publisher.payment;

import com.ordering.domain.event.publisher.DomainEventPublisher;
import com.ordering.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher
    extends DomainEventPublisher<OrderCancelledEvent> {}
