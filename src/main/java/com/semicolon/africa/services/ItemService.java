package com.semicolon.africa.services;

import com.semicolon.africa.dto.request.AddItemRequest;
import com.semicolon.africa.dto.response.AddItemResponse;

public interface ItemService {
    AddItemResponse addItem(AddItemRequest request);
    void delete(String id);


}
