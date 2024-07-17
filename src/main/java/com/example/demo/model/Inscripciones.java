package com.example.demo.model;

import java.sql.Date;

public class Inscripciones {
    //Atributos
    private Long idInscripcion;
    private int idSesion;
    private int idEstudiante;
    private Date fechaInscripcion;
    //Constructores
    public Inscripciones(){}//Constructor Vacio
    //Constructor con parametros
    public Inscripciones(Long idInscripcion, int idSesion, int idEstudiante, Date fechaInscripcion) {
        this.idInscripcion = idInscripcion;
        this.idSesion = idSesion;
        this.idEstudiante = idEstudiante;
        this.fechaInscripcion = fechaInscripcion;
    }
    //Getters y setters
    public Long getIdInscripcion() {
        return idInscripcion;
    }
    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }
    public int getIdSesion() {
        return idSesion;
    }
    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }
    public int getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }
    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
}
