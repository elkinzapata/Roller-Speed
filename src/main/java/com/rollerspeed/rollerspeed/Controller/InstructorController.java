package com.rollerspeed.rollerspeed.Controller;

import com.rollerspeed.rollerspeed.Model.Instructor;
import com.rollerspeed.rollerspeed.Service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor/registro";
    }

    @PostMapping("/registro")
    public String registrarInstructor(Instructor instructor) {
        instructorService.saveInstructor(instructor);
        return "redirect:/instructor/registro";
    }

    @GetMapping("/clases/{id}")
    public String mostrarClases(@PathVariable Long id, Model model) {
        // Implementar lógica para obtener clases del instructor
        return "instructor/clases";
    }

    @GetMapping("/instructor/visualizacion")
    public String visualizarInstructores(Model model) {
        return "instructor/visualizacion";
    }

    @GetMapping("/instructor/formulario")
    public String formularioInstructor() {
        return "instructor/formulario";
    }


}