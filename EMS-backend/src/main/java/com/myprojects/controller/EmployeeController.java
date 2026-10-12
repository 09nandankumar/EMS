package com.myprojects.controller;

import com.myprojects.dto.EmployeeDto;
import com.myprojects.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController
{

    private EmployeeService employeeService;

    // add emp
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee =  employeeService.createEmployee(employeeDto);
        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

// get by id
    @GetMapping("{id}")
    public  ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeid){
        EmployeeDto employeeDto= employeeService.getEmployeeId(employeeid);
        return ResponseEntity.ok(employeeDto);
    }

    //get all employee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployee(Long employee){
        List<EmployeeDto> employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //update emp
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployees(@PathVariable("id") Long employeeId,
                                                                       @RequestBody EmployeeDto updateEmployee){
       EmployeeDto employeeDto= employeeService.updateEmployee(employeeId,updateEmployee);
       return  ResponseEntity.ok(employeeDto);
    }

    //delete emp by id
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted Successfully !");
    }
}
