package com.rollerspeed.rollerspeed.Repository;

import com.rollerspeed.rollerspeed.Model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
}