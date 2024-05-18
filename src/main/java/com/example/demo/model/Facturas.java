package com.example.demo.model;

import java.util.Date;

public class Facturas {
    private String numeroDeFactura;
    private Date fechaDeRegistro;
    private String codigo;

    // Constructor vacío
    public Facturas() {}
    // Constructor con parámetros
    public Facturas(String numeroDeFactura, Date fechaDeRegistro, String codigo) {
        this.numeroDeFactura = numeroDeFactura;
        this.fechaDeRegistro = fechaDeRegistro;
        this.codigo = codigo;
    }

    // Getters y Setters
    public String getNumeroDeFactura() {
        return numeroDeFactura;
    }

    public void setNumeroDeFactura(String numeroDeFactura) {
        this.numeroDeFactura = numeroDeFactura;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}