package com.ordering.order.service.domain;

import com.ordering.order.service.domain.entity.Order;
import com.ordering.order.service.domain.entity.Product;
import com.ordering.order.service.domain.entity.Store;
import com.ordering.order.service.domain.event.OrderCancelledEvent;
import com.ordering.order.service.domain.event.OrderCreatedEvent;
import com.ordering.order.service.domain.event.OrderPaidEvent;
import com.ordering.order.service.domain.exception.OrderDomainExeption;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderDomainServiceImpl implements OrderDomainService {

  private static final String UTC = "UTC";

  @Override
  public OrderCreatedEvent validateAndInitiateOrder(Order order, Store store) {
    validateStore(store);
    setOrderProductInfo(order, store);

    order.validateOrder();
    order.initializeOrder();

    log.info("Order {} was initiated", order.getId());
    return new OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
  }

  private void setOrderProductInfo(Order order, Store store) {
    order
        .getItems()
        .forEach(
            item -> {
              Product storeProduct = store.getProducts().get(item.getProduct().getId());
              item.getProduct()
                  .updateWithConfirmedNameAndPrice(storeProduct.getName(), storeProduct.getPrice());
            });
  }

  private void validateStore(Store store) {
    if (!store.isActive()) {
      throw new OrderDomainExeption("Store " + store.getId() + " is currently not active");
    }
  }

  @Override
  public OrderPaidEvent payOrder(Order order) {
    order.pay();

    log.info("Order {} was paid", order.getId());
    return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
  }

  @Override
  public void approveOrder(Order order) {
    order.approve();
    log.info("Order {} was approved", order.getId());
  }

  @Override
  public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
    order.initCancel(failureMessages);
    log.info("Order payment {} was cancelled", order.getId());
    return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
  }

  @Override
  public void cancelOrder(Order order, List<String> failureMessages) {
    order.cancel(failureMessages);
    log.info("Order {} was cancelled", order.getId());
  }
}
