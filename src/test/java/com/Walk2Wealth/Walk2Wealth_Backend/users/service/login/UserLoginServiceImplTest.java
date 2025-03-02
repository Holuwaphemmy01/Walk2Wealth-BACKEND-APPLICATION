package com.Walk2Wealth.Walk2Wealth_Backend.users.service.login;


import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserLoginRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.springframework.test.util.AssertionErrors.*;


@SpringBootTest
public class UserLoginServiceImplTest {

    @Autowired
    private UserLoginServiceImpl userLoginService;

    @Test
    public  void testLogin() {
        UserLoginRequest userLoginRequest = new UserLoginRequest();
        userLoginRequest.setUsername("Holuwaphemmy01");
        userLoginRequest.setPassword("Oluwayemi2002..,");
        String response = assertDoesNotThrow(()->userLoginService.login(userLoginRequest));
        System.out.println(response);
    }

}