package com.example.tienda_mascotas;

public class Ganancia {
    private int gananciaTotal;
    private int cantidadVentas;

    public Ganancia(int gananciaTotal, int cantidadVentas) {
        this.gananciaTotal = gananciaTotal;
        this.cantidadVentas = cantidadVentas;
    }

    public int getGananciaTotal() { return gananciaTotal; }
    public int getCantidadVentas() { return cantidadVentas; }
}
