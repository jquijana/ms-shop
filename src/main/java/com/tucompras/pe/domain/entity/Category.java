package com.tucompras.pe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  private String id;
  private String name;
  private String itemId;
  private String itemName;
}
