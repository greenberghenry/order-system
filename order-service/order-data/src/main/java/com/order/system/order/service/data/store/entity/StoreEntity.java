package com.order.system.order.service.data.store.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(StoreEntityId.class)
@Table(name = "order_store_m_view", schema = "store")
public class StoreEntity {

  @Id @EqualsAndHashCode.Include private UUID storeId;
  @Id @EqualsAndHashCode.Include private UUID productId;
  private String storeName;
  private Boolean storeActive;
  private String productName;
  private BigDecimal productPrice;
}
