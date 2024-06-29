package com.order.system.order.service.domain.ports.output.message.publisher.approval;

import com.order.system.domain.event.publisher.DomainEventPublisher;
import com.order.system.order.service.domain.event.OrderPaidEvent;

public interface OrderStoreRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {}
