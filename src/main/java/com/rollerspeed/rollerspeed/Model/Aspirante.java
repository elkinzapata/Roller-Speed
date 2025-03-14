/* Este código define la clase Aspirante, que representa una tabla en la base de datos llamada "aspirantes". 
   Cada objeto de esta clase es un registro en esa tabla.*/

package com.rollerspeed.rollerspeed.Model; // Indica que esta clase pertenece al paquete com.rollerspeed.rollerspeed.Model. / Organiza las clases dentro del proyecto.

import java.util.Date;

import jakarta.persistence.Column; // Define columnas de la tabla.
import jakarta.persistence.Entity; // Convierte la clase en una tabla de la base de datos.
import jakarta.persistence.GeneratedValue; // Configuran la clave primaria.
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; // Configuran la clave primaria.
import jakarta.persistence.Table; // Define el nombre de la tabla en la base de datos.
import jakarta.persistence.Temporal; // Especifica que un campo representa una fecha.
import jakarta.persistence.TemporalType;
import lombok.Data; // Genera automáticamente los métodos getter y setter, toString(), equals(), etc. 

@Data // Permite que Lombok genere automáticamente los métodos como getters, setters, toString(), etc.
@Entity // Indica que esta clase se almacenará en la base de datos como una tabla.
@Table(name = "aspirantes") // Especifica que la tabla en la base de datos se llamará "aspirantes".
public class Aspirante {

    @Id // Indica que este atributo es la clave primaria de la tabla.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos generará automáticamente el ID para cada nuevo registro.
    private Long id;

    @Column(name = "Opciones de Inscripción")
    private String opcionesInscripcion; // @Column(name = "Opciones de Inscripción"): Nombre de la columna en la base de datos. / nullable = false: Obligatorio.
    

    @Column(name = "Nombre", nullable = false) // @Column(name = "Nombre"): La columna en la base de datos se llamará "Nombre". / nullable = false: Este campo no puede estar vacío (es obligatorio).
    private String nombre; // Variable para almacenar el nombre del aspirante.

    @Column(name = "Fecha de Nacimiento", nullable = false) // Nombre de la columna en la base de datos.
    @Temporal(TemporalType.DATE) // Indica que este campo almacena una fecha (día, mes y año).
    private Date fechaNacimiento; // Variable que guarda la fecha de nacimiento del aspirante.

    @Column(name = "Genero", nullable = false)  // @Column(name = "Genero"):  Nombre de la columna en la base de datos. / nullable = false: Obligatorio (no puede estar vacío).
    private String genero; // Guarda el género del aspirante (Ejemplo: "Masculino", "Femenino", "Otro").

    @Column(name = "Correo", nullable = false, unique = true) // @Column(name = "Correo"): Nombre de la columna en la base de datos. / nullable = false: Obligatorio (no puede estar vacío). / unique = true: Debe ser único, es decir, no pueden existir dos aspirantes con el mismo correo.
    private String correo; // Guarda la dirección de correo del aspirante.

    @Column(name = "Telefono", nullable = false) // @Column(name = "Telefono"): Nombre de la columna en la base de datos. / nullable = false: Obligatorio 
    private String telefono; // Guarda el número de teléfono del aspirante.

    @Column(name = "Metodo de pago", nullable = false) // @Column(name = "Metodo de pago"): Nombre de la columna en la base de datos. / nullable = false: Obligatorio.
    private String metodoPago; // Guarda el método de pago que usa el aspirante (Ejemplo: "Tarjeta", "Efectivo", "Transferencia").

    // Getters y setters
}

/*
 📌 Resumen Final

     Atributo	        Descripción
     id	                ID único del aspirante (autogenerado).
     nombre	            Nombre del aspirante.
     fechaNacimiento	Fecha de nacimiento del aspirante.
     genero	            Género del aspirante.
     correo	            Correo electrónico (único).
     telefono	        Número de teléfono.
     metodoPago	        Método de pago del aspirante.

     🚀 ¿Cómo se usa esta clase en el proyecto?
        - Spring Boot la convierte en una tabla de base de datos.
        - Se pueden realizar operaciones como crear, leer, actualizar y eliminar aspirantes.
        - Se conecta con otros archivos como Controladores y Servicios para manejar la lógica del sistema.
 */