package com.example.demo.model;

public class Asesorias {
    //Atributos
    private Long idAsesoria;
    private Long idCurso;
    private Long idProfesor;
    private String tema;
    private String descripcionC;
    private String descripcionL;
    private Long capacidad;
    private double precio;
    //Constructores
    public Asesorias(){}
    public Asesorias(Long idAsesoria, Long idCurso, Long idProfesor, String tema, String descripcionC,
            String descripcionL, Long capacidad, double precio) {
        this.idAsesoria = idAsesoria;
        this.idCurso = idCurso;
        this.idProfesor = idProfesor;
        this.tema = tema;
        this.descripcionC = descripcionC;
        this.descripcionL = descripcionL;
        this.capacidad = capacidad;
        this.precio = precio;
    }
    public Long getIdAsesoria() {
        return idAsesoria;
    }
    public void setIdAsesoria(Long idAsesoria) {
        this.idAsesoria = idAsesoria;
    }
    public Long getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
    public Long getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getDescripcionC() {
        return descripcionC;
    }
    public void setDescripcionC(String descripcionC) {
        this.descripcionC = descripcionC;
    }
    public String getDescripcionL() {
        return descripcionL;
    }
    public void setDescripcionL(String descripcionL) {
        this.descripcionL = descripcionL;
    }
    public Long getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(Long capacidad) {
        this.capacidad = capacidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
}
