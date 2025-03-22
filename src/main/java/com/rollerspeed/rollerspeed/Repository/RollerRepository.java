/*Este archivo define un repositorio en Spring Boot para la entidad Roller. Se encarga de la interacción 
  con la base de datos, permitiendo realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sin 
  necesidad de escribir SQL manualmente. */


  package com.rollerspeed.rollerspeed.Repository; // Especifica que este archivo pertenece al paquete Repository, el cual organiza las clases responsables del acceso a datos dentro del proyecto.

  // FlorRepository.java
  
  import com.rollerspeed.rollerspeed.Model.Roller; // Importa la entidad Roller, que representa la tabla en la base de datos.
  import org.springframework.data.jpa.repository.JpaRepository; // Proporciona métodos predefinidos para acceder a la base de datos.
  import org.springframework.stereotype.Repository; // Indica que esta interfaz es un componente de acceso a datos y debe ser gestionado por Spring.
  
  @Repository // Marca esta interfaz como un repositorio de Spring Boot, lo que permite la inyección de dependencias.
  public interface RollerRepository extends JpaRepository<Roller, Long> {
  } /* Extiende JpaRepository<Roller, Long>, lo que proporciona métodos predefinidos para interactuar con la base de datos.
        - Roller → Es la entidad que maneja este repositorio.
        - Long → Es el tipo de dato de la clave primaria (id en Roller).
    */ 
  
  
  
  /*
  🛠 Métodos disponibles automáticamente
  Al extender JpaRepository, Spring Boot nos proporciona métodos listos para usar sin escribir código adicional. Algunos ejemplos:
  
  Método	            Descripción	                    Ejemplo de uso
  save(Aspirante a)	Guarda un aspirante en la BD	repository.save(aspirante);
  findById(Long id)	Busca un aspirante por ID	    repository.findById(1L);
  findAll()	        Obtiene todos los aspirantes	repository.findAll();
  deleteById(Long id)	Elimina un aspirante por ID	    repository.deleteById(1L);
  count()	            Cuenta el número de aspirantes	repository.count();
  
  🚀 Uso en un Service
  Normalmente, este repositorio se usa en una clase de servicio (RollerService) para manejar la lógica de negocio.
  
  @Service
  public class RollerService {
      private final RollerRepository rollerRepository;
  
      @Autowired
      public RollerService(RollerRepository rollerRepository) {
          this.rollerRepository = rollerRepository;
      }
  
      public List<Roller> listarRollers() {
          return rollerRepository.findAll();
      }
  
      public Roller guardarRoller(Roller roller) {
          return rollerRepository.save(roller);
      }
  
      public void eliminarRoller(Long id) {
          rollerRepository.deleteById(id);
      }
  }
  
  findAll() obtiene todos los rollers.
  save(roller) guarda un nuevo roller en la base de datos.
  deleteById(id) elimina un roller por su ID.
  
  📌 Resumen Final
  ✅ RollerRepository.java permite acceder a la base de datos sin escribir código SQL.
  ✅ Extiende JpaRepository<Roller, Long>, lo que nos da métodos listos como findAll(), save(), deleteById(), etc.
  ✅ Se usa dentro de un Service para manejar la lógica de negocio.
  
  📌 ¿Necesitas agregar consultas personalizadas? 🚀
  
   */