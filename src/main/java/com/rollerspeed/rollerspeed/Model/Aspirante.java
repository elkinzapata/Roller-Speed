package com.rollerspeed.rollerspeed.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "aspirantes")
public class Aspirante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String nombre;

    @Column(name = "Fecha de Nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "Genero", nullable = false)
    private String genero;

    @Column(name = "Correo", nullable = false, unique = true)
    private String correo;

    @Column(name = "Telefono", nullable = false)
    private String telefono;

    @Column(name = "Metodo de pago", nullable = false)
    private String metodoPago;

    // Getters y setters
}