package com.order.system.order.service.domain.helper;

import com.order.system.order.service.domain.OrderDomainService;
import com.order.system.order.service.domain.dto.create.CreateOrderCommand;
import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.entity.Store;
import com.order.system.order.service.domain.event.OrderCreatedEvent;
import com.order.system.order.service.domain.exception.OrderDomainException;
import com.order.system.order.service.domain.mapper.OrderDataMapper;
import com.order.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.order.system.order.service.domain.ports.output.repository.OrderRepository;
import com.order.system.order.service.domain.ports.output.repository.StoreRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@AllArgsConstructor
public class OrderCreateHelper {

  private final OrderDomainService orderDomainService;
  private final OrderRepository orderRepository;
  private final CustomerRepository customerRepository;
  private final StoreRepository storeRepository;
  private final OrderDataMapper orderDataMapper;

  @Transactional
  public OrderCreatedEvent persistOrder(CreateOrderCommand command) {
    checkCustomer(command.getCustomerId());

    val store = checkStore(command);
    val order = orderDataMapper.createOrderCommandToOrder(command);
    val orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, store);

    saveOrder(order);
    return orderCreatedEvent;
  }

  private Store checkStore(CreateOrderCommand command) {
    val store = orderDataMapper.createOrderCommandToStore(command);
    val foundStore = storeRepository.findInformation(store);
    if (foundStore.isEmpty()) {
      log.warn("Could not find store {}", command.getStoreId());
      throw new OrderDomainException("Could not find store " + command.getStoreId());
    }
    return foundStore.get();
  }

  private void checkCustomer(UUID customerId) {
    val customer = customerRepository.findById(customerId);
    if (customer.isEmpty()) {
      log.warn("Could not find customer {}", customerId);
      throw new OrderDomainException("Could not find customer " + customerId);
    }
  }

  private void saveOrder(Order order) {
    val savedOrder = orderRepository.save(order);
    if (savedOrder == null) {
      log.error("Could not save order {}", order);
      throw new OrderDomainException("Could not save order");
    }
    log.info("Saved order {}", savedOrder.getOrderId());
  }
}
