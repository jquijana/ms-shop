package com.tucompras.pe.api.service;

import com.tucompras.pe.api.dto.SearchShopDTO;
import com.tucompras.pe.api.dto.ShopDTO;
import com.tucompras.pe.api.mapper.ShopMapper;
import com.tucompras.pe.domain.entity.Shop;
import com.tucompras.pe.domain.repository.ShopRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@AllArgsConstructor
public class ShopService implements IShopService {

  private final ShopRepository shopRepository;
  private final ShopMapper shopMapper;

  @Override
  public Mono<ShopDTO> getById(String id) {
    return shopRepository.findById(id).map(x -> shopMapper.toShopDTO(x));
  }

  @Override
  public Flux<ShopDTO> search(SearchShopDTO searchShopDTO) {
    Flux<Shop> shopFlux;

    if (searchShopDTO.getCategoryId() == null) {
      shopFlux = shopRepository.findAllByIsActive(searchShopDTO.getIsActive());
    } else {
      shopFlux =
          shopRepository.findAllByIsActiveAndCategoryId(
              searchShopDTO.getIsActive(), searchShopDTO.getCategoryId());
    }

    if (searchShopDTO.getUserId() != null)
      shopFlux =
          shopRepository.findAllByIsActiveAndUserId(
              searchShopDTO.getIsActive(), searchShopDTO.getUserId());

    return shopFlux.map(x -> shopMapper.toShopDTO(x));
  }

  @Override
  public Mono<ShopDTO> save(ShopDTO shopDTO) {
    Mono<Shop> shopMono = shopRepository.save(shopMapper.toShop(shopDTO));
    return shopMono.map(x -> shopMapper.toShopDTO(x));
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return shopRepository.deleteById(id);
  }
}
