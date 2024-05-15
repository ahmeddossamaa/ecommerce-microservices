package com.order.servisces;

import com.order.clients.ProductClient;
import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.dto.ProductDto;
import com.order.models.Order;
import com.order.models.OrderProduct;
import com.order.repositories.OrderProductRepository;
import com.order.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProductRepository orderProductRepository;

    private final ProductClient productClient;

    public List<Order> getOrders(){
        return this.orderRepository.findAll();
    }

    public OrderResponseDto getOrder(Integer id){
        Order order = this.orderRepository.findById(id).orElseThrow();

        List<ProductDto> products = this.productClient.getProductById(id).getBody();

        OrderResponseDto orderResponseDto = new OrderResponseDto(order);

        orderResponseDto.setProducts(products);

        return orderResponseDto;
    }

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
        Order order = this.orderRepository.save(
            new Order(orderRequestDto.getUser_id(), orderRequestDto.getTotal_price())
        );

        this.orderProductRepository.saveAll(
            orderRequestDto
            .getProducts()
            .stream()
            .map(
                p -> new OrderProduct(
                    order.getId(),
                    p.getId(),
                    1,
                    p.getPrice()
                )
            )
            .collect(Collectors.toList())
        );

        OrderResponseDto orderResponseDto = new OrderResponseDto(order);

        orderResponseDto.setProducts(orderRequestDto.getProducts());

        return orderResponseDto;
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
