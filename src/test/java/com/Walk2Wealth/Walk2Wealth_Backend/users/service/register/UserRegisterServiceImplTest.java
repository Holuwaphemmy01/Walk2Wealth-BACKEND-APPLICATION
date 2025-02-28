package com.Walk2Wealth.Walk2Wealth_Backend.users.service.register;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserRegisterServiceImplTest {

    @Autowired
    private UserRegisterService userRegisterService;

    @Test
    public void testToThrowExceptionWhenFirstNameIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenLastNameIsEmpty() {
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
        userRegisterRequest.setEmail("adele@gmail.com");
        userRegisterRequest.setPassword("password");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenPasswordDoesIncludeLowerCase(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele@gmail.com");
        userRegisterRequest.setPassword("PASSWORD");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }


    @Test
    public void testToThrowExceptionWhenPasswordDoesNotIncludeNumbers() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("ADELE@gmail.com");
        userRegisterRequest.setPassword("Password");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenPasswordDoesNotIncludeSymbols() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele@gmail.com");
        userRegisterRequest.setPassword("Password123");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }
    @Test
    public void testToThrowExceptionWhenGenderIsNotMaleNorFemale() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password..,123");
        userRegisterRequest.setGender("Gay");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenUsernameIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenUsernameLengthIsLessThanSix() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("Adere");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenUsernameDoesNotStartWithAlphabet(){
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("1dere");
        assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
    }


    @Test
    public void testToThrowExceptionWhenPhoneNumberIsEmpty() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("UserNAame");
        userRegisterRequest.setPhoneNumber("");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
        assertEquals("Invalid phone number", exception.getMessage());

    }

    @Test
    public void testToThrowExceptionWhenPhoneNumberDoesNotStartWithZero() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("UserNAame");
        userRegisterRequest.setPhoneNumber("132234");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testToThrowExceptionWhenPhoneNumberLengthIsNotEleven() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("UserNAame");
        userRegisterRequest.setPhoneNumber("08176535");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {userRegisterService.registerUser(userRegisterRequest);});
        assertEquals("Invalid phone number", exception.getMessage());
    }

    @Test
    public void testToRegisterUserSuccessfullyAndNoExceptionIsThrown() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("Oluwafemi");
        userRegisterRequest.setPhoneNumber("08125540752");
        assertDoesNotThrow(() -> {userRegisterService.registerUser(userRegisterRequest);});
    }

    @Test
    public void testToThrowExceptionWhenARegisteredUsernameIsUsedAgainToRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("Oluwafemi");
        userRegisterRequest.setPhoneNumber("08125540752");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> userRegisterService.registerUser(userRegisterRequest));
        assertEquals("Username already exists", exception.getMessage());
    }

    @Test
    public void testToThrowExceptionWhenARegisteredEmailIsUsedAgainToRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Adele123@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("Oluwafemi2002");
        userRegisterRequest.setPhoneNumber("08125540752");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> userRegisterService.registerUser(userRegisterRequest));
        assertEquals("Email already exists", exception.getMessage());
    }


    @Test
    public void testToThrowExceptionWhenARegisteredPhoneNumbersUsedAgainToRegister() {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setFirstName("firstName");
        userRegisterRequest.setLastName("lastName");
        userRegisterRequest.setEmail("Email@gmail.com");
        userRegisterRequest.setPassword("Password123..,");
        userRegisterRequest.setGender("Male");
        userRegisterRequest.setUserName("Oluwafemi2002");
        userRegisterRequest.setPhoneNumber("08125540752");
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, ()-> userRegisterService.registerUser(userRegisterRequest));
        assertEquals("Phone number already exists", exception.getMessage());
    }








}