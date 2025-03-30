package com.rollerspeed.rollerspeed.Controller;

import com.rollerspeed.rollerspeed.Model.Asistencia;
import com.rollerspeed.rollerspeed.Service.AsistenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asistencia")
public class AsistenciaController {

    @Autowired
    private AsistenciaService asistenciaService;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("asistencia", new Asistencia());
        return "asistencia/registro";
    }

    @PostMapping("/registro")
    public String registrarAsistencia(Asistencia asistencia) {
        asistenciaService.saveAsistencia(asistencia);
        return "redirect:/asistencia/reportes";
    }

    @GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        model.addAttribute("asistencias", asistenciaService.getAllAsistencias());
        return "asistencia/reportes";
    }
}