package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.ProductRequest;
import com.semicolon.africa.dto.response.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceImplTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @BeforeEach
    void setUp(){
        productRepository.deleteAll();
    }


    @Test
    void addProduct() {
        ProductRequest addProductRequest = new ProductRequest();
        addProductRequest.setProductName("Banana");
        addProductRequest.setProductPrice(300.00);
        addProductRequest.setProductQuantity("4");
        addProductRequest.setProductId("987");
        addProductRequest.getProductCategory();
        productServiceImpl.addProduct(addProductRequest);
        ProductResponse response = new ProductResponse();
        response.setMessage("login Successful");
        assertEquals(productRepository.count(), 1);

    }

    @Test
    void delete() {
    }
}