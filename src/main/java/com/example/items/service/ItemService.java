package com.example.items.service;

import com.example.items.dto.ItemDtoRequest;
import com.example.items.model.Item;

import java.util.List;

public interface ItemService {
    List<ItemDtoRequest> getAllItems();

    ItemDtoRequest saveItem(ItemDtoRequest request);

    List<ItemDtoRequest> searchForItems(String name);

    String  updateItem(ItemDtoRequest itemDtoRequest);

    void deleteItem(String id);

    ItemDtoRequest getById(String id);

    ItemDtoRequest getInfo(String name);

    List<Item> findAllItems();
}
