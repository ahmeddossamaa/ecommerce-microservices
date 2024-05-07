package com.order.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
@Entity
@Setter
@Getter
@Builder
public class ProductDto {

    private String name;
    @Id private Integer id;


}
