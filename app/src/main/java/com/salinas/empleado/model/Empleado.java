package com.salinas.empleado.model;

public class Empleado {
    private String nombre;
    private int tipoEmpleado;
    private int horasTrabajadas;
    private double cuotaPorHora;

    public Empleado(String nombre, int tipoEmpleado, int horasTrabajadas, double cuotaPorHora) {
        this.nombre = nombre;
        this.tipoEmpleado = tipoEmpleado;
        this.horasTrabajadas = horasTrabajadas;
        this.cuotaPorHora = cuotaPorHora;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTipoEmpleado() {
        return tipoEmpleado;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getCuotaPorHora() {
        return cuotaPorHora;
    }

    public double calcularSueldo() {
        double sueldo = 0;
        if (horasTrabajadas > 40 && tipoEmpleado == 1) {
            sueldo = (40 * cuotaPorHora) + ((horasTrabajadas - 40) * cuotaPorHora * 1.5);
        } else {
            switch (tipoEmpleado) {
                case 1:
                    sueldo = horasTrabajadas * cuotaPorHora;
                    break;
                case 2:
                    sueldo = horasTrabajadas * cuotaPorHora * 2;
                    break;
                case 3:
                    sueldo = horasTrabajadas * cuotaPorHora * 2.5;
                    break;
                case 4:
                    sueldo = horasTrabajadas * cuotaPorHora * 3;
                    break;
            }
        }
        return sueldo;
    }
}
