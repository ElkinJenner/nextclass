package com.example.demo.model;

import java.util.Date;

public class Usuarios {
    private Long idUsuario;
    private String tipoUsuario;
    private String nombres;
    private String apellidos;
    private String usuario;
    private String contrasena;
    private String email;
    private String fotoPerfil;
    private String codUsuario;
    private int telefono;
    private Long idPais;
    private String nombrePais; // Nuevo campo
    private String ubicacion;
    private Date fechaRegistro;

    // Constructores
    public Usuarios(){}
    
    public Usuarios(Long idUsuario, String tipoUsuario, String nombres, String apellidos, String usuario,
            String contrasena, String email, String fotoPerfil, String codUsuario, int telefono, Long idPais,
            String nombrePais, String ubicacion, Date fechaRegistro) {
        this.idUsuario = idUsuario;
        this.tipoUsuario = tipoUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
        this.fotoPerfil = fotoPerfil;
        this.codUsuario = codUsuario;
        this.telefono = telefono;
        this.idPais = idPais;
        this.nombrePais = nombrePais;
        this.ubicacion = ubicacion;
        this.fechaRegistro = fechaRegistro;
    }
    

    

    // Getters y Setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}