package com.rollerspeed.rollerspeed.Controller;



import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.Service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clase")
public class ClaseController {

    @Autowired
    private ClaseService claseService;

    @GetMapping("/programacion")
    public String mostrarProgramacion(Model model) {
        model.addAttribute("clase", new Clase());
        return "clase/programacion";
    }

    @PostMapping("/programacion")
    public String programarClase(Clase clase) {
        claseService.saveClase(clase);
        return "redirect:/clase/visualizacion";
    }

    @GetMapping("/visualizacion")
    public String mostrarVisualizacion(Model model) {
        model.addAttribute("clases", claseService.getAllClases());
        return "clase/visualizacion";
    }
}