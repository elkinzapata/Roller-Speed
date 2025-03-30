package com.rollerspeed.rollerspeed.Service;


import com.rollerspeed.rollerspeed.Model.Alumno;
import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.Repository.AlumnoRepository;
import com.rollerspeed.rollerspeed.Repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }

    public Optional<Alumno> getAlumnoById(Long id) {
        return alumnoRepository.findById(id);
    }

    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno updateAlumno(Long id, Alumno alumno) {
        alumno.setId(id);
        return alumnoRepository.save(alumno);
    }

@Autowired
    private ClaseRepository claseRepository;

    public List<Clase> getClasesByAlumnoId(Long alumnoId) {
        Optional<Alumno> alumnoOptional = alumnoRepository.findById(alumnoId);
        if (alumnoOptional.isPresent()) {
            Alumno alumno = alumnoOptional.get();
            // Obtener todas las clases y filtrar las que tienen al alumno
            return claseRepository.findAll().stream()
                .filter(clase -> clase.getAlumnos().contains(alumno))
                .collect(Collectors.toList());
        } else {
            return null; // O lanza una excepción si el alumno no existe
        }
    }   

    // Otros métodos de servicio...
}