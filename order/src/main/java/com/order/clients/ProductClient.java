package com.order.clients;
import com.order.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product", url = "http://product:8082/api/products")
public interface ProductClient {
    @GetMapping("/order/{id}")
    List<ProductDto>getProductById(@PathVariable("id") Integer id);
}
