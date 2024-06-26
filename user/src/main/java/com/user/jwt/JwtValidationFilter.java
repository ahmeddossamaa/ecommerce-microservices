package com.user.jwt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JwtValidationFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// log.info("Inside JWT validation filter.");

		// String jwt = request.getHeader(SecurityConstants.JWT_HEADER);

		// if (jwt != null) {

		// 	try {
		// 		// Extracting the word Bearer
		// 		jwt = jwt.substring(7);

		// 		SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

		// 		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();

		// 		String username = String.valueOf(claims.get("username"));

		// 		List<GrantedAuthority> authorities = new ArrayList<>();

		// 		Authentication auth = new UsernamePasswordAuthenticationToken(username, null, authorities);

		// 		SecurityContextHolder.getContext().setAuthentication(auth);

		// 	} catch (Exception e) {
		// 		throw new BadCredentialsException("Invalid JWT Token received.");
		// 	}
		// }

		// filterChain.doFilter(request, response);
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		return false;
	}
}