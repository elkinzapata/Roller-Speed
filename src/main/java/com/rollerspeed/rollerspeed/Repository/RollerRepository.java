package com.rollerspeed.rollerspeed.Repository;

// FlorRepository.java

import com.rollerspeed.rollerspeed.Model.Roller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RollerRepository extends JpaRepository<Roller, Long> {
}
