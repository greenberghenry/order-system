package com.order.system.order.service.domain.ports.output.repository;

import com.order.system.order.service.domain.entity.Store;
import java.util.Optional;

public interface StoreRepository {

  Optional<Store> findInformation(Store store);
}
