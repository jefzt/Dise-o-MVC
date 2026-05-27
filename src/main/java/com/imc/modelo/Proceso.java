package com.imc.modelo;

import java.util.ArrayList;

public class Proceso {

    private final ArrayList<Persona> lista = new ArrayList<>();

    public String calcularIMC(String nombre, String edad, 
                               String peso, String estatura) {
        try {
            if (nombre == null || nombre.trim().isEmpty() ||
                edad == null || edad.trim().isEmpty() ||
                peso == null || peso.trim().isEmpty() ||
                estatura == null || estatura.trim().isEmpty()) {
                return "Debe completar todos los campos";
            }

            int ed = Integer.parseInt(edad);
            if (ed <= 0) return "Edad inválida";

            double pe = Double.parseDouble(peso);
            if (pe <= 0) return "Peso inválido";

            double es = Double.parseDouble(estatura.replace(",", "."));
            if (es <= 0) return "Estatura inválida";

            double imc = pe / (es * es);

            Persona p = new Persona();
            p.setNombre(nombre.trim());
            p.setEdad(ed);
            p.setPeso(pe);
            p.setEstatura(es);
            p.setImc(imc);
            lista.add(p);

            return "IMC calculado correctamente";

        } catch (NumberFormatException e) {
            return "Error en datos (solo números)";
        }
    }

    public String buscarPorNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty())
            return "Debe ingresar un nombre";

        if (lista.isEmpty())
            return "No hay datos registrados";

        for (Persona p : lista) {
            if (p.getNombre().trim().equalsIgnoreCase(nombre.trim())) {

                String clasificacion;
                if (p.getImc() < 18.5) clasificacion = "Bajo peso";
                else if (p.getImc() < 25) clasificacion = "Normal";
                else if (p.getImc() < 30) clasificacion = "Sobrepeso";
                else clasificacion = "Obesidad";

                return "Nombre: " + p.getNombre()
                     + " | Edad: " + p.getEdad()
                     + " | Peso: " + p.getPeso() + " kg"
                     + " | Estatura: " + p.getEstatura() + " m"
                     + " | IMC: " + String.format("%.2f", p.getImc())
                     + " | Clasificación: " + clasificacion;
            }
        }
        return "No se encontró la persona";
    }
}