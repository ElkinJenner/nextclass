package com.example.demo.model;

import java.math.BigDecimal;
import java.sql.Date;

public class Inscripciones {
    private Long idInscripcion;
    private int idSesion;
    private int idEstudiante;
    private int idAsesoria;
    private Date fechaInscripcion;
    private String tema;
    private int duracion;
    private BigDecimal precio;

    // Constructores
    public Inscripciones() {
    }

    public Inscripciones(Long idInscripcion, int idSesion, int idEstudiante, int idAsesoria, Date fechaInscripcion,
            String tema, int duracion, BigDecimal precio) {
        this.idInscripcion = idInscripcion;
        this.idSesion = idSesion;
        this.idEstudiante = idEstudiante;
        this.idAsesoria = idAsesoria;
        this.fechaInscripcion = fechaInscripcion;
        this.tema = tema;
        this.duracion = duracion;
        this.precio = precio;
    }

    // Getters y setters
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

    public int getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(int idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Date getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}