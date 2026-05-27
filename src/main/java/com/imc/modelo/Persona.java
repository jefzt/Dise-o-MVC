package com.imc.modelo;

public class Persona {

    private String nombre;
    private int edad;
    private double peso;
    private double estatura;
    private double imc;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public double getEstatura() { return estatura; }
    public void setEstatura(double estatura) { this.estatura = estatura; }

    public double getImc() { return imc; }
    public void setImc(double imc) { this.imc = imc; }
}