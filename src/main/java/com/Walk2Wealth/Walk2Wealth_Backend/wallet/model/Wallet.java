package com.Walk2Wealth.Walk2Wealth_Backend.wallet.model;


import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "wallet")
public class Wallet {
    @Id
    @Column(nullable = false, unique = true, name = "walletId")
    private UUID id;
    @Column(nullable = false, unique = true, updatable = false, name = "address")
    private String address;
    @Column(nullable = false, unique = true, name = "balance")
    private BigDecimal balance;
    @Column(nullable = false, name = "createdAt")
    private Date createdAt;
    @Column(nullable = false, name = "updatedAt")
    private Date updatedAt;

    private String password;
    @OneToOne
    @JoinColumn(name = "userName")
    private User user;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId() {
        this.id = UUID.randomUUID();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
