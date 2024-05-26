package com.example.Ecommerce.repository;

import com.example.Ecommerce.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product,Long> {
    Product findByProductId(Long id);
    List<Product> findAll();
    Product save(Product product);
}
