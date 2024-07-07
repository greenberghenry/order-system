package com.order.system.order.service.data.order.repository;

import com.order.system.order.service.data.order.entity.OrderEntity;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

  Optional<OrderEntity> findByTrackingId(UUID trackingId);
}
