package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profesores {
    @Id
    // Atributos
    private long idProfesor;
    private long idUsuario;
    private String permiso;
    private String profesion;
    private String descripcion;
    // Atributos adicionales para la información de usuarios
    private String fotoPerfil;
    private String nombrePais;

    // Constructores
    public Profesores() {
    }

    public Profesores(long idProfesor, long idUsuario, String permiso, String profesion, String descripcion,
            String fotoPerfil, String nombrePais) {
        this.idProfesor = idProfesor;
        this.idUsuario = idUsuario;
        this.permiso = permiso;
        this.profesion = profesion;
        this.descripcion = descripcion;
        this.fotoPerfil = fotoPerfil;
        this.nombrePais = nombrePais;
    }

    // Getters Y Setters
    public long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(long idProfesor) {
        this.idProfesor = idProfesor;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

}
