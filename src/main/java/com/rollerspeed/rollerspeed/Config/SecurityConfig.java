package com.rollerspeed.rollerspeed.Config; //Esto indica que este archivo pertenece al paquete com.rollerspeed.rollerspeed.Config. Los paquetes organizan el código en diferentes módulos dentro de tu proyecto.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration; // Indica que esta clase es un archivo de configuración en Spring.
import org.springframework.security.config.annotation.web.builders.HttpSecurity; // Permite definir reglas de seguridad, como autenticación y permisos.
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; //Habilita la seguridad web en la aplicación.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; //Es un algoritmo seguro para encriptar contraseñas antes de guardarlas en la base de datos.
import org.springframework.security.crypto.password.PasswordEncoder; // Es una interfaz para cifrar contraseñas.
import org.springframework.security.web.SecurityFilterChain; // Configura filtros de seguridad, como protección contra ataques y manejo de accesos.

@Configuration // Indica que esta clase es una clase de configuración en Spring. 
@EnableWebSecurity // Activa las funcionalidades de seguridad de Spring Security.
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF para APIs REST (ajustar según necesidad) "Se deshabilita porque en APIs REST no siempre es necesario."
            .cors(cors -> {})  // Habilitar CORS si se usa con frontend separado "Permite que la aplicación sea accedida desde otros dominios (por ejemplo, desde un frontend separado)."
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/admin/**").hasRole("ADMIN") // Las rutas /admin/** solo pueden ser accedidas por usuarios con rol "ADMIN". 
                .requestMatchers("/instructor/**").hasRole("INSTRUCTOR") // Las rutas /instructor/** requieren rol "INSTRUCTOR"
                .requestMatchers("/").permitAll() // La ruta raíz / es pública (cualquiera puede acceder)
                .anyRequest().authenticated() // Cualquier otra ruta necesita que el usuario esté autenticado.
            )
            .formLogin(form -> form
                .loginPage("/login")  // Se define una página de login personalizada en /login.
                .defaultSuccessUrl("/home", true)  // Si el login es exitoso, redirige a /home.
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout") //El logout se hace en la URL /logout
                .logoutSuccessUrl("/") // Después de cerrar sesión, el usuario es redirigido a la página principal (/)
                .invalidateHttpSession(true) // Se invalidan la sesión y las cookies para evitar que alguien reutilice la sesión
                .deleteCookies("JSESSIONID") // Borra la cookie de sesión
            );

        return http.build();
    }

    // Configuración de codificación de contraseñas
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } // Configura BCrypt, un algoritmo seguro para cifrar contraseñas / Cuando un usuario se registre, su contraseña será almacenada cifrada en la base de datos.
}

/*
🧐 ¿Para qué sirve este código?
Protege la aplicación al definir permisos y roles de usuario.
Evita ataques de sesión y reutilización de credenciales con logout seguro.
Cifra las contraseñas para que no se almacenen en texto plano.
Permite personalizar el login y logout.
 */

