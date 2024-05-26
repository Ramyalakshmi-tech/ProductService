package com.example.Ecommerce.mapper;

import com.example.Ecommerce.dto.ProductRequestDto;
import com.example.Ecommerce.dto.ProductResponseDto;
import com.example.Ecommerce.fakeStoreApi.FakeStoreProductResponse;
import com.example.Ecommerce.models.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMapper {
    public static Product getProductFromFakeStoreProduct(FakeStoreProductResponse dto){
        return new Product();
    }

    public static List<Product> getProductListFromFakeStoreList(FakeStoreProductResponse[] dtoList){
        List<Product> products=new ArrayList<>();
        for(FakeStoreProductResponse dto:dtoList){
            products.add(getProductFromFakeStoreProduct(dto));
        }
        return products;
    }

    public static Product getProductFromCreateRequestDTO(ProductRequestDto dto){
        return new Product();
    }
    public static ProductResponseDto getProductResponseDtoFromProduct(Product product){
        return new ProductResponseDto();
    }

    public static List<ProductResponseDto> getProductResponseDtoListFromProducts(List<Product> products){
        List<ProductResponseDto> responseDtos=new ArrayList<>();
        for(Product p:products){
            responseDtos.add(getProductResponseDtoFromProduct(p));
        }
        return responseDtos;
    }
}
