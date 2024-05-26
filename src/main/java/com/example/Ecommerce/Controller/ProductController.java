package com.example.Ecommerce.Controller;

import com.example.Ecommerce.Service.iProductService;
import com.example.Ecommerce.dto.ProductRequestDto;
import com.example.Ecommerce.dto.ProductResponseDto;
import com.example.Ecommerce.fakeStoreApi.FakeStoreProductResponse;
import com.example.Ecommerce.mapper.ProductMapper;
import com.example.Ecommerce.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/products")
public class ProductController {
    private iProductService productService;

    public ProductController(iProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public HttpEntity<ProductResponseDto> getProductById(@PathVariable("productId") Long productId)
            throws Exception {

        try {
            Product data = productService.getProductById(productId);
            if (Objects.isNull(data)) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("class-name", "Integrating APIS");

            ProductResponseDto dto = ProductMapper.getProductResponseDtoFromProduct(data);
            return new ResponseEntity<>(dto, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public HttpEntity<List<ProductResponseDto>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductResponseDto> responseList = ProductMapper.getProductResponseDtoListFromProducts(products);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PatchMapping("/{productId}")
    public String createProduct(@RequestBody ProductRequestDto dto) {
        //hw
        return "product created.. + " + dto.getProductName();
    }

    public HttpEntity<ProductResponseDto> patchProduct(@PathVariable("productId") Long productId,
                                                       @RequestBody ProductRequestDto dto) throws Exception {
        try {
            Product product = productService.patchproduct(productId,
                    ProductMapper.getProductFromCreateRequestDTO(dto));

            ProductResponseDto responseDTO = ProductMapper.getProductResponseDtoFromProduct(product);
            return new ResponseEntity<>(responseDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
