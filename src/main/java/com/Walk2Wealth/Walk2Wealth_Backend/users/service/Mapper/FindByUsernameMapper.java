package com.Walk2Wealth.Walk2Wealth_Backend.users.service.Mapper;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.response.UserRequestResponse;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import org.springframework.stereotype.Service;

@Service
public class FindByUsernameMapper {

    public UserRequestResponse userMapper(User user) {
        UserRequestResponse userResponse = new UserRequestResponse();
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setUserName(user.getUserName());
        userResponse.setPhoneNumber((user.getPhoneNumber()));
        return userResponse;

    }
}
