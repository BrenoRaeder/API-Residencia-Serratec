package com.grupoone.instrutor.security.jwt;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.grupoone.instrutor.security.service.UserDetailsImpl;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${app.jwt.secret}")
	private String jwtSecret;

	@Value("${app.jwt.expiration.ms}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {

		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.builder()
					.setSubject((userPrincipal.getUsername()))
					.setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
					.signWith(key)
					.compact();
	}

	public String getUserNameFromJwtToken(String token) {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		return Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(authToken).getBody().getSubject();
			return true;
		}catch (JwtException e) {
			logger.error("Token JWT inválido: {}", e.getMessage());
		}
		return false;
	}
}