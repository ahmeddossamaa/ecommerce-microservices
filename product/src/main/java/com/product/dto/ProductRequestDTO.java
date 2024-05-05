package com.product.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductRequestDTO {
    private String name;
    private String description;
    private Double price;
}
