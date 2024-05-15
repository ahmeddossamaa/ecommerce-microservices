package com.order.dto;

import com.order.models.Order;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class OrderRequestDto {
    private UUID user_id;
    private Double total_price;
    private List<ProductDto> products;

    public OrderRequestDto() {}

    public OrderRequestDto(Order order){
        this.user_id = order.getUser_id();
        this.total_price = order.getTotal_price();
    }
}
