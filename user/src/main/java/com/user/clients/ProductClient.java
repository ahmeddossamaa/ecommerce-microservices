package com.user.clients;
import com.user.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "product", url = "http://product:8082/api/products")
public interface ProductClient {
    @GetMapping("")
    List<Product> getAll();

    @GetMapping("/order/{id}")
    List<Product> getProductById(Integer id);
}
