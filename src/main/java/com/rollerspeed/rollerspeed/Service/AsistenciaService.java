package com.rollerspeed.rollerspeed.Service;


import com.rollerspeed.rollerspeed.Model.Asistencia;
import com.rollerspeed.rollerspeed.Repository.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaService {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    public Asistencia saveAsistencia(Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }

    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    public Optional<Asistencia> getAsistenciaById(Long id) {
        return asistenciaRepository.findById(id);
    }

    public void deleteAsistencia(Long id) {
        asistenciaRepository.deleteById(id);
    }

    // Otros métodos de servicio...
}