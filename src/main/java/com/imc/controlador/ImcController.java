package com.imc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imc.modelo.Proceso;

@Controller
public class ImcController {

    // Equivalente a: private Proceso proceso;
    private final Proceso proceso = new Proceso();

    // Equivalente a: mostrarVistaRegistro()
    @GetMapping("/")
    public String mostrarRegistro() {
        return "registro";           // abre registro.html
    }

    // Equivalente a: calcularIMC() + mostrarMensaje()
    @PostMapping("/calcular")
    public String calcularIMC(
            @RequestParam String nombre,
            @RequestParam String edad,
            @RequestParam String peso,
            @RequestParam String estatura,
            Model model) {

        String resultado = proceso.calcularIMC(nombre, edad, peso, estatura);
        model.addAttribute("resultado", resultado); // envía a la vista
        return "registro";
    }

    // Equivalente a: buscarPersona() + mostrarVistaConsulta()
    @GetMapping("/consulta")
    public String mostrarConsulta() {
        return "consulta";           // abre consulta.html
    }

    @PostMapping("/buscar")
    public String buscarPersona(
            @RequestParam String nombre,
            Model model) {

        String datos = proceso.buscarPorNombre(nombre);
        model.addAttribute("datos", datos);  // envía a la vista
        return "consulta";
    }

    // Equivalente a: mostrarVistaAcerca()
    @GetMapping("/acerca")
    public String mostrarAcerca() {
        return "acerca";             // abre acerca.html
    }
}