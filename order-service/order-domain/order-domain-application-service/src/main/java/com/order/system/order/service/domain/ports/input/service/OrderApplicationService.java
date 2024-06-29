package com.order.system.order.service.domain.ports.input.service;

import com.order.system.order.service.domain.dto.create.CreateOrderCommand;
import com.order.system.order.service.domain.dto.create.CreateOrderResponse;
import com.order.system.order.service.domain.dto.track.TrackOrderQuery;
import com.order.system.order.service.domain.dto.track.TrackOrderResponse;
import jakarta.validation.Valid;

public interface OrderApplicationService {

  CreateOrderResponse createOrder(@Valid CreateOrderCommand command);

  TrackOrderResponse trackOrder(@Valid TrackOrderQuery query);
}
