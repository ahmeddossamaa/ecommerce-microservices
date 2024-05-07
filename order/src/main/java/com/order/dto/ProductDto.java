package com.order.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ProductDto {

    private String name;
    private Integer id;


}
