package com.example.Ecommerce.fakeStoreApi;

import com.example.Ecommerce.models.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakeStoreProductRequestDto {
  //  String id;
    String title;
    Double price;
    String description;
    Category category;
    String image;
   // Rating rating;
}
