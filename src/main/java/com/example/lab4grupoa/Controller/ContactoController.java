/*package com.example.lab4grupoa.Controller;

import com.example.lab4grupoa.Entity.Cuenta;
import com.example.lab4grupoa.Repository.CuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
public class ContactoController {
    @Autowired
    CuentaRepository CuentaRepository;

    @GetMapping(value = {"", "/", "list"})
    public String listarCuentas(Model model) {
        List<Cuenta> lista = CuentaRepository.findAll();
        model.addAttribute("contactoList", lista);
        return "contacto/list";
    }

    @RequestMapping("/contacto")
    @GetMapping("/new")
    public String nuevaCuentaFrm() {
        return "conatcto/newFrm";
    }

    @PostMapping("/save")
    public String guardarCuenta(Cuenta cuenta,
                                @RequestParam("telStr") String telStr,
                                @RequestParam("correoStr") String correoStr
                                      ) {

            CuentaRepository.save(cuenta);
            return "redirect:/cuenta";
        }

        @GetMapping("/editar")

            public String editarCuenta(Model model,
            @RequestParam("id") int id) {

                Optional<Cuenta> optCuenta = CuentaRepository.findById(id);

                if (optCuenta.isPresent()) {
                    Cuenta cuenta = optCuenta.get();
                    model.addAttribute("cuenta", cuenta);
                    return "contacto/editFrm";
                } else {
                    return "redirect:/contacto/lista";
                }
            }


        }
    }
}*/
