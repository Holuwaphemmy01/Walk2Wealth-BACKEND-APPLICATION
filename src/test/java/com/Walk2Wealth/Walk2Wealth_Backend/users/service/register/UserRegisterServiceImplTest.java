package com.Walk2Wealth.Walk2Wealth_Backend.users.service.register;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRegisterServiceImplTest {

    @Autowired
    private UserRegisterService userRegisterService;

    @Test
    public void testToThrowExceptionWhenFirstNameIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenlastNameIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenEmailIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenEmailIsInvalid() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("email");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

}