package com.example.Ecommerce.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//tostring,all args constructor and getter and setter
@NoArgsConstructor
public class createProductRequestDto {
    private String productName;
    private String category;
    private String imageUrl;
    private Double price;
}
