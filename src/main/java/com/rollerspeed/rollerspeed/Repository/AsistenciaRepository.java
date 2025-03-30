package com.rollerspeed.rollerspeed.Repository;



import com.rollerspeed.rollerspeed.Model.Asistencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsistenciaRepository extends JpaRepository<Asistencia, Long> {
}