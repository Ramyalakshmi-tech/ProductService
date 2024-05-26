package com.example.Ecommerce.Service;

import com.example.Ecommerce.fakeStoreApi.FakeStoreProductResponse;
import com.example.Ecommerce.models.Product;

import java.util.List;

public interface iProductService {
    Product getProductById(Long productId);
    List<Product> getAllProducts();
    Product patchproduct(Long productId,Product dto) throws Exception;

   // Product patchProduct(Long productId, Product product) throws Exception;
}
