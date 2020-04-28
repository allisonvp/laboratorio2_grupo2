package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.EmployeeEntity;
import com.example.laboratorio2_grupo2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class    EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/lista")
    public String listarEmployees(Model model) {
        List<EmployeeEntity> listaEmpleados = employeeRepository.findAll();
        model.addAttribute("lista", listaEmpleados);
        return "employee/listar";
    }





}
