package com.example.items.service;

import com.example.items.dto.ItemDtoRequest;
import com.example.items.model.Item;
import com.example.items.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public List<ItemDtoRequest> getAllItems() {
        List<Item> itemList = itemRepository.findAll();
        return itemList.stream()
                .map( itemOne -> modelMapper.map(itemOne, ItemDtoRequest.class)).collect(Collectors.toList());
    }

    @Override
    public ItemDtoRequest saveItem(ItemDtoRequest request) {
        Item item = new Item();
        modelMapper.map(request, item);
        itemRepository.save(item);
        return request;
    }

    @Override
    public List<ItemDtoRequest> searchForItems(String name) {
        List<Item> itemList = itemRepository.findByNameContaining(name);
        return itemList.stream()
                .map( itemOne -> modelMapper.map(itemOne, ItemDtoRequest.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String updateItem(ItemDtoRequest itemDtoRequest) {
        itemRepository.findByName(itemDtoRequest.getName())
                .map(itemData -> {
                    itemData.setDescription(itemDtoRequest.getDescription());
                    itemData.setPrice(itemDtoRequest.getPrice());
                    return itemRepository.save(itemData);
                });

        return "Updated";
    }

    @Override
    @Transactional
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }

    @Override
    public ItemDtoRequest getById(String id) {
        Item item = itemRepository.findById(id).orElseThrow(()->new IllegalStateException("Item not found"));
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest();
        modelMapper.map(item, itemDtoRequest);
        return itemDtoRequest;
    }

    @Override
    public ItemDtoRequest getInfo(String name) {
        ItemDtoRequest itemDtoRequest = new ItemDtoRequest();
       Item item = itemRepository.findByName(name)
                .orElseThrow(()->new IllegalStateException("Not in database"));
       modelMapper.map(item, itemDtoRequest);
       return itemDtoRequest;
    }




}
