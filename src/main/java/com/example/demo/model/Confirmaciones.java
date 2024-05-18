package com.example.demo.model;

public class Confirmaciones {
    //Atributos
    private int idConfirmacion;
    private String respuesta;
    //Constructor
    public Confirmaciones(){}
    public Confirmaciones(int idConfirmacion, String respuesta) {
        this.idConfirmacion = idConfirmacion;
        this.respuesta = respuesta;
    }
    // Getters y Setters
    
    public int getIdConfirmacion() {
        return idConfirmacion;
    }
    public void setIdConfirmacion(int idConfirmacion) {
        this.idConfirmacion = idConfirmacion;
    }
    public String getRespuesta() {
        return respuesta;
    }
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    
}
