package com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.createWallet;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.response.UserRequestResponse;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.outsideUser.FindByUserNameServiceImpl;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.dtos.request.CreateWalletRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.model.Wallet;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.repository.WalletRepository;
import com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.encryptAndDecrypt.EncryptionAndDecryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.Keys;

import java.math.BigDecimal;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Service
public class CreateWalletServiceImpl implements CreateWalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Autowired
    private FindByUserNameServiceImpl findByUserNameService;


    @Override
    public String createWallet(CreateWalletRequest createWalletRequest) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {



        Credentials credentials = Credentials.create(Keys.createEcKeyPair());
        Wallet wallet = new Wallet();
        User user = new User();
        wallet.setId();

        UserRequestResponse userRequestResponse = findByUserNameService.findByUserName(createWalletRequest.getUsername());
        user.setUserName(userRequestResponse.getUserName());
        wallet.setUser(user);
        wallet.setPassword(hashPassword.hash(createWalletRequest.getWalletPin()));
        String encrypted = EncryptionAndDecryption.encryptPrivateKey(credentials.getEcKeyPair().getPrivateKey().toString(),
                wallet.getPassword());
        wallet.setPrivateKey(encrypted);
        wallet.setAddress(credentials.getAddress());
        wallet.setCreatedAt();
        wallet.setUpdatedAt();
        wallet.setCurrency();
        wallet.setBalance(BigDecimal.ZERO);
        Wallet saveWallet = walletRepository.save(wallet);
        return saveWallet.getAddress();
        return "";
    }
}
