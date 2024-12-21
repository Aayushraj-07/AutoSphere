package com.codewithaayush.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.Base64;  // For Base64 decoding

@Component
public class JWTUtil {

    // Extracting the username (subject) from the token
    public String extractUserName(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Generate token for the user
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    // Validate if the token is valid based on user details
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    // Generic method to extract claims
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    // Generate a token with additional claims
    private String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))  // 24 hours
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)  // Use HS256 for signing
                .compact();
    }

    // Check if the token is expired
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // Extract the expiration date from the token
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // Extract all claims from the token
    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())  // Use the signing key for parsing
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Get the signing key for signing the token
    private Key getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode("M1U3NYU2ZDkzYjFhOTRhMjkyMzg9OWI3YzM2ZGU4NjllOTZjZGNmZWQ1YzhkOTNiNDlmMGM2OTdjMzcyMDIyOQ==");  // Use a secret key here
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
