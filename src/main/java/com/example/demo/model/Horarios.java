package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Horarios {

    private LocalDate fecha;
    private LocalTime horaInicial;
    private LocalTime horaFinal;
    
    // Constructores
    public Horarios(){}
    
    public Horarios(LocalDate fecha, LocalTime horaInicial, LocalTime horaFinal) {
        this.fecha = fecha;
        this.horaInicial = horaInicial;
        this.horaFinal = horaFinal;
    }

    // Getters y Setters
    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraInicial() {
        return horaInicial;
    }

    public void setHoraInicial(LocalTime horaInicial) {
        this.horaInicial = horaInicial;
    }

    public LocalTime getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(LocalTime horaFinal) {
        this.horaFinal = horaFinal;
    }
}
