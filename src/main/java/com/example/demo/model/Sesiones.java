package com.example.demo.model;
import java.sql.Time;

public class Sesiones {
    //Atributos
    private int idSesion;
    private String nomSesion;
    private int idAsesoria;
    private int idProfesor;
    private String dia;
    private Time horaInicial;
    private Time horaFinal;
    
    /*
     * private String desripcion;
     * private int capacidad;
     * private double precio;
     */
    //Constructores
    public Sesiones(){}
    public Sesiones(int idSesion, String nomSesion, int idAsesoria, int idProfesor, String dia, Time horaInicial,
        Time horaFinal) {
        this.idSesion = idSesion;
        this.nomSesion = nomSesion;
        this.idAsesoria = idAsesoria;
        this.idProfesor = idProfesor;
        this.dia = dia;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
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
    public int getIdAsesoria() {
        return idAsesoria;
    }
    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }
    public int getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }
    public String getDia() {
        return dia;
    }
    public void setDia(String dia) {
        this.dia = dia;
    }
    public Time getHoraInicial() {
        return horaInicial;
    }
    public void setHoraInicial(Time horaInicial) {
        this.horaInicial = horaInicial;
    }
    public Time getHoraFinal() {
        return horaFinal;
    }
    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }
    
}
