package com.order.controllers;
import com.order.clients.ProductClient;
import com.order.dto.OrderDto;
import com.order.dto.ProductDto;
import com.order.models.Order;
import com.order.models.OrderProduct;
import com.order.models.OrderView;
import com.order.servisces.OrderService;
import lombok.AllArgsConstructor;
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
    private final ProductClient productClient;

    @GetMapping("")
    public ResponseEntity<List<OrderView>> getAll(){
        List<OrderView>products=this.orderService.getorders();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOne(@PathVariable Integer id){
        Order order = this.orderService.getOrder(id);
        List<ProductDto> products = this.productClient.getProductById(id);

        OrderDto orderDto = new OrderDto(order);

        orderDto.setProducts(products);

        return new ResponseEntity<>(orderDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
       orderService.deleteorder(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }

    @PostMapping("/create-with-products")
    public ResponseEntity<Order> createOrderWithProducts(
            @RequestParam UUID user_id,
            @RequestParam Double total_price,
            @RequestParam Time created_at,
            @RequestBody List<OrderProduct> orderProducts
    ) {
        // Create the Order and associated OrderProduct records
        Order createdOrder = orderService.createOrderWithProducts(
              user_id, total_price, created_at, orderProducts);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder); // Return the created Order
    }

}
