package com.example.items.controller;

import com.example.items.dto.ItemDtoRequest;
import com.example.items.model.Item;
import com.example.items.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<?> getAllItems(){
        return ResponseEntity.ok(itemService.getAllItems());
    }

    @GetMapping("/internal")
    public ResponseEntity<?> findAllItems(){
        return ResponseEntity.ok(itemService.findAllItems());
    }

    @GetMapping("/data/{id}")
    public ResponseEntity<?> getItemById(@PathVariable String id){
        return ResponseEntity.ok(itemService.getById(id));
    }

    @GetMapping("/info")
    public ItemDtoRequest findOneItem(@RequestParam String name){
        return itemService.getInfo(name);
    }

    @PostMapping
    public ResponseEntity<?> addItems(@RequestBody ItemDtoRequest itemDtoRequest){
        return new ResponseEntity<>(itemService.saveItem(itemDtoRequest), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.FOUND)
    public ResponseEntity<?> searchItems(@RequestParam("search") String name){
        return ResponseEntity.ok(itemService.searchForItems(name));
    }

    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody ItemDtoRequest itemDtoRequest){
        return ResponseEntity.ok(itemService.updateItem(itemDtoRequest));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> remove(@PathVariable String id){
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }

}
