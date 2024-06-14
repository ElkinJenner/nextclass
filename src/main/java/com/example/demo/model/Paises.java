package com.example.demo.model;

public class Paises {
    // Atributos
    private Long idPais;
    private String pais;
    // Constructores
    public Paises(){}
    public Paises(Long idPais, String pais) {
        this.idPais = idPais;
        this.pais = pais;
    }
    // Getters y Setters
    public Long getIdPais() {
        return idPais;
    }
    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    @Override
    public String toString() {
        return "Paises{" +
                "idPais=" + idPais +
                ", pais='" + pais + '\'' +
                '}';
    }
    

}
