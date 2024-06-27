package com.ordering.order.service.domain.ports.output.message.publisher.payment;

import com.ordering.domain.event.publisher.DomainEventPublisher;
import com.ordering.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher
    extends DomainEventPublisher<OrderCreatedEvent> {}
