package com.user.controllers;

import com.user.Exception.UserException;
import com.user.models.User;
import com.user.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("")
    public String test() {
        return "You are logged in!";
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signUpUserHandler(@Validated @RequestBody User user) throws UserException {
        User registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> signInHandler(@RequestBody User loginRequest) {
//        return ResponseEntity.ok().body("Test");
//        log.info("Inside login handler: " + loginRequest.getEmail() + loginRequest.getPassword());
        try {
            User user = userService.findUserByEmail(loginRequest.getEmail());
            if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
                throw new UserException();
            }

            return ResponseEntity.ok().body(user.getId().toString());
        } catch (UserException ex) {
            log.info("Login failed: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Invalid email or password");
        }
    }
}
