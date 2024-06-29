package com.order.system.order.service.domain.ports.input.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.order.system.domain.value.*;
import com.order.system.order.service.domain.config.OrderTestConfiguration;
import com.order.system.order.service.domain.dto.create.CreateOrderCommand;
import com.order.system.order.service.domain.dto.create.OrderAddress;
import com.order.system.order.service.domain.dto.create.OrderItem;
import com.order.system.order.service.domain.entity.Customer;
import com.order.system.order.service.domain.entity.Order;
import com.order.system.order.service.domain.entity.Product;
import com.order.system.order.service.domain.entity.Store;
import com.order.system.order.service.domain.exception.OrderDomainException;
import com.order.system.order.service.domain.mapper.OrderDataMapper;
import com.order.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.order.system.order.service.domain.ports.output.repository.OrderRepository;
import com.order.system.order.service.domain.ports.output.repository.StoreRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = OrderTestConfiguration.class)
class OrderApplicationServiceImplTest {

  @Autowired private OrderApplicationService orderApplicationService;
  @Autowired private OrderDataMapper orderDataMapper;
  @Autowired private OrderRepository orderRepository;
  @Autowired private CustomerRepository customerRepository;
  @Autowired private StoreRepository storeRepository;

  private static final UUID CUSTOMER_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb41");
  private static final UUID STORE_ID = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb45");
  private static final UUID PRODUCT_ID_1 = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb48");
  private static final UUID PRODUCT_ID_2 = UUID.fromString("d215b5f8-0249-4dc5-89a3-51fd148cfb49");
  private static final UUID ORDER_ID = UUID.fromString("15a497c1-0f4b-4eff-b9f4-c402c8c07afb");
  private static final BigDecimal PRICE = new BigDecimal("200.00");

  private final CreateOrderCommand createOrderCommand =
      CreateOrderCommand.builder()
          .customerId(CUSTOMER_ID)
          .storeId(STORE_ID)
          .address(
              OrderAddress.builder()
                  .street("street_1")
                  .zip("1000AB")
                  .city("Paris")
                  .state("CA")
                  .build())
          .price(PRICE)
          .items(
              List.of(
                  OrderItem.builder()
                      .productId(PRODUCT_ID_1)
                      .quantity(1)
                      .price(new BigDecimal("50.00"))
                      .total(new BigDecimal("50.00"))
                      .build(),
                  OrderItem.builder()
                      .productId(PRODUCT_ID_2)
                      .quantity(3)
                      .price(new BigDecimal("50.00"))
                      .total(new BigDecimal("150.00"))
                      .build()))
          .build();
  private final CreateOrderCommand createOrderCommandWrongPrice =
      CreateOrderCommand.builder()
          .customerId(CUSTOMER_ID)
          .storeId(STORE_ID)
          .address(
              OrderAddress.builder()
                  .street("street_1")
                  .zip("1000AB")
                  .city("Paris")
                  .state("CA")
                  .build())
          .price(new BigDecimal("250.00"))
          .items(
              List.of(
                  OrderItem.builder()
                      .productId(PRODUCT_ID_1)
                      .quantity(1)
                      .price(new BigDecimal("50.00"))
                      .total(new BigDecimal("50.00"))
                      .build(),
                  OrderItem.builder()
                      .productId(PRODUCT_ID_2)
                      .quantity(3)
                      .price(new BigDecimal("50.00"))
                      .total(new BigDecimal("150.00"))
                      .build()))
          .build();
  private final CreateOrderCommand createOrderCommandWrongProductPrice =
      CreateOrderCommand.builder()
          .customerId(CUSTOMER_ID)
          .storeId(STORE_ID)
          .address(
              OrderAddress.builder()
                  .street("street_1")
                  .zip("1000AB")
                  .city("Paris")
                  .state("CA")
                  .build())
          .price(new BigDecimal("210.00"))
          .items(
              List.of(
                  OrderItem.builder()
                      .productId(PRODUCT_ID_1)
                      .quantity(1)
                      .price(new BigDecimal("60.00"))
                      .total(new BigDecimal("60.00"))
                      .build(),
                  OrderItem.builder()
                      .productId(PRODUCT_ID_2)
                      .quantity(3)
                      .price(new BigDecimal("50.00"))
                      .total(new BigDecimal("150.00"))
                      .build()))
          .build();

  @BeforeAll
  void setUp() {
    val customer = Customer.builder().customerId(new CustomerId(CUSTOMER_ID)).build();
    val storeResponse =
        Store.builder()
            .storeId(new StoreId(createOrderCommand.getStoreId()))
            .products(
                Map.of(
                    new ProductId(PRODUCT_ID_1),
                    new Product(
                        new ProductId(PRODUCT_ID_1),
                        new Money(new BigDecimal("50.00")),
                        "product-1"),
                    new ProductId(PRODUCT_ID_2),
                    new Product(
                        new ProductId(PRODUCT_ID_2),
                        new Money(new BigDecimal("50.00")),
                        "product-2")))
            .active(true)
            .build();
    val order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
    order.setId(new OrderId(ORDER_ID));

    when(customerRepository.findById(CUSTOMER_ID)).thenReturn(Optional.of(customer));
    when(storeRepository.findInformation(
            orderDataMapper.createOrderCommandToStore(createOrderCommand)))
        .thenReturn(Optional.of(storeResponse));
    when(orderRepository.save(any(Order.class))).thenReturn(order);
  }

  @Test
  public void testCreateOrder() {
    val createOrderResponse = orderApplicationService.createOrder(createOrderCommand);
    assertEquals(OrderStatus.PENDING, createOrderResponse.getStatus());
    assertEquals("Order created successfully", createOrderResponse.getMessage());
    assertNotNull(createOrderResponse.getTrackingId());
  }

  @Test
  public void testCreateOrderWithWrongTotalPrice() {
    OrderDomainException orderDomainException =
        assertThrows(
            OrderDomainException.class,
            () -> orderApplicationService.createOrder(createOrderCommandWrongPrice));
    assertEquals("Total price: 250.00 is not equal to 200.00", orderDomainException.getMessage());
  }

  @Test
  public void testCreateOrderWithWrongProductPrice() {
    OrderDomainException orderDomainException =
        assertThrows(
            OrderDomainException.class,
            () -> orderApplicationService.createOrder(createOrderCommandWrongProductPrice));
    assertEquals(
        "Order item price: 60.00 is not valid for product " + PRODUCT_ID_1,
        orderDomainException.getMessage());
  }

  @Test
  public void testCreateOrderWithPassiveRestaurant() {
    Store storeResponse =
        Store.builder()
            .storeId(new StoreId(createOrderCommand.getStoreId()))
            .products(
                Map.of(
                    new ProductId(PRODUCT_ID_1),
                    new Product(
                        new ProductId(PRODUCT_ID_1),
                        new Money(new BigDecimal("50.00")),
                        "product-1"),
                    new ProductId(PRODUCT_ID_2),
                    new Product(
                        new ProductId(PRODUCT_ID_2),
                        new Money(new BigDecimal("50.00")),
                        "product-2")))
            .active(false)
            .build();
    when(storeRepository.findInformation(
            orderDataMapper.createOrderCommandToStore(createOrderCommand)))
        .thenReturn(Optional.of(storeResponse));
    OrderDomainException orderDomainException =
        assertThrows(
            OrderDomainException.class,
            () -> orderApplicationService.createOrder(createOrderCommand));
    assertEquals(
        "Store " + STORE_ID + " is currently not active", orderDomainException.getMessage());
  }
}
