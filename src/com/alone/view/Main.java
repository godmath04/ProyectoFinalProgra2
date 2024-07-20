package com.alone.view;
import com.alone.model.Automovil;
import com.alone.model.Descuento;
import com.alone.model.Impuesto;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        // Instancia para escanear
        Scanner sc = new Scanner(System.in);

        try{
            //SOLICITAR EL VALOR DEL BEHICULO
            System.out.println("Ingresa l valor del vehiculo: ");
            double valorVehiculo = sc.nextDouble();
            if (valorVehiculo <= 0){
                throw new IllegalArgumentException("El valor debe ser positivo.\n");
            }
            //Preguntar si el vehiculo es de uso público o no

            System.out.println("El vehiculo es de servicio publico? T: para verdad y F: para falso");
            boolean esServicioPublico = sc.nextBoolean();

            //Solicitar personaje de descuento por pronto pago
            System.out.println("Ingrese el porcentaje de descuento por pronto pago: ");
            double porcentajeProntoPago = sc.nextDouble();
            if (porcentajeProntoPago < 0) {
                throw new IllegalArgumentException("El porcentaje de descuento por pronto pago no puede ser negativo.");
            }

            //Solicitar valor del descuento por servicio publico
            System.out.print("Ingrese el valor de descuento por servicio público: ");
            double valorServicioPublico = sc.nextDouble();
            if (valorServicioPublico < 0) {
                throw new IllegalArgumentException("El valor de descuento por servicio público no puede ser negativo.");
            }

            //Solicitar porcentaje de descuento por traslado de cuenta
            System.out.print("Ingrese el porcentaje de descuento por traslado de cuenta: ");
            double porcentajeTrasladoCuenta = sc.nextDouble();
            if (porcentajeTrasladoCuenta <= porcentajeProntoPago) {
                throw new IllegalArgumentException("El porcentaje de descuento por traslado de cuenta debe ser mayor que el porcentaje de descuento por pronto pago.");
            }

            //Objetos que se crean con la información
            Automovil automovil = new Automovil(valorVehiculo, esServicioPublico);
            Descuento descuento = new Descuento(porcentajeProntoPago, valorServicioPublico, porcentajeTrasladoCuenta);
            Impuesto impuesto = new Impuesto(automovil, descuento);

            // Calcular impuesto y procesar pago
            impuesto.calcularImpuesto();
            System.out.println("Valor base del impuesto: " + impuesto.getValorBase());
            System.out.println("Valor final después de descuentos: " + impuesto.getValorFinal());
            impuesto.procesarPago();


        } catch (InputMismatchException e){
            System.out.println("Error de ebtrada invalida. Ingrese los datos de forma correcta ");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }




    }

}
