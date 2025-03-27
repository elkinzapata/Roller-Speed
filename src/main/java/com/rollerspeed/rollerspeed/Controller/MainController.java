package com.rollerspeed.rollerspeed.Controller; // Define el paquete donde se encuentra esta clase.

import org.springframework.stereotype.Controller; // Importa la anotación Controller de Spring.
import org.springframework.web.bind.annotation.PostMapping; // Importa la anotación para manejar solicitudes POST.
import org.springframework.web.bind.annotation.RequestParam; // Importa la anotación para obtener parámetros de la solicitud.
import org.springframework.beans.factory.annotation.Autowired; // Importa la anotación para la inyección de dependencias.
import com.rollerspeed.rollerspeed.Repository.UserRepository; // Importa el repositorio de usuarios.
import com.rollerspeed.rollerspeed.Model.User; // Importa el modelo de usuario.
import com.rollerspeed.rollerspeed.Service.UserService; // Importa el servicio de usuarios.
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // Importa la clase para cifrar contraseñas.
import org.springframework.web.bind.annotation.GetMapping; // Importa la anotación para manejar solicitudes GET.
import org.springframework.web.servlet.ModelAndView; // Importa la clase para devolver vistas.

@Controller // Indica que esta clase es un controlador de Spring.
public class MainController {

    @Autowired // Permite que Spring inyecte automáticamente la instancia de UserRepository.
    private UserRepository userRepository; // Repositorio para acceder a los datos de los usuarios.

    @Autowired // Permite que Spring inyecte automáticamente la instancia de UserService.
    private UserService userService; // Servicio para manejar la lógica de negocio relacionada con los usuarios.

    @Autowired // Permite que Spring inyecte automáticamente la instancia de BCryptPasswordEncoder.
    private BCryptPasswordEncoder passwordEncoder; // Para cifrar las contraseñas de los usuarios.

    @GetMapping("/login") // Mapea las solicitudes GET a la ruta "/login".
    public String loginForm() {
        return "login"; // Devuelve la vista "login" para mostrar el formulario de inicio de sesión.
    }

    @PostMapping("/login") // Mapea las solicitudes POST a la ruta "/login".
    public ModelAndView login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsername(username); // Busca el usuario por nombre de usuario.
        if (user != null && passwordEncoder.matches(password, user.getPassword())) { // Verifica si el usuario existe y si la contraseña coincide.
            return new ModelAndView("redirect:/"); // Redirige a la página principal si las credenciales son correctas.
        }
        return new ModelAndView("login"); // Devuelve la vista "login" si las credenciales son incorrectas.
    }

    @GetMapping("/register") // Mapea las solicitudes GET a la ruta "/api/users/register".
    public String showRegisterForm() {
        return "register"; // Devuelve la vista "register" para mostrar el formulario de registro.
    }

    @PostMapping("/register") // Mapea las solicitudes POST a la ruta "/api/users/register".
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password); // Llama al servicio para registrar un nuevo usuario.
        return "Usuario registrado con éxito"; // Devuelve un mensaje de éxito.
    }

    @GetMapping("/") // Mapea las solicitudes GET a la ruta "/".
    public String home() {
        return "index"; // Devuelve la vista "index" para mostrar la página principal.
    }

    @GetMapping("/mision") // Mapea las solicitudes GET a la ruta "/mision".
    public String mision() {
        return "mision"; // Devuelve la vista "mision".
    }

    @GetMapping("/vision") // Mapea las solicitudes GET a la ruta "/vision".
    public String vision() {
        return "vision"; // Devuelve la vista "vision".
    }

    @GetMapping("/valores") // Mapea las solicitudes GET a la ruta "/valores".
    public String valores() {
        return "valores"; // Devuelve la vista "valores".
    }

    @GetMapping("/servicio") // Mapea las solicitudes GET a la ruta "/servicio".
    public String servicio() {
        return "servicio"; // Devuelve la vista "servicio".
    }

    @GetMapping("/eventos") // Mapea las solicitudes GET a la ruta "/eventos".
    public String eventos() {
        return "eventos"; // Devuelve la vista "eventos".
    }

    @GetMapping("/clases") // Mapea las solicitudes GET a la ruta "/clases".
    public String clases() {
        return "clases"; // Devuelve la vista "clases".
    }

    @GetMapping("/registro") // Mapea las solicitudes GET a la ruta "/registro".
    public String registro() {
        return "registro"; // Devuelve la vista "registro".
    }
}
