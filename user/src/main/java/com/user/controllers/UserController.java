package com.user.controllers;

import com.user.Exception.UserException;
import com.user.models.User;
import com.user.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private AuthenticationManager authenticationManager;

    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("")
    public String test(){
        return "You are logged in!";
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUpUserHandler(@Validated @RequestBody User user) throws UserException {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }


    @PostMapping("/login")
    public ResponseEntity<?> signInHandler(@RequestBody User loginRequest) {
        log.info("Inside login filter ...."+loginRequest.getEmail()+ loginRequest.getPassword());
        try {
            log.info("Inside try filter ...."+loginRequest.getEmail()+ loginRequest.getPassword());
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())

            );
            log.info("Inside login try .."+authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String jwt = userService.generateJwtToken(authentication);

            return ResponseEntity.ok().header("Authorization", "Bearer " + jwt).body("Login successful");
        } catch (AuthenticationException ex) { log.info("Inside the catch  ....");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Invalid email or password");
        }
    }


}
