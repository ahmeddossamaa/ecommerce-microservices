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
        log.info("Attempting to log in user: {}", loginRequest.getEmail());
        try {
            User user = userService.findUserByEmail(loginRequest.getEmail());
            if (user == null) {
                log.error("Login failed for user: {} - User not found", loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Invalid email or password");
            }


            if (!userService.validatePassword(loginRequest.getPassword(), user.getPassword())) {
                log.error("Login failed for user: {} - Invalid password", loginRequest.getEmail());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: Invalid email or password");
            }

            log.info("Authentication successful for user: {}", loginRequest.getEmail());


            String jwt = userService.generateJwtToken(user);

            return ResponseEntity.ok()
                    .header("Authorization", "Bearer " + jwt)
                    .body("Login successful");
        } catch (UserException ex) {
            log.error("Login failed for user: {} - {}", loginRequest.getEmail(), ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + ex.getMessage());
        } catch (Exception ex) {
            log.error("Login failed for user: {} - An error occurred", loginRequest.getEmail(), ex);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: An error occurred");
        }
    }

}
