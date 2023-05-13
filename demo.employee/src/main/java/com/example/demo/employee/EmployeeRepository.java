package com.example.demo.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<EmployeeDto,Integer> {

    static Optional<EmployeeDto> findById(int id);
}
