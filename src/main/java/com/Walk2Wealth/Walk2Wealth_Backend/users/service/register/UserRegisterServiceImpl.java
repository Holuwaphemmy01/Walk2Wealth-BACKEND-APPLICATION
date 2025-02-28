package com.Walk2Wealth.Walk2Wealth_Backend.users.service.register;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import com.Walk2Wealth.Walk2Wealth_Backend.users.repository.UserRepository;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.Mapper.RegisterMapper;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.regex.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Email email;
    @Autowired
    private Password password;

    @Autowired
    RegisterMapper registerMapper;

    @Override
    public String registerUser(UserRegisterRequest user) {
        if(user.getFirstName().isEmpty()) throw new IllegalArgumentException("First name cannot be empty");
        if(user.getLastName().isEmpty()) throw new IllegalArgumentException("Last name cannot be empty");
        if(!Email.validateEmail(user.getEmail())) throw new IllegalArgumentException("Invalid email");
        if(user.getPassword().isEmpty()) throw new IllegalArgumentException("Password cannot be empty");
        if(!Password.isValidPassword(user.getPassword())) throw new IllegalArgumentException("Invalid password");
//        if(!Gender.isValidGender(user.getGender())) throw new IllegalArgumentException("Invalid gender");
        if(!Username.isValidUsername(user.getUserName())) throw new IllegalArgumentException("Invalid username");
        if(!PhoneNumber.isValidPhoneNumber(user.getPhoneNumber())) throw new IllegalArgumentException("Invalid phone number");


        User oldUsername = userRepository.findByUserName(user.getUserName());
        if(oldUsername != null) throw new IllegalArgumentException("Username already exists");
        User oldEmail = userRepository.findByEmail(user.getEmail());
        if(oldEmail != null) throw new IllegalArgumentException("Email already exists");
        User oldPhoneNumber = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(oldPhoneNumber != null) throw new IllegalArgumentException("Phone number already exists");

        User newUser = registerMapper.registerMapper(user);
        User registerUser = userRepository.save(newUser);
        if(registerUser == null) throw new IllegalArgumentException("User already exists");
        System.out.println(userRepository.findAll().size());
        return "Registration successful";
    }
}
