package com.order.system.order.service.domain.ports.output.message.publisher.payment;

import com.order.system.domain.event.publisher.DomainEventPublisher;
import com.order.system.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher
    extends DomainEventPublisher<OrderCreatedEvent> {}
