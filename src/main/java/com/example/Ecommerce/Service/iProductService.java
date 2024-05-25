package com.example.Ecommerce.Service;

import com.example.Ecommerce.fakeStoreApi.FakeStoreProductResponse;

import java.util.List;

public interface iProductService {
    FakeStoreProductResponse getProductById(Long productId);
    List<FakeStoreProductResponse> getAllProducts();
}
