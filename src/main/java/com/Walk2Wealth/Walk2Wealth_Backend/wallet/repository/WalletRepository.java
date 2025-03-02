package com.Walk2Wealth.Walk2Wealth_Backend.wallet.repository;

import com.Walk2Wealth.Walk2Wealth_Backend.wallet.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WalletRepository extends JpaRepository<Wallet, UUID> {


}
