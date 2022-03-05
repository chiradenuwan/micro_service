package com.chiradenuwan.department.service.custom;

import com.chiradenuwan.department.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto findDepartment(int departmentId);
}
