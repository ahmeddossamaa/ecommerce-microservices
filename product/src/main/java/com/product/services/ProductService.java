package com.product.services;

import com.product.models.Product;
import com.product.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.aspectj.bridge.MessageUtil.print;

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
    public Product updateProduct(int id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found"));
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setDescription(updatedProduct.getDescription());
        return productRepository.save(existingProduct);
    }
    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }


}
