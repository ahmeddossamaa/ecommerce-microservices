package com.order.dto;

import com.order.models.Order;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
public class OrderResponseDto {
    private Integer id;
    private UUID user_id;
    private Double total_price;
    private Time created_at;
    private List<ProductDto> products;

    public OrderResponseDto() {}

    public OrderResponseDto(Order order){
        this.id = order.getId();
        this.user_id = order.getUser_id();
        this.total_price = order.getTotal_price();
        this.created_at = order.getCreated_at();
    }
}
