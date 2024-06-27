package com.ordering.order.service.domain.ports.input.message.listener.payment;

import com.ordering.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

  void paymentCompleted(PaymentResponse response);

  void paymentCancelled(PaymentResponse response);
}
