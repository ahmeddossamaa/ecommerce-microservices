package com.user.controllers;

import com.user.models.Product;
import com.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;

    @GetMapping("")
    public List<Product> getAll(){
        return this.userService.getAllProducts();
    }

    @PostMapping("login")
    public String login(){
        return "You are logged in!";
    }

    @PostMapping("signup")
    public void signup(){

    }
}
