package com.user.services;

import com.user.Exception.UserException;
import com.user.models.User;
import com.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User findUserByEmail(String email) throws UserException {

        User user = userRepository.findByEmail(email);

        if(user==null)
        {
            throw new UserException("No user found with this email : "+email);
        }

        return user;
    }

    public User registerUser(User user) throws UserException {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if(existingUser != null) {
            throw new UserException("User already exists with this email: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public String generateJwtToken(Authentication authentication) {
        SecretKey key = Keys.hmacShaKeyFor("secretkey$77$kumawat~skking99~".getBytes());
        return Jwts.builder()
                .setIssuer("ecomerce")
                .setSubject(authentication.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 300_000))  // 5 minutes
                .signWith(key)
                .compact();
    }
}
