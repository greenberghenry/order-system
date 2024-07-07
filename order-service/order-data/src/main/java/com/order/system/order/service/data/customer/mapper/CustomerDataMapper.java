package com.order.system.order.service.data.customer.mapper;

import com.order.system.order.service.data.customer.entity.CustomerEntity;
import com.order.system.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataMapper {

  public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
    return Customer.builder().customerId(customerEntity.getId()).build();
  }
}
