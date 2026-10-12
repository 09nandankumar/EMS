package com.myprojects.service.impl;

import com.myprojects.dto.EmployeeDto;
import com.myprojects.entity.Employee;
import com.myprojects.exception.ResourceNotFoundException;
import com.myprojects.mapper.EmployeeMapper;
import com.myprojects.repostiory.EmployeeRepository;
import com.myprojects.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        if (employeeDto.getId() == null) {
            employeeDto.setId(0L); // or skip mapping id
        }
//        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeId(Long employeeID) {
        Employee employee = employeeRepository.findById(employeeID).orElseThrow(() ->
                new ResourceNotFoundException("Employee is not exists with given ID : "+employeeID));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
      List<Employee> employees=  employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
      Employee employee=  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee id is not exist with given id:"+employeeId));

        employee.setFirstname(updateEmployee.getFirstName());
        employee.setLastname(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());

        Employee updateEmployeeObj= employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=  employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee id is not exist with given id:"+employeeId));//copy in update

        employeeRepository.deleteById(employeeId);
    }

}
