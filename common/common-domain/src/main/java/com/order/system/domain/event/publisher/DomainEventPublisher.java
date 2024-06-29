package com.order.system.domain.event.publisher;

import com.order.system.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent<?>> {

  void publish(T event);
}
