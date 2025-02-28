package com.Walk2Wealth.Walk2Wealth_Backend.users.controller.register;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.register.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {


    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        try{
            String response = userRegisterService.registerUser(userRegisterRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
