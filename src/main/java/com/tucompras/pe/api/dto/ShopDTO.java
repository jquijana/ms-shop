package com.tucompras.pe.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

  private String id;
  private String name;
  private String description;
  private List<String> images;
  private Boolean isActive;
  private String userId;
  private ContactDTO contact;
  private UbigeoDTO ubigeo;
  private QualificationDTO qualification;
  private CategoryDTO category;
}
