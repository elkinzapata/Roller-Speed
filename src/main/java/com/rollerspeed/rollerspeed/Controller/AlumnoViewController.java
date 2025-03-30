package com.rollerspeed.rollerspeed.Controller;


import com.rollerspeed.rollerspeed.Model.Alumno;
import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.Service.AlumnoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/alumno-view")
public class AlumnoViewController {

    private final AlumnoService alumnoService;

    public AlumnoViewController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/horarios/{id}")
    public String mostrarHorarios(@PathVariable Long id, Model model) {
        List<Clase> clases = alumnoService.getClasesByAlumnoId(id);
        model.addAttribute("clases", clases);
        return "alumno/horarios";
    }

    @GetMapping("/perfil/{id}")
    public String mostrarPerfil(@PathVariable Long id, Model model) {
        Alumno alumno = alumnoService.getAlumnoById(id).orElse(null);
        if (alumno == null) {
            model.addAttribute("error", "Alumno no encontrado");
        }
        model.addAttribute("alumno", alumno);
        return "alumno/perfil";
    }

    @PostMapping("/perfil/{id}")
    public String actualizarPerfil(@PathVariable Long id, Alumno alumno, RedirectAttributes redirectAttributes) {
        alumnoService.updateAlumno(id, alumno);
        redirectAttributes.addFlashAttribute("mensaje", "Perfil actualizado con éxito");
        return "redirect:/alumno/perfil/" + id;
    }

    @GetMapping("/pagos/{id}")
    public String mostrarPagos(@PathVariable Long id, Model model) {
        // Lógica para obtener y mostrar pagos
        // model.addAttribute("pagos", pagos);
        return "alumno/pagos";
    }
}