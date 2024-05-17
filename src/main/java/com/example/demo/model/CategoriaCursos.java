package com.example.demo.model;

public class CategoriaCursos {
    //Atributos
    private int idCategoriaCurso;
    private String categoriaCurso;
    //Constructores
    public CategoriaCursos(){}
    public CategoriaCursos(int idCategoriaCurso, String categoriaCurso) {
        this.idCategoriaCurso = idCategoriaCurso;
        this.categoriaCurso = categoriaCurso;
    }
    
    // Getters y Setter
    public int getIdCategoriaCurso() {
        return idCategoriaCurso;
    }
    public void setIdCategoriaCurso(int idCategoriaCurso) {
        this.idCategoriaCurso = idCategoriaCurso;
    }
    public String getCategoriaCurso() {
        return categoriaCurso;
    }
    public void setCategoriaCurso(String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }
    
}
