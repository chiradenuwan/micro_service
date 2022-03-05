package com.chiradenuwan.userservice.service.custom;

import com.chiradenuwan.userservice.dto.UserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    UserDto findUser(int userId);
}
