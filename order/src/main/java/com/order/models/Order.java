package com.order.models;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="orders")
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private UUID user_id;

    private Double total_price;

    @CreatedDate()
    private Time created_at;

    public Order(Integer id){
        super();

        this.id = id;
    }

    public Order(UUID user_id, Double total_price){
        super();

        this.user_id = user_id;
        this.total_price = total_price;
    }
}
