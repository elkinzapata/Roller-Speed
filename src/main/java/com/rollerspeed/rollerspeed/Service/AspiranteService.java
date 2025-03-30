package com.rollerspeed.rollerspeed.Service; 

import com.rollerspeed.rollerspeed.Model.Aspirante;
import com.rollerspeed.rollerspeed.Repository.AspiranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AspiranteService {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    public Aspirante saveAspirante(Aspirante aspirante) {
        return aspiranteRepository.save(aspirante);
    }

    public List<Aspirante> getAllAspirantes() {
        return aspiranteRepository.findAll();
    }

    public Optional<Aspirante> getAspiranteById(Long id) {
        return aspiranteRepository.findById(id);
    }

    public void deleteAspirante(Long id) {
        aspiranteRepository.deleteById(id);
    }

    // Otros métodos de servicio...
}