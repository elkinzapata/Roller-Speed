/*El código Role.java define una clase de entidad en un proyecto de Spring Boot que representa la 
  tabla roles en la base de datos. */

  package com.rollerspeed.rollerspeed.Model; // Indica que esta clase pertenece al paquete com.rollerspeed.rollerspeed.Model. / Sirve para organizar el código dentro del proyecto.

  import jakarta.persistence.*; // Importa las anotaciones necesarias para mapear la clase a una tabla en la base de datos.
  import lombok.*; // Permite evitar escribir código repetitivo, como getters, setters y constructores.
  
  @Entity // Indica que esta clase representa una tabla en la base de datos.
  @Table(name = "roles") // Define que la tabla en la base de datos se llamará "roles".
  @Getter // Generan automáticamente los métodos getter y setter para cada atributo de la clase.
  @Setter // Generan automáticamente los métodos getter y setter para cada atributo de la clase.
  @NoArgsConstructor // Crea un constructor vacío (public Role() { }).
  @AllArgsConstructor // Crea un constructor con todos los atributos (public Role(Long id, String name) { ... }).
  public class Role {
      
      @Id // Indica que este campo es la clave primaria de la tabla.
      @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos generará el ID de forma automática.
      private Long id; // Variable que almacena el ID del rol.
      
      @Column(unique = true, nullable = false) // unique = true → No puede haber dos roles con el mismo nombre. / nullable = false → El nombre del rol es obligatorio.
      private String name; // Guarda el nombre del rol (Ejemplo: "ADMIN", "USER").
  }
  
  
  /*
   📌 Resumen Final
  Atributo	Descripción
  id	        Identificador único del rol (autogenerado).
  name	    Nombre del rol (Ejemplo: "ADMIN", "USER")
  
  🚀 ¿Cómo se usa esta clase en el proyecto?
  - Spring Boot la convierte en una tabla en la base de datos.
  - Se usa para manejar permisos y roles en el sistema.
  - Puede estar relacionada con usuarios en la aplicación.
   */