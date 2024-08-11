package com.semicolon.africa.services;

import com.semicolon.africa.data.repository.ItemRepository;
import com.semicolon.africa.dto.request.AddItemRequest;
import com.semicolon.africa.dto.response.AddItemResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class ItemServiceImplTest {
    @Autowired
    private ItemRepository itemRepository;
    private ItemServiceImpl itemServiceImpl;

    @BeforeEach
    void setUp() {
        itemRepository.deleteAll();

    }
    @Test
    public void TestAddItem() {
        AddItemRequest addItemRequest = new AddItemRequest();
        addItemRequest.setItemName("Banana");
        addItemRequest.setItemPrice(300.00);
        addItemRequest.setItemQuantity(3);
        itemServiceImpl.addItem(addItemRequest);

        addItemRequest.setItemName("Orange");
        addItemRequest.setItemPrice(300.00);
        addItemRequest.setItemQuantity(3);
        itemServiceImpl.addItem(addItemRequest);

        addItemRequest.setItemName("Apple");
        addItemRequest.setItemPrice(300.00);
        addItemRequest.setItemQuantity(3);
        AddItemResponse addItemResponse = itemServiceImpl.addItem(addItemRequest);
        assertEquals(itemRepository.count(), 3);


    }
    @Test
    public void TestDelete() {
        AddItemRequest addItemRequest = new AddItemRequest();
        addItemRequest.setItemName("Banana");
        addItemRequest.setItemPrice(300.00);
        addItemRequest.setItemQuantity(8);

        addItemRequest.setItemName("Orange");
        addItemRequest.setItemPrice(300.00);
        addItemRequest.setItemQuantity(3);
        itemServiceImpl.addItem(addItemRequest);

        itemServiceImpl.delete("66b72fe9109609789e3aa5d4");
        assertEquals(itemRepository.count(), 1);


    }


}