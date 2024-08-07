package com.example.demo.model;

public class Estudiantes{
    // Atributos
    private Long idEstudiante;
    private Long idUsuario;
    private String nivelAcademico;
    private String fotoEstudiante;
    //Constructores
    public Estudiantes(){}
    
    public Estudiantes(Long idEstudiante, Long idUsuario, String nivelAcademico, String fotoEstudiante ) {
        this.idEstudiante = idEstudiante;
        this.idUsuario = idUsuario;
        this.nivelAcademico = nivelAcademico;
        this.fotoEstudiante = fotoEstudiante;
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
    
    public String getFotoEstudiante() {
        return fotoEstudiante;
    }

    public void setFotoEstudiante(String fotoEstudiante) {
        this.fotoEstudiante = fotoEstudiante;
    }
    
}
