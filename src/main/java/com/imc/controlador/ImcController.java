package com.imc.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imc.modelo.Proceso;

@Controller
public class ImcController {

    
    private final Proceso proceso = new Proceso();

    
    @GetMapping("/")
    public String mostrarRegistro() {
        return "registro";           
    }

    
    @PostMapping("/calcular")
    public String calcularIMC(
            @RequestParam String nombre,
            @RequestParam String edad,
            @RequestParam String peso,
            @RequestParam String estatura,
            Model model) {

        String resultado = proceso.calcularIMC(nombre, edad, peso, estatura);
        model.addAttribute("resultado", resultado); 
        return "registro";
    }

   
    @GetMapping("/consulta")
    public String mostrarConsulta() {
        return "consulta";          
    }

    @PostMapping("/buscar")
    public String buscarPersona(
            @RequestParam String nombre,
            Model model) {

        String datos = proceso.buscarPorNombre(nombre);
        model.addAttribute("datos", datos);  
        return "consulta";
    }

    
    @GetMapping("/acerca")
    public String mostrarAcerca() {
        return "acerca";            
    }
}