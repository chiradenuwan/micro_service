package com.chiradenuwan.department.controller;

import com.chiradenuwan.department.dto.DepartmentDto;
import com.chiradenuwan.department.service.custom.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/")
    private ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        log.info("Department Save -> Call");
        DepartmentDto departmentDto1 = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(departmentDto1, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<DepartmentDto> findDepartment(@PathVariable("id") int departmentId) {
        log.info("Get Department by Id -> Call");
        DepartmentDto departmentDto1 = departmentService.findDepartment(departmentId);
        return new ResponseEntity<>(departmentDto1, HttpStatus.ACCEPTED);
    }
}
