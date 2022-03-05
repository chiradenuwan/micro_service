package com.chiradenuwan.department.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private int id;
    private String name;
    private String address;
    private String code;

    public DepartmentDto(String name, String address, String code) {
        this.name = name;
        this.address = address;
        this.code = code;
    }
}
