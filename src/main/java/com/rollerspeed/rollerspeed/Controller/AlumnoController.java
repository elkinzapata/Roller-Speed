package com.rollerspeed.rollerspeed.Controller;

import com.rollerspeed.rollerspeed.Model.Alumno;
import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.Service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/alumno")
@Tag(name = "Alumno", description = "Operaciones relacionadas con alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/horarios/{id}")
    public String mostrarHorarios(@PathVariable Long id, Model model) {
        List<Clase> clases = alumnoService.getClasesByAlumnoId(id);
        model.addAttribute("clases", clases);
        return "alumno/horarios";
    }

    @GetMapping("/perfil/{id}")
    public String mostrarPerfil(@PathVariable Long id, Model model) {
        Alumno alumno = alumnoService.getAlumnoById(id).orElse(null);
        model.addAttribute("alumno", alumno);
        return "alumno/perfil";
    }

    @PostMapping("/perfil/{id}")
    public String actualizarPerfil(@PathVariable Long id, Alumno alumno) {
        alumnoService.updateAlumno(id, alumno);
        return "redirect:/alumno/perfil/" + id;
    }

    @GetMapping("/pagos/{id}")
    public String mostrarPagos(@PathVariable Long id, Model model) {
        return "alumno/pagos";
    }

    @GetMapping("/api/perfil/{id}")
    @Operation(summary = "Obtener perfil de un alumno", description = "Devuelve los detalles del perfil de un alumno por ID")
    public ResponseEntity<Alumno> obtenerPerfilApi(@PathVariable Long id) {
        return alumnoService.getAlumnoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
@GetMapping("/test-db")
public ResponseEntity<String> testDatabaseConnection() {
    try {
        alumnoService.getAllAlumnos(); // Método que consulta la tabla alumnos
        return ResponseEntity.ok("Conexión a la base de datos exitosa");
    } catch (Exception e) {
        return ResponseEntity.status(500).body("Error en la conexión a la base de datos: " + e.getMessage());
    }
}
}