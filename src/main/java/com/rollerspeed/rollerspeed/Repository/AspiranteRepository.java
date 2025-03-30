package com.rollerspeed.rollerspeed.Repository;

import com.rollerspeed.rollerspeed.Model.Aspirante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {
}