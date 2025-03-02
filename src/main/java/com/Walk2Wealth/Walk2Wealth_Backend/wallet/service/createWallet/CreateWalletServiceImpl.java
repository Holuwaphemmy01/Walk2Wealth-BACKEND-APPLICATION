package com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.createWallet;

import com.Walk2Wealth.Walk2Wealth_Backend.regex.Password;
import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.response.UserRequestResponse;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.outsideUser.FindByUserNameServiceImpl;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.dtos.request.CreateWalletRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.model.Wallet;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.repository.WalletRepository;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.encryptAndDecrypt.EncryptionAndDecryption;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.hashPassword.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Service
public class CreateWalletServiceImpl implements CreateWalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private FindByUserNameServiceImpl findByUserNameService;

    @Autowired
    private HashPassword hashPassword;


    @Override
    public String createWallet(CreateWalletRequest createWalletRequest) throws Exception {

        if(createWalletRequest.getUsername().isEmpty() || createWalletRequest.getUsername().isBlank())
            throw new IllegalArgumentException("Username cannot be empty");
        if(createWalletRequest.getPassword().isEmpty() || createWalletRequest.getPassword().isBlank())
            throw new IllegalArgumentException("Password cannot be empty");
        if(createWalletRequest.getPassword().strip().length() < 8 )
            throw new IllegalArgumentException("Wallet Password should be at least 8 character.");
        if(!Password.isValidPassword(createWalletRequest.getPassword()))
            throw new IllegalArgumentException("Password is invalid");




        Credentials credentials = Credentials.create(Keys.createEcKeyPair());
        Wallet wallet = new Wallet();
        User user = new User();
        wallet.setId();
        UserRequestResponse userRequestResponse = findByUserNameService.findByUserName(createWalletRequest.getUsername());
        user.setUserName(userRequestResponse.getUserName());
        wallet.setUser(user);
        wallet.setPassword(hashPassword.hash(createWalletRequest.getPassword()));
        String encrypted = EncryptionAndDecryption.encryptPrivateKey(credentials.getEcKeyPair().getPrivateKey().toString(),
                wallet.getPassword());
        wallet.setPrivateKey(encrypted);
        wallet.setAddress(credentials.getAddress());
        wallet.setCreatedAt(Date.from(Instant.now()));
        wallet.setUpdatedAt(Date.from(Instant.now()));
        wallet.setBalance(BigDecimal.ZERO);
        Wallet saveWallet = walletRepository.save(wallet);
        return saveWallet.getAddress();

    }
}
