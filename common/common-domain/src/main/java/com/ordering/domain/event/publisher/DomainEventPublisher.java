package com.ordering.domain.event.publisher;

import com.ordering.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent<?>> {

  void publish(T event);
}
