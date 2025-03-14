package com.rollerspeed.rollerspeed.Controller; // package com.rollerspeed.rollerspeed.Controller;

import org.springframework.stereotype.Controller; // @Controller: Indica que esta clase es un controlador de Spring MVC.
import org.springframework.web.bind.annotation.GetMapping; // @GetMapping: Se usa para manejar solicitudes HTTP GET.

@Controller // @Controller: Le dice a Spring que esta clase manejará las solicitudes web.

public class MainController { //public class MainController: Es la definición de la clase.

    /* - Maneja las solicitudes a "http://localhost:8080/".
       - Devuelve la vista "index", que normalmente es un archivo index.html en la carpeta templates.*/
    @GetMapping("/")
    public String home() {
        return "index";
    }

    /* - Maneja la solicitud a "http://localhost:8080/mision".
       - Devuelve la vista "mision.html". */
    @GetMapping("/mision")
    public String mision() {
        return "mision";
    }

    //Similar al anterior, pero para "http://localhost:8080/vision".
    @GetMapping("/vision")
    public String vision() {
        return "vision";
    }

    // Responde a "http://localhost:8080/valores".
    @GetMapping("/valores")
    public String valores() {
        return "valores";
    }

    // Responde a "http://localhost:8080/servicios".
    @GetMapping("/servicio")
    public String servicio() {
        return "servicio";
    }

    // Responde a "http://localhost:8080/eventos".
    @GetMapping("/eventos")
    public String eventos() {
        return "eventos";
    }

    // Responde a "http://localhost:8080/clases".
    @GetMapping("/clases")
    public String clases() {
        return "clases";
    }

    // Responde a "http://localhost:8080/registro".
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

}

/*

🔍 ¿Cómo funciona en la práctica?
Cuando un usuario accede a una de estas URLs en su navegador, Spring Boot busca la vista correspondiente (por ejemplo, index.html, mision.html, etc.) dentro de la carpeta src/main/resources/templates/.

📝 Resumen
📌 Este controlador maneja solicitudes HTTP GET y devuelve páginas HTML desde la carpeta templates.
📌 Es útil para definir la navegación básica de un sitio web en Spring Boot.
📌 Para que funcione correctamente, necesitas las plantillas HTML en la carpeta templates.

🚀 ¿Quieres agregar más funcionalidades, como pasar datos a las vistas? 

 */