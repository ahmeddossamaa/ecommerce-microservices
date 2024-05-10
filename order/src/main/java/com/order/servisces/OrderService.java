package com.order.servisces;

import com.order.models.Order;
import com.order.models.OrderProduct;
import com.order.repositories.OrderProductRepository;
import com.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    public List<Order> getOrders(){
        return this.orderRepository.findAll();
    }

    public Order getOrder(Integer id){
        return this.orderRepository.findById(id).orElseThrow();
    }

    public void deleteOrder(Integer id) {
        this.orderRepository.deleteById(id);
    }

    public Order createOrderWithProducts(UUID user_id, Double total_price, Time created_at, List<OrderProduct> orderProducts) {
        Order newOrder = Order.builder()
                .user_id(user_id)
                .total_price(total_price)
                .created_at(created_at)
                .build();

        Order savedOrder = orderRepository.save(newOrder);
        for (OrderProduct op : orderProducts) {
            op.setOrder_id(savedOrder.getId());
            orderProductRepository.save(op);
        }
        return savedOrder;
    }
}