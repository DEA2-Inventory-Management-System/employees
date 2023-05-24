package com.example.demo.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public void saveRequest(EmployeeDto employeeDto) {
    }

    
    public List<EmployeeDto> getAllEmployeeRequests() {
    }

    public ResponseEntity<Object> deleteAllEmployee() {
        try {
            employeeRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Object> deleteEmployeeById(int id) {
    }

    public ResponseEntity<EmployeeDto> updateId(int id, EmployeeDto employeeDto) {
        //check if employee exist in database
        EmployeeRepository poObj = getEmpRec(empid);

        if (poObj != null) {
            poObj.setempid(EmployeeDto.getempid());
            poObj.setname(EmployeeDto.getname());
            poObj.setaddress(EmployeeDto.getaddress());
            poObj.setphone(EmployeeDto.getphone());
            poObj.setage(EmployeeDto.getage());
            poObj.setdob(EmployeeDto.getdob());
            poObj.setnic(EmployeeDto.getnic());
            return new ResponseEntity<>(EmployeeRepository.save(poObj), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
