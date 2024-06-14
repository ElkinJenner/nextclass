package com.example.demo.model;

import java.math.BigDecimal;

public class Recibos {
    private Long idRecibo;
    private Long idPago;
    private Long idProfesor;
    private Long idAsesoria;
    private Long idEstudiante;
    private String nombreProfesor;
    private String nombreEstudiante;
    private String curso;
    private BigDecimal precio;
    private String tema;
    private String descripcion;
    //Constructores
    public Recibos(){}
    
    public Recibos(Long idRecibo, Long idPago, Long idProfesor, Long idAsesoria, Long idEstudiante,
            String nombreProfesor, String nombreEstudiante, String curso, BigDecimal precio, String tema,
            String descripcion) {
        this.idRecibo = idRecibo;
        this.idPago = idPago;
        this.idProfesor = idProfesor;
        this.idAsesoria = idAsesoria;
        this.idEstudiante = idEstudiante;
        this.nombreProfesor = nombreProfesor;
        this.nombreEstudiante = nombreEstudiante;
        this.curso = curso;
        this.precio = precio;
        this.tema = tema;
        this.descripcion = descripcion;
    }
    // Getters and Setters
    public Long getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(Long idRecibo) {
        this.idRecibo = idRecibo;
    }

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Long getIdAsesoria() {
        return idAsesoria;
    }

    public void setIdAsesoria(Long idAsesoria) {
        this.idAsesoria = idAsesoria;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
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
}