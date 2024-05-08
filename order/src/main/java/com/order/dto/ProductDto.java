package com.order.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDto {

    private Integer id;
    private String name;
    private Double price;


}
