package com.rollerspeed.rollerspeed.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI para la documentación de la API de Roller Speed.
 * <p>
 * OpenAPI es un estándar para la documentación de APIs REST, permitiendo que los clientes
 * puedan entender y consumir los servicios de forma más sencilla. Esta configuración
 * permite la generación automática de la documentación con Swagger.
 * </p>
 *
 * <p>
 * Al acceder a la URL correspondiente en el entorno de ejecución, los usuarios pueden
 * visualizar y probar los endpoints de la API de Roller Speed de manera interactiva.
 * </p>
 */
@Configuration
public class OpenApiConfig {

    /**
     * Configura y personaliza la documentación de OpenAPI para la API de Roller Speed.
     * <p>
     * Este método define un bean que inicializa un objeto {@link OpenAPI} con información
     * relevante sobre la API, incluyendo:
     * </p>
     * <ul>
     *     <li><b>Título:</b> Roller Speed API</li>
     *     <li><b>Versión:</b> 1.0</li>
     *     <li><b>Descripción:</b> Documentación de la API para Roller Speed</li>
     * </ul>
     *
     * <p>
     * Esta configuración es útil para mejorar la experiencia de los desarrolladores y
     * facilitar la integración con otros sistemas.
     * </p>
     *
     * @return una instancia de {@link OpenAPI} con la configuración personalizada,
     *         lista para ser utilizada por Swagger UI.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Roller Speed API")
                        .version("1.0")
                        .description("Documentación de la API para Roller Speed"));
    }
}