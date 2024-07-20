package com.alone.model;

public class Automovil {
    private double valor;
    private boolean esServicioPublico;

    //CONSTRUCTOR AUTOGENERADOR
    public Automovil(double valor, boolean esServicioPublico) {
        this.valor = valor;
        this.esServicioPublico = esServicioPublico;
    }

    //GETTERS Y SETTERS AUTOGENERADOS
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isServicioPublico() {
        return esServicioPublico;
    }

    public void setEsServicioPublico(boolean esServicioPublico) {
        this.esServicioPublico = esServicioPublico;
    }
}
