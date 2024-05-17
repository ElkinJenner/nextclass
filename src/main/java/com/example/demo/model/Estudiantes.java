package com.example.demo.model;

public class Estudiantes{
    // Atributos
    private int idEstudiante;
    private String nivelAcademico;
    //Constructores
    public Estudiantes(){}
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
