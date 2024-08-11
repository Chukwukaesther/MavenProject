package com.semicolon.africa.services;

import com.semicolon.africa.data.model.Item;
import com.semicolon.africa.data.repository.ItemRepository;
import com.semicolon.africa.dto.request.AddItemRequest;
import com.semicolon.africa.dto.response.AddItemResponse;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public AddItemResponse addItem(AddItemRequest request) {
        Item item = new Item();
        item.setItemName(request.getItemName());
        item.setItemPrice(request.getItemPrice());
        item.setQuantity(request.getItemQuantity());
        itemRepository.save(item);
        AddItemResponse response = new AddItemResponse();
        response.setMessage("Successfully added item");
        return response;
    }

    @Override
    public void delete(String id) {
         itemRepository.deleteById(id);
    }


}