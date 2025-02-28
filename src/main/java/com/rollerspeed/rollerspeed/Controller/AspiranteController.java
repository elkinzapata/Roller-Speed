package com.rollerspeed.rollerspeed.Controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rollerspeed.rollerspeed.Model.Aspirante;
import com.rollerspeed.rollerspeed.Repository.AspiranteRepository;

@Controller
@RequestMapping("/aspirantes")
public class AspiranteController {

    @Autowired
    private AspiranteRepository aspiranteRepository;

    @GetMapping("/registro")
    public String mostrarFormulario(Model model) {
        model.addAttribute("aspirante", new Aspirante());
        return "registro";
    }

    @PostMapping("/guardar")
    public String guardarAspirante(@ModelAttribute Aspirante aspirante) {
        aspiranteRepository.save(aspirante);
        return "redirect:/";
    }
}
