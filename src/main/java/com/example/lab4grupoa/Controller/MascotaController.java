package com.example.lab4grupoa.Controller;

import com.example.lab4grupoa.Dto.ListarMascotasDto;
import com.example.lab4grupoa.Entity.Mascota;
import com.example.lab4grupoa.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/mascota")
public class MascotaController {

    @Autowired
    ResponsableRepository responsableRepository;
    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    RazaEspecieRepository razaEspecieRepository;

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    ServicioRepository servicioRepository;

    @GetMapping("/listar")
    public String listarMascotas(Model model){
        model.addAttribute("listaMascotas",mascotaRepository.listarMascotas());
        return "lista";
    }

    @PostMapping("/filtrar")
    public String filtrarMascotas(Model model, @RequestParam("searchField") String searchField){
        model.addAttribute("listaMascotas",mascotaRepository.filtrarMascotas(searchField));
        model.addAttribute("searchField",searchField);
        return "lista";
    }

    @GetMapping("/new")
    public String nuevaMascota(Model model, @ModelAttribute("mascota") Mascota mascota){
        model.addAttribute("listaRazas",razaEspecieRepository.findAll());
        model.addAttribute("listaCuentas",cuentaRepository.findAll());
        return "newFrmMascota";
    }

    @PostMapping("/save")
    public String filtrarMascotas(Model model, @ModelAttribute("mascota") @Valid Mascota mascota, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            model.addAttribute("listaRazas",razaEspecieRepository.findAll());
            model.addAttribute("listaCuentas",cuentaRepository.findAll());
            return "newFrmMascota";
        }else {
            mascotaRepository.save(mascota);
            return "redirect:/mascota/listar";
        }
    }

    @GetMapping("/servicio")
    public String DetalleServicio(Model model, @RequestParam("id") String id){
        System.out.println(id);
        model.addAttribute("listaServicios",servicioRepository.listarServicioMascota(Integer.parseInt(id)));
        return "detalleservicio";
    }

    @GetMapping("/servicio/new")
    public String NuevoServicio(Model model){
        model.addAttribute("listaMascotas",mascotaRepository.findAll());
        model.addAttribute("listaCuentas",cuentaRepository.findAll());
        model.addAttribute("listaResponsables",responsableRepository.findAll());
        return "newService";
    }
}

