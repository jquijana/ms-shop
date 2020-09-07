package com.tucompras.pe.domain.repository;

import com.tucompras.pe.domain.entity.Shop;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface ShopRepository extends FirestoreReactiveRepository<Shop> {

  Flux<Shop> findAllByIsActive(Boolean isActive);

  Flux<Shop> findAllByIsActiveAndCategoryId(Boolean isActive, String categoryId);

  Flux<Shop> findAllByIsActiveAndUserId(Boolean isActive, String userId);
}
