package com.example.items.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "items")
public class Item {

    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
