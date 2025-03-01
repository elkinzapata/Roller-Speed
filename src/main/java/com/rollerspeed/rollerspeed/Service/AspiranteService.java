package com.rollerspeed.rollerspeed.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rollerspeed.rollerspeed.Model.Aspirante;
import com.rollerspeed.rollerspeed.Repository.AspiranteRepository;

@Service
public class AspiranteService {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    public void guardarAspirante(Aspirante aspirante) {
        aspiranteRepository.save(aspirante);
    }
}