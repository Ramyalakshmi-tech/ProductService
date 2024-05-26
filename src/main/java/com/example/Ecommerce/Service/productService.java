package com.example.Ecommerce.Service;

import com.example.Ecommerce.Util.HttpUtil;
import com.example.Ecommerce.fakeStoreApi.FakeStoreProductRequestDto;
import com.example.Ecommerce.fakeStoreApi.FakeStoreProductResponse;
import com.example.Ecommerce.mapper.ProductMapper;
import com.example.Ecommerce.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class productService implements iProductService {
    RestTemplateBuilder restTemplate;
    public productService(RestTemplateBuilder restTemplate){
            this.restTemplate=restTemplate;
    }
@Override
    public Product getProductById(Long productId){
        FakeStoreProductResponse dto=restTemplate.build().getForEntity(
                "https://fakestoreapi.com/products/{id}",
                FakeStoreProductResponse.class,
                productId).getBody();
                return ProductMapper.getProductFromFakeStoreProduct(dto);
    }
@Override
    public List<Product> getAllProducts(){
        FakeStoreProductResponse[] dto=restTemplate.build().getForEntity(
                "https://fakestoreapi.com/products",
                FakeStoreProductResponse[].class).getBody();
        return ProductMapper.getProductListFromFakeStoreList(dto);
    }



    @Override
    public Product patchproduct(Long productId, Product product) throws Exception{
        Product existingProduct=getProductById(productId);
        if (Objects.isNull(existingProduct)){
            throw new Exception("Product does not exist");
        }

        FakeStoreProductRequestDto requestDto=new FakeStoreProductRequestDto();
        requestDto.setCategory(product.getCategory());
        requestDto.setPrice(product.getPrice());
        requestDto.setImage(product.getImageURL());
        requestDto.setTitle(product.getProductName());

        ResponseEntity<FakeStoreProductResponse> response= HttpUtil.requestForEntity(restTemplate, HttpMethod.PATCH,
                "https://fakestoreapi.com/products/{id}",  requestDto, FakeStoreProductResponse.class, productId);
    return ProductMapper.getProductFromFakeStoreProduct(response.getBody());
    }
}
