package com.rollerspeed.rollerspeed.Controller;



import com.rollerspeed.rollerspeed.Model.Pago;
import com.rollerspeed.rollerspeed.Service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("pago", new Pago());
        return "pago/registro";
    }

    @PostMapping("/registro")
    public String registrarPago(Pago pago) {
        pagoService.savePago(pago);
        return "redirect:/pago/reportes";
    }

    @GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        model.addAttribute("pagos", pagoService.getAllPagos());
        return "pago/reportes";
    }
}