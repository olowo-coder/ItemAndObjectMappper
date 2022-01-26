package com.example.items.repository;

import com.example.items.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findByNameContaining(String name);
    Optional<Item> findByName(String name);
}
