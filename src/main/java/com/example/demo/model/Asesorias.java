package com.example.demo.model;

public class Asesorias {
    //Atributos
    private int idAsesoria;
    private String tema;
    private String descripcion;
    private String referente;
    private double precio;
    private int sesiones;
    //Constructores
    public Asesorias(){}
    public Asesorias(int idAsesoria, String tema, String descripcion, String referente, double precio, int sesiones) {
        this.idAsesoria = idAsesoria;
        this.tema = tema;
        this.descripcion = descripcion;
        this.referente = referente;
        this.precio = precio;
        this.sesiones = sesiones;
    }
    // Getters y Setter
    public int getIdAsesoria() {
        return idAsesoria;
    }
    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getReferente() {
        return referente;
    }
    public void setReferente(String referente) {
        this.referente = referente;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getSesiones() {
        return sesiones;
    }
    public void setSesiones(int sesiones) {
        this.sesiones = sesiones;
    }
}
