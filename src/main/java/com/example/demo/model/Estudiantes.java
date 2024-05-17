package com.example.demo.model;

import java.util.Date;

public class Estudiantes extends Usuarios {
    // Atributos
    private int idEstudiante;
    private String nivelAcademico;
    //Constructores
    public Estudiantes(){}
    public Estudiantes(int idUsuario, String tipoUsuario, String nombres, String apellidos, String usuario,
            String contrasena, String email, String fotoPerfil, String codUsuario, int telefono, String pais,
            Date fechaRegistro, int idEstudiante, String nivelAcademico) {
        super(idUsuario, tipoUsuario, nombres, apellidos, usuario, contrasena, email, fotoPerfil, codUsuario, telefono,
                pais, fechaRegistro);
        this.idEstudiante = idEstudiante;
        this.nivelAcademico = nivelAcademico;
    }
    public Estudiantes(int idEstudiante, String nivelAcademico) {
        this.idEstudiante = idEstudiante;
        this.nivelAcademico = nivelAcademico;
    }
    // Getters y Setters
    public int getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public String getNivelAcademico() {
        return nivelAcademico;
    }
    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
    

}
