package com.alone.model;

public class Descuento {
    private double porcentajeProntoPago;
    private double valorServicioPublico;
    private double porcentajeTrasladoCuenta;

    // CONSTRUCTOR AUTOGENERADO
    public Descuento(double porcentajeProntoPago, double valorServicioPublico, double porcentajeTrasladoCuenta) {
        this.porcentajeProntoPago = porcentajeProntoPago;
        this.valorServicioPublico = valorServicioPublico;
        this.porcentajeTrasladoCuenta = porcentajeTrasladoCuenta;
    }

    //GETTERS Y SETTERS AUTOGENERADOS


    public double getPorcentajeProntoPago() {
        return porcentajeProntoPago;
    }

    public void setPorcentajeProntoPago(double porcentajeProntoPago) {
        this.porcentajeProntoPago = porcentajeProntoPago;
    }

    public double getValorServicioPublico() {
        return valorServicioPublico;
    }

    public void setValorServicioPublico(double valorServicioPublico) {
        this.valorServicioPublico = valorServicioPublico;
    }

    public double getPorcentajeTrasladoCuenta() {
        return porcentajeTrasladoCuenta;
    }

    public void setPorcentajeTrasladoCuenta(double porcentajeTrasladoCuenta) {
        this.porcentajeTrasladoCuenta = porcentajeTrasladoCuenta;
    }

    //Metodos propios
    //Calcular el descuento pronto pago
    public double calcularDescuentoProntoPago(double valor) {
        return valor * (porcentajeProntoPago / 100);
    }
    //Calcular el descuento servicio public

    public double calcularDescuentoServicioPublico(double valor) {
        return valorServicioPublico;
    }

    //Calcular el descuento traslado cuenta

    public double calcularDescuentoTrasladoCuenta(double valor) {
        return valor * (porcentajeTrasladoCuenta / 100);
    }



}
