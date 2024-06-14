package com.example.demo.model;

public class Asesorias {
    //Atributos
    private Long idAsesoria;
    private Long idCurso;
    private Long idProfesor;
    private String tema;
    private String nomProfesor;
    private String nomCurso;
    private String descripcion;
    //Constructores
    public Asesorias(){}
    public Asesorias(Long idAsesoria, Long idCurso, Long idProfesor, String tema, String nomProfesor, String nomCurso,
            String descripcion) {
        this.idAsesoria = idAsesoria;
        this.idCurso = idCurso;
        this.idProfesor = idProfesor;
        this.tema = tema;
        this.nomProfesor = nomProfesor;
        this.nomCurso = nomCurso;
        this.descripcion = descripcion;
    }
    // Getters y setters
    public Long getIdAsesoria() {
        return idAsesoria;
    }
    public void setIdAsesoria(Long idAsesoria) {
        this.idAsesoria = idAsesoria;
    }
    public Long getIdCurso() {
        return idCurso;
    }
    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }
    public Long getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public String getNomprofesor() {
        return nomProfesor;
    }
    public void setNomprofesor(String nomProfesor) {
        this.nomProfesor = nomProfesor;
    }
    public String getNomCurso() {
        return nomCurso;
    }
    public void setNomCurso(String nomCurso) {
        this.nomCurso = nomCurso;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
