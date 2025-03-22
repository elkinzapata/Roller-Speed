/*Este archivo maneja la lógica de los patines (Roller) dentro de la aplicación.
  Se encarga de buscar y guardar patines en la base de datos. */

  package com.rollerspeed.rollerspeed.Service; // 📌 Indica que este archivo pertenece a la carpeta Service, que contiene la lógica del negocio.

  // RollerService.java
  
  import com.rollerspeed.rollerspeed.Model.Roller; // Roller → La clase que representa un patín.
  import com.rollerspeed.rollerspeed.Repository.RollerRepository; // RollerRepository → La conexión con la base de datos.
  import org.springframework.stereotype.Service; // @Service → Para decirle a Spring Boot que esta clase es un servicio.
  
  import java.util.List; // List → Para manejar listas de patines.
  
  @Service // 📌 @Service le dice a Spring Boot que esta clase es un servicio, encargada de la lógica de los patines.
  public class RollerService {
      
      
      /*📌 ¿Qué hace?
            - Declara un objeto RollerRepository para conectar con la base de datos.
            - Usa un constructor para inicializar la conexión. */
      private final com.rollerspeed.rollerspeed.Repository.RollerRepository RollerRepository;
  
      public RollerService(RollerRepository RollerRepository) {
          this.RollerRepository = RollerRepository;
      }
  
  
      /*📌 ¿Qué hace?
            - Busca todos los patines en la base de datos.
            - Retorna una lista de patines (List<Roller>).
           💡 Ejemplo de uso: Cuando queremos mostrar todos los patines en la página. */
      public List<Roller> findAll() {
          return RollerRepository.findAll();
      }
  
  
      /*📌 ¿Qué hace?
        - Recibe un patín (Roller roller).
        - Lo guarda en la base de datos usando RollerRepository.save(roller).
        - Retorna el patín guardado.
       💡 Ejemplo de uso: Cuando un usuario registra un nuevo patín en la aplicación. */
      public Roller save (Roller roller){
          return RollerRepository.save(roller);
      }
  }
  
  /*
  🌟 ¿Cómo se usa este servicio?
  Este servicio se usa en un controlador (RollerController.java) para obtener y guardar patines.
  
  @Controller
  @RequestMapping("/Roller")
  public class RollerController {
  
      private final RollerService rollerService;
  
      public RollerController(RollerService rollerService) {
          this.rollerService = rollerService;
      }
  
      @GetMapping("/listar")
      public String listarRollers(Model model) {
          List<Roller> rollers = rollerService.findAll();
          model.addAttribute("Rollers", rollers);
          return "Roller";
      }
  
      @PostMapping("/guardar")
      public String guardarRoller(Roller roller) {
          rollerService.save(roller);
          return "redirect:/Roller/listar";
      }
  }
  
  📌 ¿Qué hace este controlador?
  
  📋 Lista todos los patines en la página /Roller/listar.
  🛒 Guarda un nuevo patín cuando se envía un formulario.
  
  📌 Resumen Rápido
  ✅ RollerService maneja la lógica de los patines.
  ✅ Se conecta a la base de datos usando RollerRepository.
  ✅ findAll() → Devuelve todos los patines.
  ✅ save(Roller roller) → Guarda un nuevo patín.
  ✅ Se usa en un controlador para mostrar y guardar patines en la web.
  
  💡 ¿Te gustaría agregar más funciones, como eliminar o actualizar patines? 🚀
  
   */