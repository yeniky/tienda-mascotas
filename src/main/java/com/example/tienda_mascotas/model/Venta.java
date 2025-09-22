package com.example.tienda_mascotas.model;

import jakarta.persistence.*;              // Para @Entity, @Id, @Column...
import jakarta.validation.constraints.*; // Para @NotNull, @Size, @Min...
import java.time.LocalDate;

@Entity
@Table(name = "VENTAS") // Nombre de la tabla en Oracle
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autonumérico en Oracle
    private Long id;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fecha;

    @NotBlank(message = "El producto es obligatorio")
    @Size(max = 100, message = "El nombre del producto no debe superar 100 caracteres")
    private String producto;

    @NotBlank(message = "La categoría es obligatoria")
    @Size(max = 50, message = "La categoría no debe superar 50 caracteres")
    private String categoria;

    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    private int cantidad;

    @Min(value = 1, message = "El precio unitario debe ser positivo")
    @Column(name = "PRECIO_UNITARIO")
    private int precioUnitario;

    @Min(value = 0, message = "El total no puede ser negativo")
    private int total;

    @NotBlank(message = "La forma de pago es obligatoria")
    @Column(name = "FORMA_PAGO")
    private String formaDePago;

    // Calcula el total automáticamente antes de insertar/actualizar
    @PrePersist
    @PreUpdate
    public void calcularTotal() {
        this.total = this.cantidad * this.precioUnitario;
    }

    // --- Getters y Setters ---
    public Long getId() { return id; }
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
    public int getTotal() { return total; }
    public String getFormaDePago() { return formaDePago; }
    public void setFormaDePago(String formaDePago) { this.formaDePago = formaDePago; }
}
