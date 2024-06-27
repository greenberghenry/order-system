package com.ordering.order.service.domain.ports.output.repository;

import com.ordering.order.service.domain.entity.Order;
import com.ordering.order.service.domain.value.TrackingId;
import java.util.Optional;

public interface OrderRepository {

  Order save(Order order);

  Optional<Order> findByTrackingId(TrackingId id);
}
