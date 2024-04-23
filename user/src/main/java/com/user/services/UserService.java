package com.user.services;

import com.user.clients.ProductClient;
import com.user.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ProductClient productClient;

    public List<Product> getAllProducts(){
        return this.productClient.getAll();
    }
}
