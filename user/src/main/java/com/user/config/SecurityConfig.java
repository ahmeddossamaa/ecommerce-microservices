package com.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import com.user.jwt.JwtAuthenticationFilter;
import com.user.jwt.JwtValidationFilter;
import java.util.Collections;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class).build();
    }

    @Bean
    public SecurityFilterChain mySecurityConfig(HttpSecurity http) throws Exception {
        // CORS configuration
        http
                .sessionManagement(sessionMangement -> sessionMangement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors(cors -> {
                    cors.configurationSource(request -> {
                        CorsConfiguration cfg = new CorsConfiguration();
                        cfg.setAllowedOriginPatterns(Collections.singletonList("*"));
                        cfg.setAllowedMethods(Collections.singletonList("*"));
                        cfg.setAllowCredentials(true);
                        cfg.setAllowedHeaders(Collections.singletonList("*"));
                        cfg.setExposedHeaders(Collections.singletonList("Authorization"));
                        return cfg;
                    });
                })
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/users/**").permitAll()
//                        .requestMatchers(HttpMethod.POST, "/api/users/login").permitAll()
//                        .requestMatchers(HttpMethod.GET, "/api/users/").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable())  // Disabling CSRF protection
                .addFilterAfter(new JwtAuthenticationFilter(), BasicAuthenticationFilter.class)
                .addFilterBefore(new JwtValidationFilter(), BasicAuthenticationFilter.class)
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();
    }


}
