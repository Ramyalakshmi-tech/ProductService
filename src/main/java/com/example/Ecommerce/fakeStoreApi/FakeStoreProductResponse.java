package com.example.Ecommerce.fakeStoreApi;

import lombok.Data;

@Data
public class FakeStoreProductResponse {
    String id;
    String title;
    Double price;
    String description;
    String category;
    String image;
    Rating rating;
}
