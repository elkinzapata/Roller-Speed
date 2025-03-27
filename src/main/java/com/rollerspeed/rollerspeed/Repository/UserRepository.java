package com.rollerspeed.rollerspeed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rollerspeed.rollerspeed.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username); // Método para encontrar un usuario por su nombre de usuario.
}
