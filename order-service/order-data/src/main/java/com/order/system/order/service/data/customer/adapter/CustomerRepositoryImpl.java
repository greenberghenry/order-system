package com.order.system.order.service.data.customer.adapter;

import com.order.system.order.service.data.customer.mapper.CustomerDataMapper;
import com.order.system.order.service.data.customer.repository.CustomerJpaRepository;
import com.order.system.order.service.domain.entity.Customer;
import com.order.system.order.service.domain.ports.output.repository.CustomerRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerRepositoryImpl implements CustomerRepository {

  private final CustomerJpaRepository customerJpaRepository;
  private final CustomerDataMapper customerDataMapper;

  @Override
  public Optional<Customer> findById(UUID id) {
    return customerJpaRepository.findById(id).map(customerDataMapper::customerEntityToCustomer);
  }
}
