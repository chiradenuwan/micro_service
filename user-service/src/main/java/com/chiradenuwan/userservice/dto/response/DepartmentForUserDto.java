package com.chiradenuwan.userservice.dto.response;

import com.chiradenuwan.userservice.dto.UserDto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentForUserDto {

    private UserDto user;
    private DepartmentDto departmentDto;
}
