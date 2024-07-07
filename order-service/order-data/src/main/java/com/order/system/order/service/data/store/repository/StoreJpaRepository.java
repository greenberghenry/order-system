package com.order.system.order.service.data.store.repository;

import com.order.system.order.service.data.store.entity.StoreEntity;
import com.order.system.order.service.data.store.entity.StoreEntityId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreJpaRepository extends JpaRepository<StoreEntity, StoreEntityId> {

  Optional<List<StoreEntity>> findByStoreIdAndProductIdIn(UUID storeId, List<UUID> productIds);
}
