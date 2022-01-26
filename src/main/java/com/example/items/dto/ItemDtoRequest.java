package com.example.items.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class ItemDtoRequest {
    private String name;
    private String description;
    private BigDecimal price;
}
