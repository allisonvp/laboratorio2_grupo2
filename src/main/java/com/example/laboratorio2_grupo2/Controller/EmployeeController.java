package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import com.example.laboratorio2_grupo2.Entity.EmployeeEntity;
import com.example.laboratorio2_grupo2.Repository.DepartmentRepository;
import com.example.laboratorio2_grupo2.Repository.EmployeeRepository;
import com.example.laboratorio2_grupo2.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    JobRepository jobRepository;

    @GetMapping("/lista")
    public String listarEmployees(Model model) {
        List<EmployeeEntity> listaEmpleados = employeeRepository.findAll();
        List<DepartmentEntity> listaDepartamentos = departmentRepository.findAll();
        model.addAttribute("lista", listaEmpleados);
        return "employee/lista";
    }





}
