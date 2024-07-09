package com.order.system.order.service.data.order.adapter;

import com.order.system.order.service.data.order.mapper.OrderDataMapper;
import com.order.system.order.service.data.order.repository.OrderJpaRepository;
import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.ports.output.repository.OrderRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

  private final OrderJpaRepository orderJpaRepository;
  private final OrderDataMapper orderDataMapper;

  @Override
  public Order save(Order order) {
    return orderDataMapper.orderEntityToOrder(
        orderJpaRepository.save(orderDataMapper.orderToOrderEntity(order)));
  }

  @Override
  public Optional<Order> findByTrackingId(UUID trackingId) {
    return orderJpaRepository.findByTrackingId(trackingId).map(orderDataMapper::orderEntityToOrder);
  }
}
