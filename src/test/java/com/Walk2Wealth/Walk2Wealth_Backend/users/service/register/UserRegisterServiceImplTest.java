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
    public void testToThrowExceptionWhenPasswordIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("email@gmail.com");
        userRegisterRequest.setPassword("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});

    }

    @Test
    public void testToThrowExceptionWhenPasswordDoesNotIncludeUpperCase() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("adele");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenPasswordDoesIncludeLowerCase(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("ADELE");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }


    @Test
    public void testToThrowExceptionWhenPasswordDoesNotIncludeNumbers() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenPasswordDoesNotIncludeSymbols() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }
    @Test
    public void testToThrowExceptionWhenGenderIsNotMaleNorFemale() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123..,");
        userRegisterRequest.setGender("Gay");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }





}