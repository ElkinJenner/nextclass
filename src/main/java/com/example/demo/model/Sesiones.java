package com.example.demo.model;

public class Sesiones {
    //Atributos
    private int idSesion;
    private String nomSesion;
    //Constructores
    public Sesiones(){}
    public Sesiones(int idSesion, String nomSesion) {
        this.idSesion = idSesion;
        this.nomSesion = nomSesion;
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
    
}
