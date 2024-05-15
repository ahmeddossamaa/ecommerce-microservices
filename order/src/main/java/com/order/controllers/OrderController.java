package com.order.controllers;
import com.order.dto.OrderRequestDto;
import com.order.dto.OrderResponseDto;
import com.order.models.Order;
import com.order.servisces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
//@AllArgsConstructor
@RequestMapping("api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping("")
    public ResponseEntity<List<Order>> getAll(){
        List<Order>products=this.orderService.getOrders();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOne(@PathVariable Integer id){
        OrderResponseDto orderResponseDto = this.orderService.getOrder(id);

        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<OrderResponseDto> create(@RequestBody OrderRequestDto orderRequestDto) {
        OrderResponseDto createdOrder = orderService.createOrder(orderRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        orderService.deleteOrder(id);

        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
