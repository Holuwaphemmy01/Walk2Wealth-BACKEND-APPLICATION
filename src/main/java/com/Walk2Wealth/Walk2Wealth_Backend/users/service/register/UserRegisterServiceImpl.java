package com.Walk2Wealth.Walk2Wealth_Backend.users.service.register;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.repository.UserRepository;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.regex.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Email email;

    @Override
    public String registerUser(UserRegisterRequest user) {
        if(user.getFirstName().isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        if(user.getLastName().isEmpty()) throw new IllegalArgumentException("Last name cannot be empty");
        if(!Email.validateEmail(user.getEmail())) throw new IllegalArgumentException("Invalid email");

        return "";
    }
}
