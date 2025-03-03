package com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.createWallet;

import com.Walk2Wealth.Walk2Wealth_Backend.wallet.dtos.request.CreateWalletRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class CreateWalletServiceImplTest {

    @Autowired
    private CreateWalletService createWalletService;

    @Test
    public void toTestThrowExceptionWhenUsernameIsEmpty() {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setUsername("");
        IllegalArgumentException response = (assertThrows(IllegalArgumentException.class, () -> createWalletService.createWallet(createWalletRequest)));
        assertEquals("Username cannot be empty", response.getMessage());
    }

    @Test
    public void toTestThrowExceptionWhenPasswordsEmpty() {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setUsername("Username");
        createWalletRequest.setPassword("");
        IllegalArgumentException response = (assertThrows(IllegalArgumentException.class, () -> createWalletService.createWallet(createWalletRequest)));
        assertEquals("Password cannot be empty", response.getMessage());
    }

    @Test
    public void toTestThrowExceptionWhenUsernameIsNotCorrect() {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setUsername("Username");
        createWalletRequest.setPassword("Password");
        IllegalArgumentException response = (assertThrows(IllegalArgumentException.class, () -> createWalletService.createWallet(createWalletRequest)));
        assertEquals("User not found", response.getMessage());
    }


    @Test
    public void toTestThrowExceptionWhenPasswordIsLessThan8Characters() {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setUsername("Holuwaphemmy01");
        createWalletRequest.setPassword("Pass");
        IllegalArgumentException response = (assertThrows(IllegalArgumentException.class, () -> createWalletService.createWallet(createWalletRequest)));
        assertEquals("Wallet Password should be at least 8 character.", response.getMessage());
    }

    @Test
    public void toTestToGetWalletSuccessful() throws Exception {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setUsername("Holuwaphemmy01");
        createWalletRequest.setPassword("OLuwayemi2002..,");
        String response = createWalletService.createWallet(createWalletRequest);
        System.out.println(response);
        assertNotNull(response);
    }


}