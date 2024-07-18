package com.example.demo.model;

import java.sql.Time;

public class Sesiones {
    private int idSesion;
    private int idAsesoria;
    private int idProfesor;
    private String dia;
    private Time horaInicial;
    private Time horaFinal;
    private String tema;

    // Constructor vacío
    public Sesiones() {
    }

    // Constructor con parámetros
    public Sesiones(int idSesion, int idAsesoria, int idProfesor, String dia, Time horaInicial, Time horaFinal,
            String tema) {
        this.idSesion = idSesion;
        this.idAsesoria = idAsesoria;
        this.idProfesor = idProfesor;
        this.dia = dia;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
        this.tema = tema;
    }

    // Getters y Setters
    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
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

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}