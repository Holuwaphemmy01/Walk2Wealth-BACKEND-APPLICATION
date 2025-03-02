package com.Walk2Wealth.Walk2Wealth_Backend.wallet.service.createWallet;

import com.Walk2Wealth.Walk2Wealth_Backend.wallet.dtos.request.CreateWalletRequest;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public interface CreateWalletService {
    String createWallet(CreateWalletRequest createWalletRequest) throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException;
}
