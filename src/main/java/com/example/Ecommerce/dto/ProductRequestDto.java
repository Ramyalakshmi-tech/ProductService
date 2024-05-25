package com.example.Ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductRequestDto {
    private String productName;
    private String category;
    private String imageURL;
    private Double price;

}
