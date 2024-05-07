package com.product.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CollectionId;

@Entity
@Setter
@Getter
@Table(name = "orders_products")
@IdClass(OrderProductId.class)
public class OrderProduct {
    @Id
    @Column(name = "order_id")
    private Integer orderId;
    @Id
    private Integer product_id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}


class OrderProductId {
    private Integer orderId;
    private Integer product_id;
}
