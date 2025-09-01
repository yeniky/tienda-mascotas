package com.example.tienda_mascotas;

public class Ganancia_actual {
    private int gananciaTotal;
    private int cantidadVentas;

    public Ganancia_actual(int gananciaTotal, int cantidadVentas) {
        this.gananciaTotal = gananciaTotal;
        this.cantidadVentas = cantidadVentas;
    }

    public int getGananciaTotal() { return gananciaTotal; }
    public int getCantidadVentas() { return cantidadVentas; }
}
