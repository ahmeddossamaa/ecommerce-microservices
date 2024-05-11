package com.user.services;

import com.user.Exception.UserException;
import com.user.config.SecurityConstants;
import com.user.models.User;
import com.user.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    // Injecting secret key to ensure consistency
    private final SecretKey jwtSecretKey = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

    public User findUserByEmail(String email) throws UserException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserException("No user found with this email: " + email);
        }
        return user;
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public String generateJwtToken(User user) {
        return Jwts.builder()
                .setIssuer("ecommerce")
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 300_000))  // 5 minutes
                .signWith(jwtSecretKey)
                .compact();
    }

    // Uncomment and use this method for validation if needed
    // public Claims validateJwtToken(String token) throws UserException {
    //     try {
    //         return Jwts.parserBuilder()
    //                 .setSigningKey(jwtSecretKey)
    //                 .build()
    //                 .parseClaimsJws(token)
    //                 .getBody();
    //     } catch (ExpiredJwtException ex) {
    //         throw new UserException("Token expired");
    //     } catch (Exception ex) {
    //         throw new UserException("Invalid token");
    //     }
    // }

    public User registerUser(User user) throws UserException {
        User existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            throw new UserException("User already exists with this email: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}