package com.rollerspeed.rollerspeed.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "instructores")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private User usuario;

    // Getters y setters...
}