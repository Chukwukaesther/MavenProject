package com.semicolon.africa.services;

import com.semicolon.africa.dto.request.ProductRequest;
import com.semicolon.africa.dto.response.ProductResponse;

public interface ProductService {
    ProductResponse addProduct(ProductRequest productRequest);
    void delete(String id);


}
