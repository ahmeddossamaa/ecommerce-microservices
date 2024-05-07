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
@IdClass(OrderProductId.class)
public class OrderProduct {
    @Id  private Integer order_id;
    @Id private Integer product_id;
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

 class OrderProductId{
    private Integer order_id ;
    private Integer product_id ;

}
