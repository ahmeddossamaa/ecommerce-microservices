package com.order.models;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="orders_products")
@NoArgsConstructor
@Builder

public class OrderProduct {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer order_id;
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Integer product_id;
    private Integer quantity;
    private Double price;

    public OrderProduct(Integer order_id, Integer product_id,Integer quantity , Double price){
        super();
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity=quantity;
        this.price = price ;

    }

}
