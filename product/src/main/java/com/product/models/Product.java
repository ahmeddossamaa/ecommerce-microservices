package com.product.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="products")
@NoArgsConstructor
public class Product {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String name;

    public Product(String name){
        super();

        this.name = name;
    }
}
