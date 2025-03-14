package com.rollerspeed.rollerspeed.Controller; // Indica que este archivo pertenece al paquete com.rollerspeed.rollerspeed.Controller.

import com.rollerspeed.rollerspeed.Model.Roller; // Roller: Representa la entidad o modelo de datos.
import com.rollerspeed.rollerspeed.Service.RollerService; // RollerService: Servicio que maneja la lógica de negocio relacionada con Roller.
import org.springframework.stereotype.Controller; // @Controller: Indica que esta clase es un controlador MVC de Spring.
import org.springframework.ui.Model; // Model: Se usa para enviar datos a la vista.
import org.springframework.web.bind.annotation.GetMapping; // @GetMapping: Se usa para manejar solicitudes HTTP GET.
import org.springframework.web.bind.annotation.RequestMapping; // @RequestMapping: Define la ruta base del controlador.

import java.util.List; // List: Permite trabajar con listas de objetos Roller.

@Controller // @Controller: Define esta clase como un controlador en Spring MVC.
@RequestMapping(value = "/Roller") // @RequestMapping(value = "/Roller"): Todas las rutas definidas dentro de este controlador empezarán con /Roller
public class RollerController {

    //Se usa inyección de dependencias para inicializar RollerService a través del constructor.
    private final RollerService RollerService;

    public RollerController(RollerService RollerService) { // RollerService es una clase de servicio que contiene la lógica de negocio y la conexión con la base de datos.
        this.RollerService = RollerService;
    }

    @GetMapping("/listar") // @GetMapping("/listar") → Maneja las solicitudes GET en "/Roller/listar".
    public String listarFlores(Model model) {
        List<Roller> roller = RollerService.findAll(); // Llama al método findAll() del servicio RollerService para obtener todos los objetos Roller.
        model.addAttribute("Roller", roller); // Agrega la lista de objetos Roller al modelo, permitiendo que la vista acceda a ella.
        return "Roller"; // Retorna el nombre de la vista (Roller.html o Roller.jsp dependiendo de la configuración del proyecto).
    }
}

/* ¿Cómo funciona en la práctica?
 
 - Un usuario accede a la URL
 - El controlador ejecuta RollerService.findAll(), recuperando los datos de la base de datos.
 - Los datos se pasan a la vista "Roller", donde pueden mostrarse en una tabla o lista.

 */

 /*
Resumen
📌 Este controlador maneja la ruta /Roller/listar y obtiene todos los registros de Roller desde la base de datos.
📌 Inyecta RollerService para acceder a la lógica de negocio.
📌 Usa Model para pasar datos a la vista.
📌 Devuelve la vista "Roller", que mostrará la lista de registros.

🚀 ¿Quieres agregar más funcionalidades como crear, actualizar o eliminar registros? 
  */