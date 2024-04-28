package com.product.services;

import com.product.models.Product;
import com.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts(){
        return this.productRepository.findAll();
    }

    public Product createProduct(String name){
        Product product = new Product(name);

        return this.productRepository.save(product);
    }
}
