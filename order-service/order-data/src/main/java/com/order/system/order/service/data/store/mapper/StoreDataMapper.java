package com.order.system.order.service.data.store.mapper;

import com.order.system.domain.value.Money;
import com.order.system.domain.value.ProductId;
import com.order.system.domain.value.StoreId;
import com.order.system.order.service.data.store.entity.StoreEntity;
import com.order.system.order.service.data.store.exception.StoreDataException;
import com.order.system.order.service.domain.entity.Product;
import com.order.system.order.service.domain.entity.Store;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.stereotype.Component;

@Component
public class StoreDataMapper {

  public List<UUID> storeToStoreProductIds(Store store) {
    return store.getProducts().keySet().stream().map(ProductId::value).collect(Collectors.toList());
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
                        .id(ProductId.of(entity.getProductId()))
                        .name(entity.getProductName())
                        .price(Money.of(entity.getProductPrice()))
                        .build())
            .collect(Collectors.toMap(Product::getId, Function.identity()));
    return Store.builder()
        .id(StoreId.of(storeEntity.getStoreId()))
        .active(storeEntity.getStoreActive())
        .products(storeProducts)
        .build();
  }
}
