  package com.rollerspeed.rollerspeed.Repository; // Especifica que este archivo pertenece al paquete Repository, el cual organiza las clases responsables del acceso a datos dentro del proyecto.

 

  import com.rollerspeed.rollerspeed.Model.Role;
  import org.springframework.data.jpa.repository.JpaRepository;
  import org.springframework.stereotype.Repository;
  
  @Repository
  public interface RoleRepository extends JpaRepository<Role, Long> {
  }