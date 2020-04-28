package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import com.example.laboratorio2_grupo2.Entity.EmployeeEntity;
import com.example.laboratorio2_grupo2.Repository.DepartmentRepository;
import com.example.laboratorio2_grupo2.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = "/lista")
    public String listaDepartments(Model model) {

        List<DepartmentEntity> listaDepartments = departmentRepository.findAll();
        model.addAttribute("lista", listaDepartments);
        return "department/lista";
    }

    @GetMapping(value = "/nuevo")
    public String nuevoDepartment(Model model) {
        EmployeeRepository employeeRepository = null;
        List<EmployeeEntity> listaemployee = employeeRepository.findAll();
        model.addAttribute("listaemployee",listaemployee);


        return "department/crear";
    }

    @PostMapping(value = "/guardar")
    public String guardarDepartment(DepartmentEntity department, RedirectAttributes attr,, @RequestParam("nombre") String nombre ) {
        department.setDepartmentname(nombre);


////enviar lista de emppleados como atributos a vista
        ////enviar lista de location como atributos a vista
        if (department.getDepartmentid() == 0) {
            List<DepartmentEntity> list = departmentRepository.findAll(Sort.by("departmentid").descending());
            DepartmentEntity ultimoDepartment = list.get(0);
            department.setDepartmentid(ultimoDepartment.getDepartmentid() + 10);
            attr.addFlashAttribute("msg", "Departamento creado exitosamente");
        } else {
            attr.addFlashAttribute("msg", "Departamento " + department.getDepartmentname() + " actualizado exitosamente");
        }
        departmentRepository.save(department);
        return "redirect:/department";
    }

    @PostMapping(value = "buscarDepartamento")
    public String buscarTransportista(@RequestParam("searchField") String searchField,
                                      Model model) {
        List<DepartmentEntity> listaDepartments = departmentRepository.findByDepartmentname(searchField);
        model.addAttribute("lista", listaDepartments);
        model.addAttribute("searchField", searchField);
        return "department/lista";
    }

    @GetMapping("/editar")
    public String editarDepartment(@RequestParam("id") int id,
                                   Model model){
        Optional<DepartmentEntity> opt = departmentRepository.findById(id);
        if(opt.isPresent()){
            DepartmentEntity     departmentEditar = opt.get();
            model.addAttribute("departmentEditar", departmentEditar);
            return "department/editar";
        }else{
            return "redirect:/department";
        }

    }

    @GetMapping("/borrar")
    public String borrarDepartment(@RequestParam("id") int id){
        Optional<DepartmentEntity> opt = departmentRepository.findById(id);
        if (opt.isPresent()){
            departmentRepository.deleteById(id);
        }
        return "redirect:/department";

    }


}
