package com.order.system.order.service.application.execption.handler;

import com.order.system.application.handler.ErrorDto;
import com.order.system.application.handler.GlobalExceptionHandler;
import com.order.system.order.service.domain.exception.OrderDomainException;
import com.order.system.order.service.domain.exception.OrderNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class OrderGlobalExceptionHandler extends GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = {OrderDomainException.class})
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorDto handleOrderDomainException(OrderDomainException e) {
    log.error(e.getMessage(), e);
    return ErrorDto.builder()
        .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
        .message(e.getMessage())
        .build();
  }

  @ResponseBody
  @ExceptionHandler(value = {OrderNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorDto handleOrderNotFoundException(OrderNotFoundException e) {
    log.error(e.getMessage(), e);
    return ErrorDto.builder()
        .code(HttpStatus.NOT_FOUND.getReasonPhrase())
        .message(e.getMessage())
        .build();
  }
}
