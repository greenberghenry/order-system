package com.order.system.order.service.domain.ports.input.service;

import com.order.system.order.service.domain.dto.create.CreateOrderCommand;
import com.order.system.order.service.domain.dto.create.CreateOrderResponse;
import com.order.system.order.service.domain.dto.track.TrackOrderQuery;
import com.order.system.order.service.domain.dto.track.TrackOrderResponse;
import com.order.system.order.service.domain.handler.OrderCreateCommandHandler;
import com.order.system.order.service.domain.handler.OrderTrackCommandHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Service
@Validated
@RequiredArgsConstructor
class OrderApplicationServiceImpl implements OrderApplicationService {

  private final OrderCreateCommandHandler orderCreateCommandHandler;
  private final OrderTrackCommandHandler orderTrackCommandHandler;

  @Override
  public CreateOrderResponse createOrder(CreateOrderCommand command) {
    return orderCreateCommandHandler.createOrder(command);
  }

  @Override
  public TrackOrderResponse trackOrder(TrackOrderQuery query) {
    return orderTrackCommandHandler.trackOrder(query);
  }
}
