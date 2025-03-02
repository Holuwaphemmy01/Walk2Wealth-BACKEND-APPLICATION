package com.Walk2Wealth.Walk2Wealth_Backend.users.controller.login;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserLoginRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.login.UserLoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {


    @Autowired
    private UserLoginServiceImpl userLoginService;


//    @PostMapping
//    public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
//        try{
//             String response = userLoginService.login(userLoginRequest);
//             return ResponseEntity.ok(response);
////             return ResponseEntity.status(200).body(response);
//        }
//        catch(Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
@PostMapping
public ResponseEntity<?> login(@RequestBody UserLoginRequest userLoginRequest) {
    try {
        String response = userLoginService.login(userLoginRequest);
        return ResponseEntity.ok(response);
    } catch (AuthenticationException e) { // Catch AuthenticationException
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password"); // Return 401
    } catch (Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    }


}
