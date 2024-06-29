package com.order.system.order.service.domain.ports.input.message.listener.approval;

import com.order.system.order.service.domain.dto.message.StoreApprovalResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
@RequiredArgsConstructor
public class StoreApprovalResponseMessageListenerImpl
    implements StoreApprovalResponseMessageListener {

  @Override
  public void orderApproved(StoreApprovalResponse response) {}

  @Override
  public void orderRejected(StoreApprovalResponse response) {}
}
