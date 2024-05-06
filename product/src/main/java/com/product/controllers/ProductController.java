package com.product.controllers;

import com.product.dto.ProductRequestDTO;
import com.product.models.Product;
import com.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("")
    public List<Product> getAll(){
        return this.productService.getProducts();
    }

    @PostMapping("")
    public Product create(@RequestBody ProductRequestDTO requestDTO){
        String name = requestDTO.getName();

        return this.productService.createProduct(name);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody ProductRequestDTO requestDTO){
        String name = requestDTO.getName();
        Double price = requestDTO.getPrice();
        String description = requestDTO.getDescription();
        Product newProduct=new Product(name, price, description);
        return this.productService.updateProduct(id, newProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        productService.deleteProductById(id);

        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
