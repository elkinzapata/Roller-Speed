package com.rollerspeed.rollerspeed.Controller;

import com.rollerspeed.rollerspeed.Model.Alumno;
import com.rollerspeed.rollerspeed.Service.AlumnoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alumno")
@Tag(name = "Alumno API", description = "Operaciones API relacionadas con alumnos")
public class AlumnoApiController {

    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/perfil/{id}")
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