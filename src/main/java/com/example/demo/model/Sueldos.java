package com.example.demo.model;

import java.math.BigDecimal;

public class Sueldos{
    // Atributos
    private int idSueldo;
    private int idUsuario;
    private BigDecimal sueldoTotal;

    //Constructor
    public Sueldos(){}
    public Sueldos(int idSueldo, int idUsuario, BigDecimal sueldoTotal) {
        this.idSueldo = idSueldo;
        this.idUsuario = idUsuario;
        this.sueldoTotal = sueldoTotal;
    }

    // Getters y Setters
    public int getIdSueldo() {
        return idSueldo;
    }

    public void setIdSueldo(int idSueldo) {
        this.idSueldo = idSueldo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(BigDecimal sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }
}