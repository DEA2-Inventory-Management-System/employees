package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
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


    @DeleteMapping("/employee/{empid}")
    private ResponseEntity<Object> deleteEmployee(@PathVariable("empid") int empid) {
        return employeeService.deleteEmployeeById(empid);
    }
    @PutMapping("/employee/{empid}")
    private ResponseEntity<Employee> updateEmployee(@PathVariable int empid, @RequestBody Employee employee)
    {
        return employeeService.updateId( empid, employee);
    }
    private Employee getEmpRec(int empid) {
        Optional<Employee> empObj = EmployeeRepository.findById(empid);
        if (empObj.isPresent()) {
            return empObj.get();
        }
        return null;
    }
}
