package com.example.Ecommerce.models;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Product extends BaseModel{
    private String title;
    private Double price;
    private String description;
    private String productName;
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private String imageURL;

}
