package com.alone.view;

import com.alone.model.Automovil;
import com.alone.model.Descuento;
import com.alone.model.Impuesto;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;

        while (continuar) {
            try {
                // Mostrar el menú principal
                String[] options = {"Calcular Impuesto", "Salir"};
                int opcion = JOptionPane.showOptionDialog(null,
                        "Seleccione una opción",
                        "Menú Principal",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        options,
                        options[0]);

                if (opcion == -1 || opcion == 1) {
                    // Salir de la aplicación
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar la aplicación!");
                    continuar = false;
                    continue;
                }

                // Solicitar el valor del vehículo
                String valorVehiculoStr = JOptionPane.showInputDialog("Ingrese el valor del vehículo:");
                double valorVehiculo = Double.parseDouble(valorVehiculoStr);
                if (valorVehiculo <= 0) {
                    JOptionPane.showMessageDialog(null, "El valor debe ser positivo.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // Preguntar si el vehículo es de uso público o no
                int esServicioPublicoOption = JOptionPane.showConfirmDialog(null,
                        "¿El vehículo es de servicio público?",
                        "Servicio Público",
                        JOptionPane.YES_NO_OPTION);
                boolean esServicioPublico = (esServicioPublicoOption == JOptionPane.YES_OPTION);

                // Solicitar porcentaje de descuento por pronto pago
                String porcentajeProntoPagoStr = JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por pronto pago:");
                double porcentajeProntoPago = Double.parseDouble(porcentajeProntoPagoStr);
                if (porcentajeProntoPago < 0) {
                    JOptionPane.showMessageDialog(null, "El porcentaje de descuento por pronto pago no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // Solicitar valor del descuento por servicio público
                String valorServicioPublicoStr = JOptionPane.showInputDialog("Ingrese el valor de descuento por servicio público:");
                double valorServicioPublico = Double.parseDouble(valorServicioPublicoStr);
                if (valorServicioPublico < 0) {
                    JOptionPane.showMessageDialog(null, "El valor de descuento por servicio público no puede ser negativo.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // Solicitar porcentaje de descuento por traslado de cuenta
                String porcentajeTrasladoCuentaStr = JOptionPane.showInputDialog("Ingrese el porcentaje de descuento por traslado de cuenta:");
                double porcentajeTrasladoCuenta = Double.parseDouble(porcentajeTrasladoCuentaStr);
                if (porcentajeTrasladoCuenta <= porcentajeProntoPago) {
                    JOptionPane.showMessageDialog(null, "El porcentaje de descuento por traslado de cuenta debe ser mayor que el porcentaje de descuento por pronto pago.", "Error", JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                // Crear los objetos con la información proporcionada
                Automovil automovil = new Automovil(valorVehiculo, esServicioPublico);
                Descuento descuento = new Descuento(porcentajeProntoPago, valorServicioPublico, porcentajeTrasladoCuenta);
                Impuesto impuesto = new Impuesto(automovil, descuento);

                // Calcular el impuesto y mostrar los resultados
                impuesto.calcularImpuesto();
                JOptionPane.showMessageDialog(null,
                        "Valor base del impuesto: " + impuesto.getValorBase() +
                                "\nValor final después de descuentos: " + impuesto.getValorFinal());

                impuesto.procesarPago();

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
