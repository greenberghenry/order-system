package com.order.system.order.service.application.rest;

import com.order.system.order.service.domain.dto.create.CreateOrderCommand;
import com.order.system.order.service.domain.dto.create.CreateOrderResponse;
import com.order.system.order.service.domain.dto.track.TrackOrderQuery;
import com.order.system.order.service.domain.dto.track.TrackOrderResponse;
import com.order.system.order.service.domain.ports.input.service.OrderApplicationService;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
@AllArgsConstructor
public class OrderController {

  private final OrderApplicationService orderApplicationService;

  @PostMapping
  public ResponseEntity<CreateOrderResponse> createOrder(
      @RequestBody CreateOrderCommand command, UriComponentsBuilder uriBuilder) {
    log.info(
        "Creating order for customer {} at store {}",
        command.getCustomerId(),
        command.getStoreId());
    val createOrderResponse = orderApplicationService.createOrder(command);
    val uri =
        uriBuilder
            .path("/{trackingId}")
            .buildAndExpand(createOrderResponse.getTrackingId())
            .toUri();
    log.info("Order was created with tacking id {}", createOrderResponse.getTrackingId());
    return ResponseEntity.created(uri).body(createOrderResponse);
  }

  @GetMapping("/{trackingId}")
  public ResponseEntity<TrackOrderResponse> getOrderByTrackingId(@PathVariable UUID trackingId) {
    val trackOrderResponse =
        orderApplicationService.trackOrder(
            TrackOrderQuery.builder().trackingId(trackingId).build());
    log.info("Returning order status with tracking id {}", trackOrderResponse.getTrackingId());
    return ResponseEntity.ok(trackOrderResponse);
  }
}
