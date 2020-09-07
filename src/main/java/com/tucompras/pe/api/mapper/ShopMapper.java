package com.tucompras.pe.api.mapper;

import com.tucompras.pe.api.dto.*;
import com.tucompras.pe.domain.entity.*;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ShopMapper {

  public ShopDTO toShopDTO(Shop shop) {
    return ShopDTO.builder()
        .id(shop.getId())
        .name(shop.getName())
        .description(shop.getDescription())
        .images(shop.getImages())
        .isActive(shop.getIsActive())
        .userId(shop.getUserId())
        .contact(toContactDTO(shop.getContact()))
        .category(toCategoryDTO(shop.getCategory()))
        .ubigeo(toUbigeoDTO(shop.getUbigeo()))
        .qualification(toQualificationDTO(shop.getQualification()))
        .build();
  }

  public Shop toShop(ShopDTO dto) {
    return Shop.builder()
        .id(dto.getId() == null ? UUID.randomUUID().toString() : dto.getId())
        .name(dto.getName())
        .description(dto.getDescription())
        .images(dto.getImages())
        .isActive(dto.getIsActive())
        .contact(toContact(dto.getContact()))
        .category(toCategory(dto.getCategory()))
        .ubigeo(toUbigeo(dto.getUbigeo()))
        .qualification(toQualification())
        .userId(dto.getUserId())
        .build();
  }

  private Qualification toQualification() {
    return Qualification.builder().one(0).two(0).three(0).four(0).five(0).build();
  }

  private QualificationDTO toQualificationDTO(Qualification qualification) {
    if (qualification != null) {
      int total =
          qualification.getOne()
              + qualification.getTwo()
              + qualification.getThree()
              + qualification.getFour()
              + qualification.getFive();

      if (total > 0) {
        int average =
            ((1 * qualification.getOne())
                    + (2 * qualification.getTwo())
                    + (3 * qualification.getThree())
                    + (4 * qualification.getFour())
                    + (5 * qualification.getFive()))
                / total;
        return QualificationDTO.builder()
            .votes(total)
            .average(average)
            .stars(Math.round(average))
            .build();
      }
    }
    return QualificationDTO.builder().votes(0).average(0).stars(0).build();
  }

  private Ubigeo toUbigeo(UbigeoDTO dto) {
    if (dto != null)
      return Ubigeo.builder()
          .latitude(dto.getLatitude())
          .longitude(dto.getLongitude())
          .address(dto.getAddress())
          .build();
    return null;
  }

  private UbigeoDTO toUbigeoDTO(Ubigeo ubigeo) {
    if (ubigeo != null)
      return UbigeoDTO.builder()
          .latitude(ubigeo.getLatitude())
          .longitude(ubigeo.getLongitude())
          .address(ubigeo.getAddress())
          .build();
    return null;
  }

  private Category toCategory(CategoryDTO dto) {
    if (dto != null)
      return Category.builder()
          .id(dto.getId())
          .name(dto.getName())
          .itemId(dto.getItemId())
          .itemName(dto.getItemName())
          .build();
    return null;
  }

  private CategoryDTO toCategoryDTO(Category category) {
    if (category != null)
      return CategoryDTO.builder()
          .id(category.getId())
          .name(category.getName())
          .itemId(category.getItemId())
          .itemName(category.getItemName())
          .build();
    return null;
  }

  private Contact toContact(ContactDTO dto) {
    if (dto != null) return Contact.builder().cellphone(dto.getCellphone()).build();
    return null;
  }

  private ContactDTO toContactDTO(Contact contact) {
    if (contact != null) return ContactDTO.builder().cellphone(contact.getCellphone()).build();
    return null;
  }
}
