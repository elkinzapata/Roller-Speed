package com.rollerspeed.rollerspeed.Repository;

import com.rollerspeed.rollerspeed.Model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
}