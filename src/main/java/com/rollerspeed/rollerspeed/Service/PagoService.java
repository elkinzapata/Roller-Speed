package com.rollerspeed.rollerspeed.Service;



import com.rollerspeed.rollerspeed.Model.Pago;
import com.rollerspeed.rollerspeed.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    public Pago savePago(Pago pago) {
        return pagoRepository.save(pago);
    }

    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    public Optional<Pago> getPagoById(Long id) {
        return pagoRepository.findById(id);
    }

    public void deletePago(Long id) {
        pagoRepository.deleteById(id);
    }

    // Otros métodos de servicio...
}