package com.example.lab4grupoa.Controller;

import com.example.lab4grupoa.Repository.CuentaRepository;
import com.example.lab4grupoa.Repository.MascotaRepository;
import com.example.lab4grupoa.Repository.RazaEspecieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    CuentaRepository cuentaRepository;

    @Autowired
    MascotaRepository mascotaRepository;

    @Autowired
    RazaEspecieRepository razaEspecieRepository;

    @GetMapping("")
    public String inicio(){
        return "inicio";
    }

}
