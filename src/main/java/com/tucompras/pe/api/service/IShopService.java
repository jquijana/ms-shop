package com.tucompras.pe.api.service;

import com.tucompras.pe.api.dto.SearchShopDTO;
import com.tucompras.pe.api.dto.ShopDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IShopService {

  Mono<ShopDTO> getById(String id);

  Flux<ShopDTO> search(SearchShopDTO searchShopDTO);

  Mono<ShopDTO> save(ShopDTO createShopDTO);

  Mono<Void> deleteById(String id);

  Flux<ShopDTO> saveAll(List<ShopDTO> shops);
}
