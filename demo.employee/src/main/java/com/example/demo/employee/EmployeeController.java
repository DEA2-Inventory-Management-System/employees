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
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable("id") int id) {
        return empService.deleteEmployeeById(id);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") int id, @RequestBody EmployeeDto employeeDto)
    {
        return empService.updateId( id,   employeeDto);
    }
    private EmployeeDto getEmpRec(int id) {
        Optional<EmployeeDto> empObj = EmployeeRepository.findById(id);
        if (empObj.isPresent()) {
            return empObj.get();
        }
        return null;
    }
}
