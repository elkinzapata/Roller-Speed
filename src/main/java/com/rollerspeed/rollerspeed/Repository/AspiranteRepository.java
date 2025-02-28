package com.rollerspeed.rollerspeed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rollerspeed.rollerspeed.Model.Aspirante;

@Repository

public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {}