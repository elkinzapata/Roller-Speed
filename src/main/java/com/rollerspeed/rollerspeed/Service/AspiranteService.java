/* Este archivo define un servicio en Spring Boot para manejar la lógica de negocio relacionada con los 
   aspirantes (Aspirante).

📌 Función principal: Permite guardar aspirantes en la base de datos utilizando el repositorio 
    AspiranteRepository.
 */

package com.rollerspeed.rollerspeed.Service; // Especifica que este archivo pertenece al paquete Service, el cual contiene la lógica de negocio de la aplicación.

import org.springframework.beans.factory.annotation.Autowired; // @Autowired → Para conectar automáticamente esta clase con otras partes del código.
import org.springframework.stereotype.Service; // @Service → Para decirle a Spring Boot que esta clase maneja reglas del negocio.

import com.rollerspeed.rollerspeed.Model.Aspirante; // Aspirante → El modelo de datos (representa un aspirante).
import com.rollerspeed.rollerspeed.Repository.AspiranteRepository; // AspiranteRepository → La conexión con la base de datos para guardar aspirantes.

@Service // @Service le dice a Spring Boot que esta clase es un servicio y que se encargará de manejar aspirantes.
public class AspiranteService {

    /* 📌 @Autowired permite que aspiranteRepository funcione sin que lo creemos manualmente.  
       💡 Piensa en esto como una conexión automática a la base de datos. */
    @Autowired 
    private AspiranteRepository aspiranteRepository;


    /*📌 ¿Qué hace?
          - Recibe un aspirante como parámetro.
          - Lo guarda en la base de datos usando aspiranteRepository.save(aspirante);. */
    public void guardarAspirante(Aspirante aspirante) {
        aspiranteRepository.save(aspirante);
    }
}

/*
 *🌟 ¿Cómo se usa este servicio?
Este servicio se usa dentro de un controlador (AspiranteController.java) para guardar aspirantes cuando un usuario llena un formulario.

@Controller
@RequestMapping("/Aspirante")
public class AspiranteController {

    @Autowired
    private AspiranteService aspiranteService;

    @PostMapping("/guardar")
    public String guardarAspirante(Aspirante aspirante) {
        aspiranteService.guardarAspirante(aspirante);
        return "redirect:/Aspirante/listar";
    }
}

📌 ¿Qué hace?

Cuando el usuario envía el formulario de nuevo aspirante, el controlador llama a guardarAspirante(aspirante) para guardarlo en la base de datos.

📌 Resumen Rápido
✅ AspiranteService maneja la lógica de los aspirantes.
✅ Se conecta a la base de datos usando AspiranteRepository.
✅ Tiene un método para guardar aspirantes (guardarAspirante).
✅ Se usa en un controlador para guardar aspirantes desde un formulario.

💡 ¿Te gustaría que agreguemos más funciones, como listar o eliminar aspirantes? 🚀
 */