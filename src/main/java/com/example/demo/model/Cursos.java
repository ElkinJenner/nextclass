package com.example.demo.model;

public class Cursos {
    private Long idCurso;
    private Long idCategoriaCurso;
    private String nombreCurso;
    private String imagenCurso;
    private String categoriaCurso;

    // Getters y setters
    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
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

    public String getCategoriaCurso() {
        return categoriaCurso;
    }

    public void setCategoriaCurso(String categoriaCurso) {
        this.categoriaCurso = categoriaCurso;
    }

    public Long getIdCategoriaCurso() {
        return idCategoriaCurso;
    }

    public void setIdCategoriaCurso(Long idCategoriaCurso) {
        this.idCategoriaCurso = idCategoriaCurso;
    }
    
    @Override
    public String toString() {
        return "Cursos{" +
                "idCurso=" + idCurso +
                ", curso='" + nombreCurso + '\'' +
                '}';
    }
}