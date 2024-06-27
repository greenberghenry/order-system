package com.ordering.order.service.domain.ports.output.message.publisher.approval;

import com.ordering.domain.event.publisher.DomainEventPublisher;
import com.ordering.order.service.domain.event.OrderPaidEvent;

public interface OrderStoreRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {}
