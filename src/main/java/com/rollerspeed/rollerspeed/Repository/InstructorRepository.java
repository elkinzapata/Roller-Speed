package com.rollerspeed.rollerspeed.Repository;


import com.rollerspeed.rollerspeed.Model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}