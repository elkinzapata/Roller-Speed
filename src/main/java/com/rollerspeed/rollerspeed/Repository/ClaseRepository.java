package com.rollerspeed.rollerspeed.Repository;


import com.rollerspeed.rollerspeed.Model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase, Long> {
}