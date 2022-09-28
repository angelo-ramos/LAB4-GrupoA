package com.example.lab4grupoa.Controller;

import com.example.lab4grupoa.Entity.Cuenta;
import com.example.lab4grupoa.Repository.CuentaRepository;
import com.example.lab4grupoa.Repository.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
    @Autowired
    CuentaRepository cuentaRepository;
    @Autowired
    MascotaRepository mascotaRepository;

    @GetMapping("/listar")
    public String listarContacto(Model model){
        model.addAttribute("listarCantidad", cuentaRepository.findAll());
        model.addAttribute("listaMascotas",mascotaRepository.listarMascotas());
        return "VistaContacto";
    }
    @GetMapping("/info")
    public String info(@ModelAttribute("cuenta") Cuenta cuenta, Model model){

        return "lista";
    }

}
