package com.example.demo.model;

public class Pagos {
    //Atributos
    private int idPago;
    private double monto;
    private double descuento;
    //Constructores
    public Pagos(){}
    public Pagos(int idPago, double monto, double descuento) {
        this.idPago = idPago;
        this.monto = monto;
        this.descuento = descuento;
    }
    //Getters y Setters
    public int getIdPago() {
        return idPago;
    }
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
}
