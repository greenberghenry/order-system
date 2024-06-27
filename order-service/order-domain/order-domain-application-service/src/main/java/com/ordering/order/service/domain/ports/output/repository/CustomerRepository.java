package com.ordering.order.service.domain.ports.output.repository;

import com.ordering.order.service.domain.entity.Customer;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

  Optional<Customer> findById(UUID id);
}
