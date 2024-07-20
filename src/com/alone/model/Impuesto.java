package com.alone.model;

public class Impuesto {

    private Automovil automovil;
    private Descuento descuento;
    private double valorBase;
    private double valorFinal;

    //Constructor generado

    public Impuesto(Automovil automovil, Descuento descuento) {
        this.automovil = automovil;
        this.descuento = descuento;
        this.valorBase = automovil.getValor();
    }


    //Getters y setters generados


    public Automovil getAutomovil() {
        return automovil;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public double getValorBase() {
        return valorBase;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    // Metodo para calcular el impuesto
    public void calcularImpuesto() {
        double valor = valorBase;

        // Dscuento por pronto pago
        valor -= descuento.calcularDescuentoProntoPago(valor);

        // Deescuento por servicio público
        if (automovil.isServicioPublico()) {
            valor -= descuento.calcularDescuentoServicioPublico(valor);
        }

        // Aplicar descuento por traslado de cuenta
        valor -= descuento.calcularDescuentoTrasladoCuenta(valor);

        valorFinal = valor;
    }

    public void procesarPago() {
        // Aquí se podría implementar el procesamiento del pago
        System.out.println("Pago procesado por: " + valorFinal);
    }
}
