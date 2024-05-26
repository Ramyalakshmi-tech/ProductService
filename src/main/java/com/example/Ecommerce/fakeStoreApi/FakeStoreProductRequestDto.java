package com.example.Ecommerce.fakeStoreApi;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FakeStoreProductRequestDto {
    String id;
    String title;
    Double price;
    String Description;
    String category;
    String image;
    Rating rating;
}
