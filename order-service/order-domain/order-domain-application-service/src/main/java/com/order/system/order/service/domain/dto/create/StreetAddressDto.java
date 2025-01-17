package com.order.system.order.service.domain.dto.create;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StreetAddressDto {
  @NotNull @Max(value = 50)
  String street;

  @NotNull @Max(value = 50)
  String city;

  @NotNull @Max(value = 50)
  String state;

  @NotNull @Max(value = 10)
  String zip;
}
