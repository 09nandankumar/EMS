package com.myprojects.service;

import com.myprojects.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    //post emp
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    //get emp by id
    EmployeeDto getEmployeeId(Long employeeID);

    //get all emp
    List<EmployeeDto> getAllEmployees();

    //update emp
    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee);

    void deleteEmployee(Long employeeId);
}
