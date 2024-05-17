package com.example.demo.model;
import java.util.Date;
public class Profesores  extends Usuarios{
    // Atributos
    private int idProfesor;
    private String permiso;
    private String profesion;
    private String descripcion;
    //Constructores
    public Profesores(int idUsuario, String tipoUsuario, String nombres, String apellidos, String usuario,
            String contrasena, String email, String fotoPerfil, String codUsuario, int telefono, String pais,
            Date fechaRegistro, int idProfesor, String permiso, String profesion, String descripcion) {
        super(idUsuario, tipoUsuario, nombres, apellidos, usuario, contrasena, email, fotoPerfil, codUsuario, telefono,
                pais, fechaRegistro);
        this.idProfesor = idProfesor;
        this.permiso = permiso;
        this.profesion = profesion;
        this.descripcion = descripcion;
    }
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
