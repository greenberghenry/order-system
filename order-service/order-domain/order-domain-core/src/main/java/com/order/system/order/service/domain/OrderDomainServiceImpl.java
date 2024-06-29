package com.order.system.order.service.domain;

import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.entity.Product;
import com.order.system.order.service.domain.entity.Store;
import com.order.system.order.service.domain.event.OrderCancelledEvent;
import com.order.system.order.service.domain.event.OrderCreatedEvent;
import com.order.system.order.service.domain.event.OrderPaidEvent;
import com.order.system.order.service.domain.exception.OrderDomainException;
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

    log.info("Order {} was initiated", order.getId().value());
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
      throw new OrderDomainException("Store " + store.getId().value() + " is currently not active");
    }
  }

  @Override
  public OrderPaidEvent payOrder(Order order) {
    order.pay();

    log.info("Order {} was paid", order.getId().value());
    return new OrderPaidEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
  }

  @Override
  public void approveOrder(Order order) {
    order.approve();
    log.info("Order {} was approved", order.getId().value());
  }

  @Override
  public OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages) {
    order.initCancel(failureMessages);
    log.info("Order payment {} was cancelled", order.getId().value());
    return new OrderCancelledEvent(order, ZonedDateTime.now(ZoneId.of(UTC)));
  }

  @Override
  public void cancelOrder(Order order, List<String> failureMessages) {
    order.cancel(failureMessages);
    log.info("Order {} was cancelled", order.getId().value());
  }
}
