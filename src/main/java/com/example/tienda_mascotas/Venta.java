package com.example.tienda_mascotas;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "id","fecha","producto","categoria","cantidad","precioUnitario","total","FormaDePago"
})
public class Venta {
    private int id;
    private String fecha;        
    private String producto;    
    private String categoria;    
    private int cantidad;       
    private int precioUnitario;  
    private int total;           
    private String FormaDePago;    

    public Venta(int id, String fecha, String producto, String categoria,
                 int cantidad, int precioUnitario, String FormaDePago) {
        this.id = id;
        this.fecha = fecha;
        this.producto = producto;
        this.categoria = categoria;
        this.cantidad = Math.max(0, cantidad);
        this.precioUnitario = Math.max(0, precioUnitario);
        this.total = this.cantidad * this.precioUnitario; 
        this.FormaDePago = FormaDePago;
    }

    public int getId() { return id; }
    public String getFecha() { return fecha; }
    public String getProducto() { return producto; }
    public String getCategoria() { return categoria; }
    public int getCantidad() { return cantidad; }
    public int getPrecioUnitario() { return precioUnitario; }
    public int getTotal() { return total; }
    public String getFormaDePago() { return FormaDePago; }
}
