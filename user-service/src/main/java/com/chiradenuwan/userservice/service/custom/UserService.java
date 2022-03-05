package com.chiradenuwan.userservice.service.custom;

import com.chiradenuwan.userservice.dto.UserDto;
import com.chiradenuwan.userservice.dto.response.DepartmentForUserDto;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    DepartmentForUserDto findUserAndDepartmentByUserId(int userId);
}
