package com.Walk2Wealth.Walk2Wealth_Backend.users.service.login;

import com.Walk2Wealth.Walk2Wealth_Backend.jwt.JwtService;
import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UserLoginServiceImpl {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;


    public String login(UserLoginRequest userLoginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginRequest.getUsername(), userLoginRequest.getPassword()));

        if(!authentication.isAuthenticated()) throw new IllegalArgumentException("Invalid username or password");
        else return jwtService.generateToken(userLoginRequest.getUsername());
    }
}
