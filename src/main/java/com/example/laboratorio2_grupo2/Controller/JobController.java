package com.example.laboratorio2_grupo2.Controller;

import com.example.laboratorio2_grupo2.Entity.DepartmentEntity;
import com.example.laboratorio2_grupo2.Entity.JobEntity;
import com.example.laboratorio2_grupo2.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping(value="/job")
public class JobController {

    @Autowired
    JobRepository jobRepository;

    @GetMapping("/editar")
    public String editarJob(@RequestParam("id") String id,
                                   Model model) {
        Optional<JobEntity> opt = jobRepository.findById(id);
        if (opt.isPresent()) {
            JobEntity jobEditar = opt.get();
            model.addAttribute("jobEditar", jobEditar);
            return "job/editar";
        } else {
            return "redirect:/job";
        }

    }
    @GetMapping("/borrar")
    public String borrarJob(@RequestParam("id") String id) {
        Optional<JobEntity> opt = jobRepository.findById(id);
        if (opt.isPresent()) {
            jobRepository.deleteById(id);
        }
        return "redirect:/job";


    }
}
