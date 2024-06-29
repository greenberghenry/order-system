package com.order.system.order.service.domain.ports.input.message.listener.payment;

import com.order.system.order.service.domain.dto.message.PaymentResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
@AllArgsConstructor
public class PaymentResponseMessageListenerImpl implements PaymentResponseMessageListener {

  @Override
  public void paymentCompleted(PaymentResponse response) {}

  @Override
  public void paymentCancelled(PaymentResponse response) {}
}
