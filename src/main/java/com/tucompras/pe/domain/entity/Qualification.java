package com.tucompras.pe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Qualification {

  private Integer one;
  private Integer two;
  private Integer three;
  private Integer four;
  private Integer five;
}
