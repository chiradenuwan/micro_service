package com.chiradenuwan.userservice.service.custom.impl;

import com.chiradenuwan.userservice.dto.UserDto;
import com.chiradenuwan.userservice.entity.User;
import com.chiradenuwan.userservice.repository.UserRepository;
import com.chiradenuwan.userservice.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        User user = new User(
                userDto.getName(),
                userDto.getAddress(),
                userDto.getDepartment()
        );
        User savedDepartment = userRepository.save(user);
        return setUserResponse(savedDepartment);
    }

    @Override
    public UserDto findUser(int userId) {
        Optional<User> department =
                userRepository.findById(userId);
        return department.map(this::setUserResponse).orElse(null);
    }


    private UserDto setUserResponse(User department) {
        return new UserDto(
                department.getId(),
                department.getName(),
                department.getAddress(),
                department.getDepartment()
        );
    }
}
