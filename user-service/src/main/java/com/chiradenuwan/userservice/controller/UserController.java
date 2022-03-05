package com.chiradenuwan.userservice.controller;

import com.chiradenuwan.userservice.dto.UserDto;
import com.chiradenuwan.userservice.dto.response.DepartmentForUserDto;
import com.chiradenuwan.userservice.service.custom.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    private ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
        try {
            log.info("User Save -> Call");
            UserDto user = userService.saveUser(userDto);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DepartmentForUserDto> findUserAndDepartmentByUserId(@PathVariable("id") int userId) {
        try {
            log.info("Get User by Id -> Call");
            DepartmentForUserDto user = userService.findUserAndDepartmentByUserId(userId);
            return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
