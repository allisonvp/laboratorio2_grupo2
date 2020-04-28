package com.example.laboratorio2_grupo2.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "employees")
public class EmployeeEntity {

    @Id
    @Column(name = "employee_id")
    private String employee_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "hire_date")
    private Date hire_date;
    @Column(name = "job_id")
    private String job_id;
    @Column(name = "salary")
    private int salary;
    @Column(name = "commission_pct")
    private int commision_pct;
    @Column(name = "manager_id")
    private String managet_id;
    @Column(name = "department_id")
    private int department_id;


}
