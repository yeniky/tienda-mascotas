package com.example.tienda_mascotas.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class VentaDTO {

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    @NotBlank(message = "El producto es obligatorio")
    @Size(max = 100)
    private String producto;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 50)
    private String categoria;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad;

    @Min(value = 1, message = "El precio unitario debe ser positivo")
    private int precioUnitario;

    @NotBlank(message = "La forma de pago es obligatoria")
    private String formaDePago;

    // getters & setters
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public String getProducto() { return producto; }
    public void setProducto(String producto) { this.producto = producto; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public int getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(int precioUnitario) { this.precioUnitario = precioUnitario; }
    public String getFormaDePago() { return formaDePago; }
    public void setFormaDePago(String formaDePago) { this.formaDePago = formaDePago; }
}
