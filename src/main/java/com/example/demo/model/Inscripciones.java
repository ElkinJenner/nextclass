package com.example.demo.model;

public class Inscripciones {
    //Atributos
    private Long idInscripcion;
    private int idSesion;
    private int idHorario;
    private int idEstudiante;
    //Constructores
    public Inscripciones(){}//Constructor Vacio
    //Constructor con parametros
    public Inscripciones(Long idInscripcion, int idSesion, int idHorario, int idEstudiante) {
        this.idInscripcion = idInscripcion;
        this.idSesion = idSesion;
        this.idHorario = idHorario;
        this.idEstudiante = idEstudiante;
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
    public int getIdHorario() {
        return idHorario;
    }
    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }
    public int getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }    
}
