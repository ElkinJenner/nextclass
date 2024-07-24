package com.example.demo.model;

public class Estudiantes{
    // Atributos
    private Long idEstudiante;
    private Long idUsuario;
    private String nivelAcademico;
    // Atributos adicionales para mapear y realizar JOINS
    private String fotoPerfil;
    //Constructores
    public Estudiantes(){}
    
    public Estudiantes(Long idEstudiante, Long idUsuario, String nivelAcademico, String fotoPerfil ) {
        this.idEstudiante = idEstudiante;
        this.idUsuario = idUsuario;
        this.nivelAcademico = nivelAcademico;
        this.fotoPerfil = fotoPerfil;
    }

    public Long getIdEstudiante() {
        return idEstudiante;
    }
    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNivelAcademico() {
        return nivelAcademico;
    }
    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
    
    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }
    
}
