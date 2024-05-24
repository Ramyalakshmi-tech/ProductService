package com.example.Ecommerce.Controller;

import com.example.Ecommerce.dto.createProductRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
    @GetMapping("/")
    public String getAllProducts(){
        return "All products";
    }
@PostMapping("/")
    public String createProduct(@RequestBody createProductRequestDto dto){
        return "product created "+dto.getProductName();
    }
@GetMapping("/{productId}")
    public String getProductById(@PathVariable("productId") Integer productId){
        return "user is"+productId;
}
}
