package com.rollerspeed.rollerspeed.Controller; /* - Define que esta clase pertenece al paquete com.rollerspeed.rollerspeed.Controller.
                                                   - Los paquetes en Java se usan para organizar las clases y evitar conflictos de nombres.
                                                   - Controller indica que este paquete contiene controladores, es decir, clases que manejan peticiones HTTP en Spring Boot. */

import org.springframework.beans.factory.annotation.Autowired; // Inyección de dependencias automática de Spring. Permite que Spring cree e inyecte el objeto AspiranteRepository sin necesidad de instanciarlo manualmente.
import org.springframework.stereotype.Controller; // Define esta clase como un controlador en Spring Boot, que maneja peticiones HTTP.
import org.springframework.ui.Model; // Permite enviar datos desde el controlador a la vista (HTML, JSP, etc.).
import org.springframework.web.bind.annotation.GetMapping; // Define un método que manejará solicitudes HTTP GET.
import org.springframework.web.bind.annotation.ModelAttribute; // Vincula un objeto de modelo con los datos enviados desde un formulario HTML.
import org.springframework.web.bind.annotation.PostMapping; // Define un método que manejará solicitudes HTTP POST.
import org.springframework.web.bind.annotation.RequestMapping; // Define la URL base para las peticiones que manejará este controlador.

import com.rollerspeed.rollerspeed.Model.Aspirante; // Importa la clase Aspirante, que representa la entidad en la base de datos.
import com.rollerspeed.rollerspeed.Repository.AspiranteRepository; // Repositorio que interactúa con la base de datos para la entidad Aspirante.


/* 
   ¿Para qué sirve todo esto en conjunto?
Organiza la estructura del código usando paquetes.
Permite que el controlador interactúe con la base de datos a través del repositorio AspiranteRepository.
Maneja solicitudes HTTP GET y POST para recibir y enviar datos.
Usa Model para pasar información a la vista.
Aplica inyección de dependencias (@Autowired) para manejar automáticamente los objetos de Spring. 
*/



@SuppressWarnings("unused")
@Controller // Indica que esta clase es un Controlador en Spring MVC./ Su propósito es manejar peticiones HTTP y retornar vistas.
@RequestMapping("/aspirantes") // Define una URL base para todas las rutas de este controlador. / Esto significa que todas las rutas dentro de esta clase comenzarán con /aspirantes.
public class AspiranteController {

    @Autowired // Inyecta automáticamente el AspiranteRepository para que podamos acceder a la base de datos sin instanciarlo manualmente.
    private AspiranteRepository aspiranteRepository; //Nos permite guardar y obtener aspirantes de la base de datos.

@GetMapping("/registro") // Indica que cuando un usuario visite /aspirantes/registro, este método responderá.
public String mostrarformularioRegistro(Model model) { // Model model: Spring usa el Model para enviar datos a la vista (HTML).
    model.addAttribute("aspirante", new Aspirante()); //Crea un objeto vacío de Aspirante y lo envía a la vista. // Esto sirve para que el formulario HTML lo use en los campos.
    return "Registro"; // Retorna la vista Registro.html o Registro.jsp, donde se mostrará el formulario.
}

    @PostMapping("/guardar") // Maneja peticiones POST cuando se envía el formulario.
    public String guardarAspirante(@ModelAttribute Aspirante aspirante) {  // Spring toma los datos del formulario y los convierte en un objeto Aspirante.
        aspiranteRepository.save(aspirante); //Guarda el objeto Aspirante en la base de datos.
        return "Exito"; // Después de guardar, redirige al usuario a /aspirante/registro-exitoso.
    }
    
}

/*
📌 🔥 Resumen Final
✅ AspiranteController maneja el registro de aspirantes en la aplicación.
✅ Métodos principales:

GET /aspirantes/registro → Muestra el formulario de registro.
POST /aspirantes/guardar → Guarda un aspirante en la base de datos y redirige.
✅ Usa AspiranteRepository para interactuar con la base de datos. 
 */