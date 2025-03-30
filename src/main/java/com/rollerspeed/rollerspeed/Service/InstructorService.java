package com.rollerspeed.rollerspeed.Service;


import com.rollerspeed.rollerspeed.Model.Instructor;
import com.rollerspeed.rollerspeed.Repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public Instructor saveInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public List<Instructor> getAllInstructors() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getInstructorById(Long id) {
        return instructorRepository.findById(id);
    }

    public void deleteInstructor(Long id) {
        instructorRepository.deleteById(id);
    }

    // Otros métodos de servicio...
}