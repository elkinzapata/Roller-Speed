/*Este archivo define un repositorio en Spring Boot para la entidad Aspirante. Se encarga de la 
  interacción con la base de datos, permitiendo hacer consultas, inserciones, actualizaciones y 
  eliminaciones sin escribir SQL manualmente. */


package com.rollerspeed.rollerspeed.Repository; // Define que este archivo pertenece al paquete Repository dentro del proyecto. // Ayuda a organizar las clases de acceso a datos.

import org.springframework.data.jpa.repository.JpaRepository; // Proporciona métodos listos para usar como save(), findById(), deleteById(), etc.
import org.springframework.stereotype.Repository; // ndica que esta interfaz es un componente de acceso a datos.

import com.rollerspeed.rollerspeed.Model.Aspirante; // Importa la entidad Aspirante, que representa la tabla en la base de datos.

@Repository // Marca esta interfaz como un repositorio de Spring Boot.

public interface AspiranteRepository extends JpaRepository<Aspirante, Long> {} // Es la entidad que maneja este repositorio. / Es el tipo de la clave primaria (id en Aspirante).

/*
🛠 Métodos disponibles automáticamente
Al extender JpaRepository, Spring Boot nos proporciona métodos listos para usar sin escribir código adicional. Algunos ejemplos:

Método	            Descripción	                    Ejemplo de uso
save(Aspirante a)	Guarda un aspirante en la BD	repository.save(aspirante);
findById(Long id)	Busca un aspirante por ID	    repository.findById(1L);
findAll()	        Obtiene todos los aspirantes	repository.findAll();
deleteById(Long id)	Elimina un aspirante por ID	    repository.deleteById(1L);
count()	            Cuenta el número de aspirantes	repository.count();

🚀 ¿Cómo se usa en un Service?
Generalmente, el repositorio se usa en una clase de servicio (AspiranteService) para manejar la lógica de negocio.

@Service
public class AspiranteService {
    private final AspiranteRepository aspiranteRepository;

    @Autowired
    public AspiranteService(AspiranteRepository aspiranteRepository) {
        this.aspiranteRepository = aspiranteRepository;
    }

    public List<Aspirante> listarAspirantes() {
        return aspiranteRepository.findAll();
    }

    public Aspirante guardarAspirante(Aspirante aspirante) {
        return aspiranteRepository.save(aspirante);
    }
}
findAll() obtiene todos los aspirantes.
save(aspirante) guarda un nuevo aspirante en la BD.

📌 Resumen Final
✅ AspiranteRepository.java permite acceder a la base de datos sin escribir código SQL.
✅ Extiende JpaRepository<Aspirante, Long>, lo que nos da métodos listos como findAll(), save(), deleteById(), etc.
✅ Se usa dentro de un Service para manejar la lógica de negocio.

📌 ¿Necesitas agregar consultas personalizadas? 🚀

 */