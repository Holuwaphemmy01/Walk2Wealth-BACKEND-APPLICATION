package com.Walk2Wealth.Walk2Wealth_Backend.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {


    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .claims()
                .add(claims)
                ;
    }
}
