package com.example.demo.model;

public class Pagos {
    //Atributos
    private Long idPago;
    private int idEstudiante;
    private int idSesion;
    private double monto;
    //Constructores
    public Pagos(){}
   
    public Pagos(Long idPago, int idEstudiante, int idSesion, double monto) {
        this.idPago = idPago;
        this.idEstudiante = idEstudiante;
        this.idSesion = idSesion;
        this.monto = monto;
    }
    //Getters y Setters

    public Long getIdPago() {
        return idPago;
    }

    public void setIdPago(Long idPago) {
        this.idPago = idPago;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public int getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(int idSesion) {
        this.idSesion = idSesion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
