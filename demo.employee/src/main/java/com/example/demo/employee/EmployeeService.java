package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }


    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }

    public ResponseEntity<Object> deleteByEmployeeId(int empid) {
        try {
            //check if employee exist in database
            Optional<Employee> employee = employeeRepository.findAllById(empid);
            if (employee != null)
                employeeRepository.deleteById(empid);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    } catch(
    Exception e)

    {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

}


    public ResponseEntity<Object> updateEmployee(int empid, Employee employee) {
        Optional<Employee> employeeObj = employeeRepository.findById(empid);
        Employee newEmployee = employeeObj.get();

        if (employeeObj != null) {
            newEmployee.setName(employee.getName());
            newEmployee.setAddress(employee.getAddress());
            newEmployee.setPhone(employee.getPhone());
            newEmployee.setAge(employee.getAge());
            newEmployee.setDOB(employee.getDOB());
            newEmployee.setNic(employee.getNic());
            return new ResponseEntity<>(EmployeeRepository.save(newEmployee), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
