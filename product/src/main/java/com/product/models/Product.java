package com.product.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name="products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private String name;
    private Double price;
    private String description;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "product")
    private List<OrderProduct> ordersProducts;

    public Product(String name){
        super();
        this.name = name;

    }
    public Product(String name, Double price,String description){
        super();
        this.name = name;
        this.price = price;
        this.description=description;
    }
}
