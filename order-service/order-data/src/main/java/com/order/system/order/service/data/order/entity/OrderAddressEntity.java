package com.order.system.order.service.data.order.entity;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_address")
public class OrderAddressEntity {
  @Id @EqualsAndHashCode.Exclude private UUID id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "ORDER_ID")
  private OrderEntity order;

  private String street;
  private String city;
  private String state;
  private String zip;
}
