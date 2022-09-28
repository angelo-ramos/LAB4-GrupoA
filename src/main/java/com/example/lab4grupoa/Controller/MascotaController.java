package com.example.lab4grupoa.Controller;

import com.example.lab4grupoa.Dto.ListarMascotasDto;
import com.example.lab4grupoa.Entity.Mascota;
import com.example.lab4grupoa.Repository.*;
import com.example.lab4grupoa.Entity.Servicio;
import com.example.lab4grupoa.Repository.CuentaRepository;
import com.example.lab4grupoa.Repository.MascotaRepository;
import com.example.lab4grupoa.Repository.RazaEspecieRepository;
import com.example.lab4grupoa.Repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/edit")
    public String editarMascota(@ModelAttribute("mascota") Mascota mascota, Model model, @RequestParam("id") int id) {

        Optional<Mascota> optMascota = mascotaRepository.findById(id);

        if (optMascota.isPresent()) {
            mascota = optMascota.get();
            model.addAttribute("mascota", mascota);
            model.addAttribute("listaRazas",razaEspecieRepository.findAll());
            model.addAttribute("listaCuentas",cuentaRepository.findAll());
            return "newFrmMascota";
        } else {
            return "redirect:/mascota/listar";
        }
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

    @GetMapping("/delete")
    public String borrar(@RequestParam("id") int idmascota) {
        Optional<Mascota> optional = mascotaRepository.findById(idmascota);
        if (optional.isPresent()) {
            mascotaRepository.deleteById(idmascota);
        }
        return "redirect:/mascota/listar";
    }

    @GetMapping("/delete1")
    public String borrar1(@RequestParam("id") int idmascota, Model model) {
        Optional<Mascota> optional = mascotaRepository.findById(idmascota);
        if (optional.isPresent()) {
            List<ListarMascotasDto> listita = mascotaRepository.listarMascotas();
            listita.remove(idmascota-1);
            model.addAttribute("listaMascotas",listita);
            return "lista";
        }
        return "redirect:/mascota/listar";
    }

    @GetMapping("/servicio/new")
    public String NuevoServicio(Model model){
        model.addAttribute("listaMascotas",mascotaRepository.findAll());
        model.addAttribute("listaCuentas",cuentaRepository.findAll());
        model.addAttribute("listaResponsables",responsableRepository.findAll());
        return "newService";
    }
    @PostMapping("/servicio/save")
    public String GuardarServicio(Servicio servicio,
                                  @RequestParam("fecha") String fecha,
                                  @RequestParam("hora") String hora){

        hora=hora+":00";
        String hora_inicio = fecha + "T" + hora+"Z";
        servicio.setHoraInicio(Instant.parse(hora_inicio));
        servicioRepository.save(servicio);
        return"redirect:/mascota/listar";
    }
}

