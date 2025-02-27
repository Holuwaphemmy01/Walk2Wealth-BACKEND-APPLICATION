package com.Walk2Wealth.Walk2Wealth_Backend.users.service.register;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.request.UserRegisterRequest;

public interface UserRegisterService {

    String registerUser(UserRegisterRequest user);
}
