package com.tucompras.pe.domain.entity;

import com.google.cloud.firestore.annotation.DocumentId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collectionName = "shop")
public class Shop {

  @DocumentId private String id;
  private String name;
  private String description;
  private List<String> images;
  private Boolean isActive;
  private String userId;
  private Contact contact;
  private Ubigeo ubigeo;
  private Qualification qualification;
  private Category category;
}
