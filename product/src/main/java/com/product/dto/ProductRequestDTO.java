package com.product.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
}
