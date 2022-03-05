package com.chiradenuwan.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String address;
    private int department;

    public UserDto(String name, String address, int department) {
        this.name = name;
        this.address = address;
        this.department = department;
    }
}
