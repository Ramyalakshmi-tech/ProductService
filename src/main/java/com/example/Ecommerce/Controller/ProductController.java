package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Service.iProductService;
import com.example.Ecommerce.dto.createProductRequestDto;
import com.example.Ecommerce.fakeStoreApi.FakeStoreProductResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {
    private iProductService productService;
    public ProductController(iProductService productService){
        this.productService=productService;
    }
    @GetMapping("/{productId}")
    public HttpEntity<FakeStoreProductResponse> getProductById(@PathVariable("productId") Long productId)
            throws Exception{
        FakeStoreProductResponse data=productService.getProductById(productId);
        try {
            if (Objects.isNull(data)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            MultiValueMap<String,String> headers=new LinkedMultiValueMap<>();
            headers.add("class-name","Integrating APIS");
            return new ResponseEntity<>(data,headers,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public HttpEntity<List<FakeStoreProductResponse>> getAllProducts(){
        List<FakeStoreProductResponse> responseList=productService.getAllProducts();
        return new ResponseEntity<>(responseList,HttpStatus.OK);
    }

}
