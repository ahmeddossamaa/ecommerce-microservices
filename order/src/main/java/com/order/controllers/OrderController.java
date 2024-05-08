package com.order.controllers;

import com.order.models.Order;
import com.order.models.OrderProduct;
import com.order.models.OrderView;
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
@RequestMapping("api/orders")
public class OrderController {

private final OrderService orderService;

    @GetMapping("")
    public ResponseEntity<List<OrderView>> getAll(){
        List<OrderView>products=this.orderService.getorders();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOne(@PathVariable Integer id){
        Order order = this.orderService.getOrder(id);

//        List<Product> products = this.productClient.getProductsById(id);
//        order.setProducts(products);

        /*
        * {
        *   id: 1,
        *   created_at: '',
        *   total_price: 100,
        *   user_id: '',
        *   products: [
        *       {
        *           id: 1,
    *               name: ''
        *       }
        *   ]
        * }
        * */

        return new ResponseEntity<>(order, HttpStatus.OK);
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
