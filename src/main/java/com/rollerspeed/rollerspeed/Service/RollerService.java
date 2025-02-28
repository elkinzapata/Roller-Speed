package com.rollerspeed.rollerspeed.Service;

// RollerService.java

import com.rollerspeed.rollerspeed.Model.Roller;
import com.rollerspeed.rollerspeed.Repository.RollerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RollerService {
    private final com.rollerspeed.rollerspeed.Repository.RollerRepository RollerRepository;

    public RollerService(RollerRepository RollerRepository) {
        this.RollerRepository = RollerRepository;
    }

    public List<Roller> findAll() {
        return RollerRepository.findAll();
    }

    public Roller save (Roller roller){
        return RollerRepository.save(roller);
    }
}