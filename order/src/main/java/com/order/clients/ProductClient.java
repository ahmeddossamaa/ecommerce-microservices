package com.order.clients;
import com.order.dto.ProductDto;
import com.order.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product", url = "http://product:8082/api/products")
public interface ProductClient {
    @GetMapping("")
    ResponseEntity<List<ProductDto>> getAll();

    @GetMapping("/order/{id}")
    ResponseEntity<List<ProductDto>> getProductById(@PathVariable("id") Integer id);
}
