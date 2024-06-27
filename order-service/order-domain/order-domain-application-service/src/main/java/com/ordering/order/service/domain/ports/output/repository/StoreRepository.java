package com.ordering.order.service.domain.ports.output.repository;

import com.ordering.order.service.domain.entity.Store;
import java.util.Optional;

public interface StoreRepository {

  Optional<Store> findInformation(Store store);
}
