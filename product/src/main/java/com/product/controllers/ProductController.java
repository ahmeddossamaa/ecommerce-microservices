package com.product.controllers;

import com.product.dto.ProductRequestDTO;
import com.product.models.Product;
import com.product.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<Product>> getAll(){
        List<Product>products=this.productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Product> create(@RequestBody  ProductRequestDTO product){
        Product newProduct=this.productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable int id, @RequestBody ProductRequestDTO requestDTO){
        Product updatedProduct=this.productService.updateProduct(id,requestDTO);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Deleted Successfully!", HttpStatus.OK);
    }
}
