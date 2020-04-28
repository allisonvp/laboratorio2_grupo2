package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import com.example.laboratorio2_grupo2.Entity.EmployeeEntity;
import com.example.laboratorio2_grupo2.Entity.JobEntity;
import com.example.laboratorio2_grupo2.Repository.DepartmentRepository;
import com.example.laboratorio2_grupo2.Repository.EmployeeRepository;
import com.example.laboratorio2_grupo2.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

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
        model.addAttribute("listaDepartamentos", listaDepartamentos);
        model.addAttribute("listaEmpleados", listaEmpleados);
        return "employee/lista";
    }

    @PostMapping(value = "/guardar")
    public String guardarDepartment(EmployeeEntity employee, RedirectAttributes attr, @RequestParam("nombre") String nombre, @RequestParam("jefe")
            String jefe, @RequestParam("ubicacion") String ubicacion, @RequestParam("nombrecorto") String nombrecorto, Model model) {
        employee.setFirst_name(nombre);
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

        if (employee.getEmployee_id() == 0) {
            List<DepartmentEntity> list = departmentRepository.findAll(Sort.by("departmentid").descending());
            DepartmentEntity ultimoDepartment = list.get(0);
            employee.setEmployee_id(ultimoDepartment.getDepartmentid() + 10);
            attr.addFlashAttribute("msg", "Departamento creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Departamento " + employee.getFirst_name() + " actualizado exitosamente");
        }
        employeeRepository.save(employee);
        return "redirect:/department";
    }




}
