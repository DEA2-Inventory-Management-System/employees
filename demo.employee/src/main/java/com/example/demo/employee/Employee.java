package com.example.demo.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Employee {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empid;

    @Column
    private String name;

    @Column
    private int age;

    @Column
    private String address;

    @Column
    private String phone;

    @Column
    private String nic;

   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-mm-yyyy")
    private LocalDate DOB;

}
