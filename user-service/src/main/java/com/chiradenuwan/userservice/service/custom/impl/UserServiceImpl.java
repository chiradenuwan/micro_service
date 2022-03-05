package com.chiradenuwan.userservice.service.custom.impl;

import com.chiradenuwan.userservice.dto.UserDto;
import com.chiradenuwan.userservice.dto.response.DepartmentDto;
import com.chiradenuwan.userservice.dto.response.DepartmentForUserDto;
import com.chiradenuwan.userservice.entity.User;
import com.chiradenuwan.userservice.repository.UserRepository;
import com.chiradenuwan.userservice.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

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
    public DepartmentForUserDto findUserAndDepartmentByUserId(int userId) {
        Optional<User> user =
                userRepository.findById(userId);
        if (user.isPresent()) {
            DepartmentDto departmentDto = restTemplate
                    .getForObject("http://localhost:8080/departments/" + user.get().getDepartment()
                            , DepartmentDto.class);
            return new DepartmentForUserDto(
                    user.get().viewAsDto(),
                    departmentDto
            );
        }
        return null;
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
