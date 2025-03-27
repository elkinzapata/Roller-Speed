package com.rollerspeed.rollerspeed.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public void registerUser(String username, String rawPassword) {
        // Cifrar la contraseña
        String encodedPassword = passwordEncoder.encode(rawPassword);
        
        // Crear el usuario y guardarlo en la base de datos
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(encodedPassword);
        
        // Guardar el nuevo usuario en el repositorio
        userRepository.save(newUser);
    }
}
