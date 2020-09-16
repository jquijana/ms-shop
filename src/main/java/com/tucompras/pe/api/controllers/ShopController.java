package com.tucompras.pe.api.controllers;

import com.tucompras.pe.api.dto.SearchShopDTO;
import com.tucompras.pe.api.dto.ShopDTO;
import com.tucompras.pe.api.service.IShopService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/shops")
public class ShopController {

  private final IShopService shopService;

  @GetMapping("/{id}")
  private Mono<ShopDTO> getById(@PathVariable("id") String id) {
    return shopService.getById(id);
  }

  @PostMapping("/search")
  private Flux<ShopDTO> search(@RequestBody SearchShopDTO searchShopDTO) {
    return shopService.search(searchShopDTO);
  }

  @PostMapping
  private Mono<ShopDTO> save(@RequestBody ShopDTO shopDTO) {
    return shopService.save(shopDTO);
  }

  @PostMapping("/saveAll")
  private Flux<ShopDTO> saveAll(@RequestBody List<ShopDTO> shops) {
    return shopService.saveAll(shops);
  }

  @DeleteMapping("/{id}")
  private Mono<Void> deleteById(@PathVariable("id") String id) {
    return shopService.deleteById(id);
  }
}
