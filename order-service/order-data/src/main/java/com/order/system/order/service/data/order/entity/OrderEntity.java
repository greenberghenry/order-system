package com.order.system.order.service.data.order.entity;

import com.order.system.domain.value.OrderStatus;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class OrderEntity {
  @Id @EqualsAndHashCode.Include private UUID id;
  private UUID customerId;
  private UUID storeId;
  private UUID trackingId;
  private BigDecimal price;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  private String failureMessages;

  @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
  private OrderAddressEntity address;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
  private List<OrderItemEntity> items;
}
