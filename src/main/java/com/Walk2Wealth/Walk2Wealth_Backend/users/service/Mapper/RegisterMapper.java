package com.Walk2Wealth.Walk2Wealth_Backend.users.service.Mapper;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterMapper {

    public User registerMapper(UserRegisterRequest userRegisterRequest) {
        User user = new User();
        user.setFirstName(userRegisterRequest.getFirstName().strip());
        user.setLastName(userRegisterRequest.getLastName().strip());
        user.setEmail(userRegisterRequest.getEmail().strip());
        user.setPassword(userRegisterRequest.getPassword().strip());
        user.setUserName(userRegisterRequest.getUserName().strip());
        user.setPhoneNumber(userRegisterRequest.getPhoneNumber().strip());
        return user;
    }
}
