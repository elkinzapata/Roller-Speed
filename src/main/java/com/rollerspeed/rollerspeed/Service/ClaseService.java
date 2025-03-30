package com.rollerspeed.rollerspeed.Service;


import com.rollerspeed.rollerspeed.Model.Clase;
import com.rollerspeed.rollerspeed.Repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaseService {

    @Autowired
    private ClaseRepository claseRepository;

    public Clase saveClase(Clase clase) {
        return claseRepository.save(clase);
    }

    public List<Clase> getAllClases() {
        return claseRepository.findAll();
    }

    public Optional<Clase> getClaseById(Long id) {
        return claseRepository.findById(id);
    }

    public void deleteClase(Long id) {
        claseRepository.deleteById(id);
    }

    // Otros métodos de servicio...
}