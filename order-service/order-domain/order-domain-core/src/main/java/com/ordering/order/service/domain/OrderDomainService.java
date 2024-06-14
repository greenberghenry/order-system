package com.ordering.order.service.domain;

import com.ordering.order.service.domain.entity.Order;
import com.ordering.order.service.domain.entity.Store;
import com.ordering.order.service.domain.event.OrderCancelledEvent;
import com.ordering.order.service.domain.event.OrderCreatedEvent;
import com.ordering.order.service.domain.event.OrderPaidEvent;
import java.util.List;

public interface OrderDomainService {

  OrderCreatedEvent validateAndInitiateOrder(Order order, Store store);

  OrderPaidEvent payOrder(Order order);

  void approveOrder(Order order);

  OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);

  void cancelOrder(Order order, List<String> failureMessages);
}
