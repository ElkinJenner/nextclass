package com.example.demo.model;
public class Profesores{
    // Atributos
    private int idProfesor;
    private String permiso;
    private String profesion;
    private String descripcion;
    //Constructores
    public Profesores(int idProfesor, String permiso, String profesion, String descripcion) {
        this.idProfesor = idProfesor;
        this.permiso = permiso;
        this.profesion = profesion;
        this.descripcion = descripcion;
    }
    // Getters y Setters
    public int getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
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
