package com.order.system.order.service.data.store.mapper;

import com.order.system.domain.value.Money;
import com.order.system.order.service.data.store.entity.StoreEntity;
import com.order.system.order.service.data.store.exception.StoreDataException;
import com.order.system.order.service.domain.entity.Product;
import com.order.system.order.service.domain.entity.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class StoreDataMapper {

  public List<UUID> storeToStoreProductIds(Store store) {
    return new ArrayList<>(store.getProducts().keySet());
  }

  public Store storeEntityToStore(List<StoreEntity> storeEntities) {
    val storeEntity =
        storeEntities.stream()
            .findFirst()
            .orElseThrow(() -> new StoreDataException("Store could not be found"));
    val storeProducts =
        storeEntities.stream()
            .map(
                entity ->
                    Product.builder()
                        .productId(entity.getProductId())
                        .name(entity.getProductName())
                        .price(Money.of(entity.getProductPrice()))
                        .build())
            .collect(Collectors.toMap(Product::getProductId, Function.identity()));
    return Store.builder()
        .sroreId(storeEntity.getStoreId())
        .active(storeEntity.getStoreActive())
        .products(storeProducts)
        .build();
  }
}
