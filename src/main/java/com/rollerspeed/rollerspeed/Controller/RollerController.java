package com.rollerspeed.rollerspeed.Controller;

import com.rollerspeed.rollerspeed.Model.Roller;
import com.rollerspeed.rollerspeed.Service.RollerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/Roller")
public class RollerController {
    private final RollerService RollerService;

    public RollerController(RollerService RollerService) {
        this.RollerService = RollerService;
    }

    @GetMapping("/listar")
    public String listarFlores(Model model) {
        List<Roller> roller = RollerService.findAll();
        model.addAttribute("Roller", roller);
        return "Roller";
    }
}