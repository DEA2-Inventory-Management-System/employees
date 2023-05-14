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
    EmployeeService empService;

    @PostMapping("/employee")
    private EmployeeDto saveRequest(@RequestBody EmployeeDto employeeDto)
    {
        empService.saveRequest(employeeDto);
        return employeeDto;
    }

    @GetMapping("/employee")
    private List<EmployeeDto> getAllEmployeeRequests()
    {
        return empService.getAllEmployeeRequests();
    }

    @DeleteMapping("/employee")
    private ResponseEntity<Object> deleteAllEmployee()
    {
        return empService.deleteAllEmployee();
    }
    @DeleteMapping("/employee/{empid}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable("empid") int empid) {
        return empService.deleteEmployeeById(empid);
    }
    @PutMapping("/employee/{empid}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("empid") int empid, @RequestBody EmployeeDto employeeDto)
    {
        return empService.updateId( empid,   employeeDto);
    }
    private EmployeeDto getEmpRec(int empid) {
        Optional<EmployeeDto> empObj = EmployeeRepository.findById(empid);
        if (empObj.isPresent()) {
            return empObj.get();
        }
        return null;
    }
}
