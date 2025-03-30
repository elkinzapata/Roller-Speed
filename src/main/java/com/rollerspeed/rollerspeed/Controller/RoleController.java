package com.rollerspeed.rollerspeed.Controller; // Indica que este archivo pertenece al paquete com.rollerspeed.rollerspeed.Controller.

import com.rollerspeed.rollerspeed.Model.Role;
import com.rollerspeed.rollerspeed.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/lista")
    public String mostrarListaRoles(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        return "role/lista";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCrearRol(Model model) {
        model.addAttribute("role", new Role());
        return "role/crear";
    }

    @PostMapping("/crear")
    public String crearRol(Role role) {
        roleService.saveRole(role);
        return "redirect:/role/lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarRol(@PathVariable Long id, Model model) {
        Role role = roleService.getRoleById(id).orElse(null);
        model.addAttribute("role", role);
        return "role/editar";
    }

    @PostMapping("/editar/{id}")
    public String editarRol(@PathVariable Long id, Role role) {
        role.setId(id);
        roleService.saveRole(role);
        return "redirect:/role/lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarRol(@PathVariable Long id) {
        roleService.deleteRole(id);
        return "redirect:/role/lista";
    }
}