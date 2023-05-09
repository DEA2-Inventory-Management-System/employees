package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService empService;

    @PostMapping("/employee")
    private EmployeeDto saveRequest(@RequestBody EmployeeDto employeeDto)
    {
        empService.saveRequest(employeeDto);
        return employeeDto;
    }
}
