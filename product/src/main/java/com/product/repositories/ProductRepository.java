package com.product.repositories;

import com.product.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.description) LIKE %?1%")
    List<Product> search(String name);

    List<Product> findByOrdersProductsOrderId(Integer orderId);
}
