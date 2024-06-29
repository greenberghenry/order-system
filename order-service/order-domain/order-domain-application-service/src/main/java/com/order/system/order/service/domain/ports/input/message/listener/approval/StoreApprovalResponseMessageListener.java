package com.order.system.order.service.domain.ports.input.message.listener.approval;

import com.order.system.order.service.domain.dto.message.StoreApprovalResponse;

public interface StoreApprovalResponseMessageListener {

  void orderApproved(StoreApprovalResponse response);

  void orderRejected(StoreApprovalResponse response);
}
