package com.example.Ecommerce.Service;

import com.example.Ecommerce.models.Product;
import com.example.Ecommerce.repository.ProductRepo;

import java.util.List;

public class SelfproductService implements iProductService{
    ProductRepo repo;
    public SelfproductService(ProductRepo repo){
        this.repo=repo;
    }
    @Override
    public Product getProductById(Long productId) {
        Product p = repo.findByProductId(productId);
        return p;
    }

    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public Product patchproduct(Long productId, Product dto) throws Exception {
        return null;
    }
}

