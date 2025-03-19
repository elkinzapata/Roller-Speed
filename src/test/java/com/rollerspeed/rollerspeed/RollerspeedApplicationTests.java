/*Este archivo es un test automático para comprobar que la aplicación arranca bien sin errores. Es como 
  hacer una "prueba de encendido" para asegurarse de que todo está en su lugar. */

package com.rollerspeed.rollerspeed; // Aquí se define en qué "carpeta" lógica del proyecto está este archivo.

import org.junit.jupiter.api.Test; // Sirve para marcar un método como una prueba.
import org.springframework.boot.test.context.SpringBootTest; // Le dice a Spring Boot que cargue toda la aplicación para probar que no haya fallos.

@SpringBootTest // Se define la clase, que es como un "contenedor" para las pruebas.
class RollerspeedApplicationTests {

	/* - Este método no hace nada especial, pero si la aplicación tiene errores al arrancar, la prueba fallará.
       - Es como encender un auto y ver si el motor prende sin problemas. */
	@Test
	void contextLoads() {
	}

}

/*¿Para qué sirve esto?
    Es una prueba básica que ayuda a detectar problemas en la configuración del proyecto antes de hacer 
    pruebas más complejas. Si esta prueba pasa, significa que la aplicación puede iniciarse correctamente. */