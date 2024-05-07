package com.product.services;
import com.product.dto.ProductRequestDTO;
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
    public Product createProduct(ProductRequestDTO productDTO){
        return this.productRepository.save(Product.builder()
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .build());
    }
    public Product updateProduct(int id, ProductRequestDTO updatedProduct) {
        return productRepository.findById(id)
                .map(existingProduct->{
                    existingProduct.setName(updatedProduct.getName());
                    existingProduct.setPrice(updatedProduct.getPrice());
                    existingProduct.setDescription(updatedProduct.getDescription());
                    return this.productRepository.save(existingProduct);
                })
                .orElseThrow(() -> new IllegalArgumentException("Product with ID " + id + " not found"));
    }
    public void deleteProduct(Integer id) {
        this.productRepository.deleteById(id);
    }
    public List<Product> searchProducts(String name) {
        if (!name.isEmpty()) {
            try {
                return this.productRepository.search(name.toLowerCase());
            } catch (Exception e) {
                throw new  IllegalArgumentException("Couldn't find any product with name " + name);
            }
        }
        return this.productRepository.findAll();
    }

    public List<Product> getProductsByOrderId(Integer id){
        return this.productRepository.findByOrdersProductsOrderId(id);
    }
}