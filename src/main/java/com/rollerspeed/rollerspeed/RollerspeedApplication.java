/*Este archivo es el corazón de la aplicación Spring Boot.
  Es el que inicia y configura todo el proyecto automáticamente. */

package com.rollerspeed.rollerspeed; // 📌 Indica que este archivo pertenece al paquete rollerspeed, el núcleo de la aplicación.

import org.springframework.boot.SpringApplication; // SpringApplication → Se usa para iniciar la aplicación.
import org.springframework.boot.autoconfigure.SpringBootApplication; // @SpringBootApplication → Configura la aplicación para que Spring Boot funcione correctamente.


/*📌 @SpringBootApplication hace que Spring Boot:
     - Detecte automáticamente los componentes del proyecto.
     - Configure la aplicación sin que tú tengas que hacerlo manualmente.
     - Ejecute un servidor web interno (Tomcat). */
@SpringBootApplication
public class RollerspeedApplication {

    /*📌 ¿Qué hace?
       - Ejecuta la aplicación con SpringApplication.run(RollerspeedApplication.class, args).
       - Muestra un mensaje en la consola: "App Ejecutada Correctamente....", para indicar que todo inició sin errores. */
    public static void main(String[] args) {
        SpringApplication.run(RollerspeedApplication.class, args);
        System.out.println("App Ejecutada Correctamente....");
    }
}

/*
 * 🌟 ¿Qué pasa cuando ejecutamos la aplicación?
1️⃣ Spring Boot carga todas las configuraciones.
2️⃣ Busca las clases con @Service, @Repository, @Controller y las registra automáticamente.
3️⃣ Si todo está bien, inicia el servidor web y muestra el mensaje "App Ejecutada Correctamente....".

📌 Resumen Rápido
✅ RollerspeedApplication es la clase principal del proyecto.
✅ Usa @SpringBootApplication para configurar y ejecutar la app automáticamente.
✅ main() inicia el servidor y muestra un mensaje en la consola.
✅ Es lo primero que se ejecuta cuando corres la aplicación en Spring Boot.

💡 ¿Tienes más dudas o quieres agregar algo extra a la aplicación? 🚀
 */