package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import com.example.laboratorio2_grupo2.Repository.DepartmentRepository;
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
@RequestMapping(value="/department")
public class DepartmentController {

    @Autowired
    DepartmentRepository departmentRepository;

    @GetMapping(value = "/lista")
    public String listaDepartments(Model model){

        List<DepartmentEntity> listaDepartments = departmentRepository.findAll();
        model.addAttribute("lista", listaDepartments);
        return "department/lista";
    }

    @PostMapping(value = "buscarDepartamento")
    public String buscarTransportista(@RequestParam("searchField") String searchField,
                                      Model model){
        List<DepartmentEntity> listaDepartments = departmentRepository.findByDepartmentname(searchField);
        model.addAttribute("lista", listaDepartments);
        model.addAttribute("searchField",searchField);
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
