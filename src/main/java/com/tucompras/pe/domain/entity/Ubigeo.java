package com.tucompras.pe.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ubigeo {

  private String address;
  private String longitude;
  private String latitude;
}
