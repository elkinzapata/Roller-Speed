package com.rollerspeed.rollerspeed.Config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {
        try {
            logger.info("Verificando si el usuario 'admin' existe...");
            Integer userCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM users WHERE username = 'admin'", Integer.class);

            if (userCount == null || userCount == 0) {
                logger.info("Insertando el usuario 'admin'...");
                jdbcTemplate.update("INSERT INTO users (username, password, role_id) VALUES (?, ?, ?)",
                        "admin", "$2a$12$EYNO0c0uI8WgC6o/L/Q3FudPeo9JFTH6hwlxegvfgyF4JUYFRnOYu", 1); // Reemplaza con el hash correcto
                logger.info("Usuario 'admin' insertado.");
            } else {
                logger.info("El usuario 'admin' ya existe.");
            }

            //logger.info("Otorgando privilegios al usuario 'admin'...");
            //jdbcTemplate.update("GRANT ALL PRIVILEGES ON rollerspeed.* TO 'admin'@'localhost'");
            //jdbcTemplate.update("FLUSH PRIVILEGES");
            //logger.info("Privilegios otorgados y actualizados.");

        } catch (Exception e) {
            logger.error("Error al inicializar la base de datos: " + e.getMessage(), e);
            throw e;
        }
    }
}