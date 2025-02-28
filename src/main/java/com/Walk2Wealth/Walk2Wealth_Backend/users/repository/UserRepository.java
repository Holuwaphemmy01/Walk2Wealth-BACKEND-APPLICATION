package com.Walk2Wealth.Walk2Wealth_Backend.users.repository;

import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUserName(String username);

    User findByEmail(String email);

    User findByPhoneNumber(String phoneNumber);
}
