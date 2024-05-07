package com.order.models;

import com.order.dto.ProductDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name="orders_view")
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class OrderView {

    private Integer id;
    private UUID user_id;
    private Double total_price;
    private Time created_at;
    private List<ProductDto> products;
    public OrderView(Integer id){
        super();
        this.id = id;

    }
    public OrderView(Integer id, Double total_price, UUID user_id , Time time ,List<ProductDto> products  ){
        super();
        this.id = id;
        this.user_id=user_id;
        this.total_price = total_price;
        this.created_at = time ;
        this.products = products;
    }


}
