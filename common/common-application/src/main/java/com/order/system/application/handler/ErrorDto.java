package com.order.system.application.handler;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorDto {
  String code;
  String message;
}
