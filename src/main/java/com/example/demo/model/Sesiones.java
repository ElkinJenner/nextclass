package com.example.demo.model;

public class Sesiones {
    //Atributos
    private int idSesion;
    private String nomSesion;
    private String desripcion;
    private int capacidad;
    private double precio;
    //Constructores
    public Sesiones(){}
    public Sesiones(int idSesion, String nomSesion, String desripcion, int capacidad, double precio) {
        this.idSesion = idSesion;
        this.nomSesion = nomSesion;
        this.desripcion = desripcion;
        this.capacidad = capacidad;
        this.precio = precio;
    }
    // Getters y Setters
    public int getIdSesion() {
        return idSesion;
    }
    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }
    public String getNomSesion() {
        return nomSesion;
    }
    public void setNomSesion(String nomSesion) {
        this.nomSesion = nomSesion;
    }
    public String getDesripcion() {
        return desripcion;
    }
    public void setDesripcion(String desripcion) {
        this.desripcion = desripcion;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
