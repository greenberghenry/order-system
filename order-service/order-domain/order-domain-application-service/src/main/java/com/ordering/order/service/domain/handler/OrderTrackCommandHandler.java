package com.ordering.order.service.domain.handler;

import com.ordering.order.service.domain.dto.track.TrackOrderQuery;
import com.ordering.order.service.domain.dto.track.TrackOrderResponse;
import com.ordering.order.service.domain.exception.OrderNotFoundException;
import com.ordering.order.service.domain.mapper.OrderDataMapper;
import com.ordering.order.service.domain.ports.output.repository.OrderRepository;
import com.ordering.order.service.domain.value.TrackingId;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@AllArgsConstructor
public class OrderTrackCommandHandler {

  private final OrderRepository orderRepository;
  private final OrderDataMapper orderDataMapper;

  @Transactional(readOnly = true)
  public TrackOrderResponse trackOrder(TrackOrderQuery query) {
    val order = orderRepository.findByTrackingId(new TrackingId(query.getTrackingId()));
    if (order.isEmpty()) {
      log.warn("Could not find order with tracking id {}", query.getTrackingId());
      throw new OrderNotFoundException(
          "Could not find order with tracking id " + query.getTrackingId());
    }
    return orderDataMapper.orderToTrackOrderResponse(order.get());
  }
}
