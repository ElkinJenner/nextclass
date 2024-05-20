package com.example.demo.model;

public class Cursos {
    //Atributos
    private Long idCurso;
    private Long idCategoriaCurso;
    private String nombreCurso;
    private String imagenCurso;
    //Constructores
    public Cursos(){}
    public Cursos(Long idCurso, Long idCategoriaCurso, String nombreCurso, String imagenCurso) {
        this.idCurso = idCurso;
        this.idCategoriaCurso = idCategoriaCurso;
        this.nombreCurso = nombreCurso;
        this.imagenCurso = imagenCurso;
    }
    public Long getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
    public Long getIdCategoriaCurso() {
        return idCategoriaCurso;
    }
    public void setIdCategoriaCurso(Long idCategoriaCurso) {
        this.idCategoriaCurso = idCategoriaCurso;
    }
    public String getNombreCurso() {
        return nombreCurso;
    }
    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }
    public String getImagenCurso() {
        return imagenCurso;
    }
    public void setImagenCurso(String imagenCurso) {
        this.imagenCurso = imagenCurso;
    }

    
    
}
