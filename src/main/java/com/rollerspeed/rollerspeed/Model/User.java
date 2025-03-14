/*El código User.java define una entidad en Spring Boot que representa la tabla users en la base de 
  datos. Esta clase gestiona los usuarios del sistema y sus roles. */

package com.rollerspeed.rollerspeed.Model; // Indica que esta clase pertenece al paquete com.rollerspeed.rollerspeed.Model. / Ayuda a organizar el código dentro del proyecto.

import jakarta.persistence.*; // Importa anotaciones de JPA (para mapear la clase a la base de datos).
import lombok.*; // Facilita la creación de métodos (getters, setters, constructores).

import java.util.Set; // Permite manejar conjuntos de roles para cada usuario.

@Entity // Indica que esta clase representa una tabla en la base de datos.
@Table(name = "users") // Define que la tabla se llamará "users".
@Getter // Lombok genera automáticamente los getters y setters.
@Setter // Lombok genera automáticamente los getters y setters.
@NoArgsConstructor // Crea un constructor vacío.
@AllArgsConstructor // Crea un constructor con todos los atributos.
public class User {
    
    @Id // Define este campo como clave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La base de datos genera automáticamente el ID. / Usa un campo autoincremental.
    private Long id;
    
    @Column(unique = true, nullable = false, length = 50) // unique = true → No puede haber dos usuarios con el mismo nombre. / nullable = false → No puede estar vacío. / length = 50 → Máximo 50 caracteres.
    private String username; 
    
    @Column(nullable = false) // Debe tener un valor obligatorio (nullable = false) / En sistemas reales, debe almacenarse cifrada (BCrypt, por ejemplo).
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER) // @ManyToMany → Un usuario puede tener muchos roles, y un rol puede pertenecer a muchos usuarios. / fetch = FetchType.EAGER → Carga los roles inmediatamente cuando se consulta un usuario. / Alternativa: FetchType.LAZY (se carga cuando sea necesario).
    @JoinTable(name = "user_roles", // Crea una tabla intermedia llamada "user_roles" para manejar la relación.
               joinColumns = @JoinColumn(name = "user_id"), //  Relaciona con la tabla de usuarios.
               inverseJoinColumns = @JoinColumn(name = "role_id")) // Relaciona con la tabla de roles.
    private Set<Role> roles;
}


/*
 📌 Resumen Final
Atributo	Descripción
id	        Identificador único del usuario.
username	Nombre de usuario único (máximo 50 caracteres).
password	Contraseña del usuario (debe cifrarse).
roles	    Lista de roles asociados al usuario.

🚀 ¿Cómo se usa esta clase en el proyecto?
Ejemplo de un usuario con dos roles ("ADMIN" y "USER"):
 -  User user = new User();
    user.setUsername("johndoe");
    user.setPassword("password123"); // ¡Debe cifrarse en producción!
    user.setRoles(Set.of(new Role(1L, "ADMIN"), new Role(2L, "USER")));
 Nota: Esto permite que el usuario johndoe tenga los roles de administrador y usuario.
 */