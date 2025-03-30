/*Este archivo es el corazón de la aplicación Spring Boot.
  Es el que inicia y configura todo el proyecto automáticamente. */

package com.rollerspeed.rollerspeed; // 📌 Indica que este archivo pertenece al paquete rollerspeed, el núcleo de la aplicación.

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class RollerspeedApplication {

    private static final Logger logger = LoggerFactory.getLogger(RollerspeedApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RollerspeedApplication.class, args);
        logger.info("App Ejecutada Correctamente....");
    }
  }