package com.chiradenuwan.department.service.custom.impl;

import com.chiradenuwan.department.dto.DepartmentDto;
import com.chiradenuwan.department.entity.Department;
import com.chiradenuwan.department.repository.DepartmentRepository;
import com.chiradenuwan.department.service.custom.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = new Department(
                departmentDto.getName(),
                departmentDto.getAddress(),
                departmentDto.getCode()
        );
        Department savedDepartment = departmentRepository.save(department);
        return setDepartmentResponse(savedDepartment);

    }

    @Override
    public DepartmentDto findDepartment(int departmentId) {
        Optional<Department> department =
                departmentRepository.findById(departmentId);
        return department.map(this::setDepartmentResponse).orElse(null);
    }


    private DepartmentDto setDepartmentResponse(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getName(),
                department.getAddress(),
                department.getCode()
        );
    }
}
