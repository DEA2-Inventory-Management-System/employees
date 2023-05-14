package com.example.demo.employee;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class EmployeeDto {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empid;
    private String name;
    private String address;
    private String phone;
    private int age;
    private String dob;
    private String nic;
}
