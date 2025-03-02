package com.Walk2Wealth.Walk2Wealth_Backend.users.service.outsideUser;

import com.Walk2Wealth.Walk2Wealth_Backend.users.dtos.response.UserRequestResponse;

public interface FindByUserNameService {

    UserRequestResponse findByUserName(String username);
}
