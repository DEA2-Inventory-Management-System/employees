package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3006")
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    private Employee saveRequest(@RequestBody Employee employee)
    {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @GetMapping("/employee")
    private List<Employee> getEmployee()
    {
        return employeeService.getEmployee();
    }


    @DeleteMapping("/employee/{id}")
    private ResponseEntity<Object> deleteEmployee(@PathVariable("id") int id)
    {
        return employeeService.deleteByEmployeeId(id);
    }

    @PutMapping("/employee/{id}")
    private ResponseEntity<Object> updateEmployee(@PathVariable int id, @RequestBody Employee employee)
    {
        return employeeService.updateEmployee(id, employee);


    }

}
