package com.Walk2Wealth.Walk2Wealth_Backend.users.service.outsideUser;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.response.UserRequestResponse;
import com.Walk2Wealth.Walk2Wealth_Backend.users.model.User;
import com.Walk2Wealth.Walk2Wealth_Backend.users.repository.UserRepository;
import com.Walk2Wealth.Walk2Wealth_Backend.users.service.Mapper.FindByUsernameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FindByUserNameServiceImpl implements FindByUserNameService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRequestResponse findByUserName(String username) {
        User user = userRepository.findByUserName(username);
        if (user == null) throw new IllegalArgumentException("User not found");

        FindByUsernameMapper findByUsernameMapper = new FindByUsernameMapper();
        return findByUsernameMapper.userMapper(user);

    }
}