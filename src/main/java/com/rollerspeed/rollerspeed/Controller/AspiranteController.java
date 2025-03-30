package com.rollerspeed.rollerspeed.Controller;

import com.rollerspeed.rollerspeed.Model.User;
import com.rollerspeed.rollerspeed.Model.Role;
import com.rollerspeed.rollerspeed.Repository.RoleRepository;
import com.rollerspeed.rollerspeed.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AspiranteController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Este es el único método que debe manejar /register
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        Role publicRole = roleRepository.findById(4L).get();
        user.setRole(publicRole);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/login?success";
    }

    // Elimina cualquier otro método que tenga @PostMapping("/register")
}