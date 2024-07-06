package com.order.system.order.service.domain.value;

import java.util.UUID;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder
public class StreetAddress {

  @EqualsAndHashCode.Exclude UUID id;
  String street;
  String city;
  String state;
  String zip;
}
