package com.order.system.order.service.data.order.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(OrderEntity.class)
@Table(name = "order_items")
public class OrderItemEntity {
  @Id @EqualsAndHashCode.Include private Long id;

  @Id
  @EqualsAndHashCode.Include
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ORDER_ID")
  private OrderEntity order;

  private UUID productId;
  private Integer quantity;
  private BigDecimal price;
  private BigDecimal total;
}
