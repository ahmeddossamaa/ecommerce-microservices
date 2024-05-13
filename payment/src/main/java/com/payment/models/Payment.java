package com.payment.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Time;

@Entity
@Setter
@Getter
@Table(name = "payments")
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "price")
    private Double price;

    @Column(name = "created_at")
    @CurrentTimestamp()
    private Time createdAt;

    public Payment(Integer id) {
        this.id = id;
    }

    public Payment(Integer orderId, Double price) {
        this.orderId = orderId;
        this.price = price;
    }
}
