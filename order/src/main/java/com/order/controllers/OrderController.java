package com.order.controllers;
import com.order.clients.ProductClient;
import com.order.dto.OrderDto;
import com.order.dto.ProductDto;
import com.order.models.Order;
import com.order.models.OrderProduct;
import com.order.models.Product;
import com.order.servisces.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.UUID;

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
    public ResponseEntity<OrderDto> getOne(@PathVariable Integer id){
        OrderDto orderDto = this.orderService.getOrder(id);

        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<OrderDto> create(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.createOrder(orderDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        orderService.deleteOrder(id);

        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
