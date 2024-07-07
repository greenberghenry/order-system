package com.order.system.order.service.data.store.adapter;

import com.order.system.order.service.data.store.mapper.StoreDataMapper;
import com.order.system.order.service.data.store.repository.StoreJpaRepository;
import com.order.system.order.service.domain.entity.Store;
import com.order.system.order.service.domain.ports.output.repository.StoreRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {

  private final StoreJpaRepository storeJpaRepository;
  private final StoreDataMapper storeDataMapper;

  @Override
  public Optional<Store> findInformation(Store store) {
    val storeProductIds = storeDataMapper.storeToStoreProductIds(store);
    return storeJpaRepository
        .findByStoreIdAndProductIdIn(store.getId().value(), storeProductIds)
        .map(storeDataMapper::storeEntityToStore);
  }
}
