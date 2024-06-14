package com.ordering.order.service.domain.exception;

import com.ordering.domain.exception.DomainException;

public class OrderDomainExeption extends DomainException {

  public OrderDomainExeption(String message) {
    super(message);
  }

  public OrderDomainExeption(String message, Throwable cause) {
    super(message, cause);
  }
}
