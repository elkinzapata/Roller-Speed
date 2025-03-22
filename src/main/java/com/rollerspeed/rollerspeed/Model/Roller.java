/*El código Roller.java define una clase de entidad en un proyecto Spring Boot que representa la tabla 
  tbl_Roller en la base de datos. */

  package com.rollerspeed.rollerspeed.Model; //Indica que esta clase pertenece al paquete com.rollerspeed.rollerspeed.Model / Sirve para organizar el código dentro del proyecto.

  import lombok.Data; // Genera automáticamente los getters, setters, toString(), equals() y hashCode().
  
  //Importa las anotaciones necesarias para mapear la clase a una tabla en la base de datos.
  import jakarta.persistence.Entity;
  import jakarta.persistence.GeneratedValue;
  import jakarta.persistence.GenerationType;
  import jakarta.persistence.Id;
  import jakarta.persistence.Table; 
  
  @Entity // Indica que esta clase representa una tabla en la base de datos.
  @Data // Genera automáticamente getters, setters y otros métodos útiles (evita escribirlos manualmente).
  @Table(name = "tbl_Roller") // Define que la tabla en la base de datos se llamará "tbl_Roller".
  public class Roller {
      @Id // Indica que este campo es la clave primaria de la tabla.
      @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos generará el ID de forma automática.
      private Long id; // Variable que almacena el ID del objeto Roller.
      private String nombre; // Guarda el nombre del Roller.
      private String color; // Guarda el color del Roller.
      private double precio; // Guarda el precio del Roller.
  }
  
  /*
   📌 Resumen Final
  Atributo	Descripción
  id	        Identificador único del Roller (autogenerado).
  nombre	    Nombre del Roller.
  color	    Color del Roller.
  precio	    Precio del Roller.
  
  🚀 ¿Cómo se usa esta clase en el proyecto?
  - Spring Boot la convierte en una tabla en la base de datos.
  - Se puede usar en controladores y servicios para crear, leer, actualizar y eliminar rollers.
  - Ejemplo de uso en un repositorio:
    - public interface RollerRepository extends JpaRepository<Roller, Long> { }
    Nota: Esto permite interactuar con la base de datos sin escribir código SQL.
   */