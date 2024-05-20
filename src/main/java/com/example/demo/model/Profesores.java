package com.example.demo.model;
public class Profesores{
    // Atributos
    private long idProfesor;
    private long idUsuario;
    private String permiso;
    private String profesion;
    private String descripcion;
    //Constru
    public Profesores(){}
    public Profesores(long idProfesor, long idUsuario, String permiso, String profesion, String descripcion) {
        this.idProfesor = idProfesor;
        this.idUsuario = idUsuario;
        this.permiso = permiso;
        this.profesion = profesion;
        this.descripcion = descripcion;
    }
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
    
    
}
