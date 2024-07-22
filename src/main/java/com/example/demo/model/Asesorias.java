package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Asesorias {
    // Atributos
    private Long idAsesoria;
    private Long idCurso;
    private Long idProfesor;
    private Long idUsuario;
    private String tema;
    private String nomProfesor;
    private String nomCurso;
    private String descripcion;
    private String fotoPerfil;
    private String profesion;
    private String categoriaCurso;
    private LocalTime duracion;
    private BigDecimal precio;
    private int capacidad;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private String nombres;
    private List<Sesiones> sesiones; // Nueva lista de sesiones

    // Getters and Setters

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

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getNomProfesor() {
        return nomProfesor;
    }

    public void setNomProfesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }

    public String getNomCurso() {
        return nomCurso;
    }

    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LocalDate getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(LocalDate fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Nuevos métodos para sesiones
    public List<Sesiones> getSesiones() {
        return sesiones;
    }

    public void setSesiones(List<Sesiones> sesiones) {
        this.sesiones = sesiones;
    }
}