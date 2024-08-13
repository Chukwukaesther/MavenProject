package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Product;
import com.semicolon.africa.data.repository.ProductRepository;
import com.semicolon.africa.dto.request.ProductRequest;
import com.semicolon.africa.dto.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductResponse addProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setProductId(productRequest.getProductId());
        product.setProductName(productRequest.getProductName());
        product.setProductPrice(productRequest.getProductPrice());
        product.setProductCategory(productRequest.getProductCategory());
        product.setQuantity(productRequest.getProductQuantity());
        productRepository.save(product);
        ProductResponse response = new ProductResponse();
        response.setMessage("Successfully added product");
        return response;
    }

    @Override
    public void delete(String id) {


    }
}
