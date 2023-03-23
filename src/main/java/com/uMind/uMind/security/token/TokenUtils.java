package com.uMind.uMind.security.token;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "eyJhbGciOiJIUzI1NiJ9aeyJSb2xlIjoiQWRtaW4iLCJJc3N1ZXIiOiJJc3N1ZXIiLCJVc2VybmFtZSI6IkphdmFJblVzZSIsImV4cCI6MTY3OTU4MzkwMiwiaWF0IjoxNjc5NTgzOTAyfQsZhRNpDrQoXCvGrrLBejWf87ppUZlclJTBbBDqFuO3es";
    private final static Long ACCESS_TOKEN_EXPIRATION = 2_592_000L;

    public static String createToken(String nombre, String email) {
        long expirationTime = ACCESS_TOKEN_EXPIRATION * 1_000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", nombre);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(SignatureAlgorithm.HS256, ACCESS_TOKEN_SECRET)
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            String login = Jwts.parser()
                    .setSigningKey(ACCESS_TOKEN_SECRET)
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();

            return new UsernamePasswordAuthenticationToken(login, null, Collections.emptyList());
        } catch (JwtException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
