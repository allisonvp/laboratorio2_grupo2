package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import com.example.laboratorio2_grupo2.Entity.EmployeeEntity;
import com.example.laboratorio2_grupo2.Entity.JobEntity;
import com.example.laboratorio2_grupo2.Repository.DepartmentRepository;
import com.example.laboratorio2_grupo2.Repository.EmployeeRepository;
import com.example.laboratorio2_grupo2.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class    EmployeeController {

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

        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employee/lista";
    }

    @GetMapping("/editar")
    public String editarEmployee(@RequestParam("id") String id,
                                 @RequestParam(name = "hire_date", required = false) String fechaContrato,
                                 Model model) {
        Optional<EmployeeEntity> opt = employeeRepository.findById(id);
        if (opt.isPresent()) {
            EmployeeEntity employeeEditar = opt.get();

            model.addAttribute("employeeEditar", employeeEditar);
            try {
                employeeEditar.setHire_date(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(fechaContrato));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            
            return "employee/editar";
        } else {
            return "redirect:/employee";
        }

    }
    @GetMapping("/borrar")
    public String borrarEmployee(@RequestParam("id") String id) {
        Optional<JobEntity> opt = jobRepository.findById(id);
        if (opt.isPresent()) {
            jobRepository.deleteById(id);
        }
        return "redirect:/job";


    }




}
