package com.example.demo.model;

public class Cursos {
    //Atributos
    private int idCurso;
    private String curso;
    private String imagenCurso;
    //Constructores
    public Cursos(){}
    public Cursos(int idCurso, String curso, String imagenCurso) {
        this.idCurso = idCurso;
        this.curso = curso;
        this.imagenCurso = imagenCurso;
    }
    // Getters y Setter
    public int getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getImagenCurso() {
        return imagenCurso;
    }
    public void setImagenCurso(String imagenCurso) {
        this.imagenCurso = imagenCurso;
    }
    
}
