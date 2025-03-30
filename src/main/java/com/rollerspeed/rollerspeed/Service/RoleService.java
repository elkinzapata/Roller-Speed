
  package com.rollerspeed.rollerspeed.Service; // 📌 Indica que este archivo pertenece a la carpeta Service, que contiene la lógica del negocio.



  import com.rollerspeed.rollerspeed.Model.Role;
  import com.rollerspeed.rollerspeed.Repository.RoleRepository;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  
  import java.util.List;
  import java.util.Optional;
  
  @Service
  public class RoleService {
  
      @Autowired
      private RoleRepository roleRepository;
  
      public Role saveRole(Role role) {
          return roleRepository.save(role);
      }
  
      public List<Role> getAllRoles() {
          return roleRepository.findAll();
      }
  
      public Optional<Role> getRoleById(Long id) {
          return roleRepository.findById(id);
      }
  
      public void deleteRole(Long id) {
          roleRepository.deleteById(id);
      }
  
      // Otros métodos de servicio...
  }