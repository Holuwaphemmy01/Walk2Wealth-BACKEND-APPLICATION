package com.Walk2Wealth.Walk2Wealth_Backend.users.repository;

import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);
}
