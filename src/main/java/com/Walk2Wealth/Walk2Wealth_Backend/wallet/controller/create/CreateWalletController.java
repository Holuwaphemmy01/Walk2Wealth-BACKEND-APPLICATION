package com.Walk2Wealth.Walk2Wealth_Backend.wallet.controller.create;

import com.Walk2Wealth.Walk2Wealth_Backend.wallet.dtos.request.CreateWalletRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.createWallet.CreateWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create_wallet")
public class CreateWalletController {
    @Autowired
    private CreateWalletService createWalletService;


//    @PostMapping
//    public ResponseEntity<?> createWallet(@RequestBody String Password, Authentication authentication) {
//        try{
//                CreateWalletRequest createWalletRequest = new CreateWalletRequest();
//                createWalletRequest.setPassword(Password);
//                createWalletRequest.setUsername(authentication.getName());
//                return ResponseEntity.ok(createWalletService.createWallet(createWalletRequest));
//        }
//        catch(Exception e){
//           return ResponseEntity.status(400).body(e.getMessage());
//        }
//    }
@PostMapping
public ResponseEntity<?> createWallet(@RequestBody String Password, Authentication authentication) { // Add Authentication
    try {
        CreateWalletRequest createWalletRequest = new CreateWalletRequest();
        createWalletRequest.setPassword(Password);
        String username = authentication.getName(); // Extract username
        createWalletRequest.setUsername(username); // Set username in the request
        return ResponseEntity.ok(createWalletService.createWallet(createWalletRequest));
    } catch (Exception e) {
        return ResponseEntity.status(400).body(e.getMessage());
    }
}
}
