package com.example.tienda_mascotas.service;

import com.example.tienda_mascotas.dto.VentaDTO;
import com.example.tienda_mascotas.model.Venta;
import com.example.tienda_mascotas.repository.VentaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class VentaService {

    private final VentaRepository repo;

    public VentaService(VentaRepository repo) {
        this.repo = repo;
    }

    // --- CRUD ---
    public List<Venta> listar() {
        return repo.findAll();
    }

    public Venta obtener(long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Venta no encontrada"));
    }

    public Venta crear(VentaDTO dto) {
        Venta v = map(dto, new Venta());
        return repo.save(v); // @PrePersist calculará el total
    }

    public Venta actualizar(long id, VentaDTO dto) {
        Venta existente = obtener(id);
        Venta actualizado = map(dto, existente);
        return repo.save(actualizado); // @PreUpdate calcula total
    }

    public void eliminar(long id) {
        repo.deleteById(id);
    }

    // Mapear DTO -> Entity
    private Venta map(VentaDTO d, Venta v) {
        v.setFecha(d.getFecha());
        v.setProducto(d.getProducto());
        v.setCategoria(d.getCategoria());
        v.setCantidad(d.getCantidad());
        v.setPrecioUnitario(d.getPrecioUnitario());
        v.setFormaDePago(d.getFormaDePago());
        return v;
    }

    // --- Ganancias ---
    public long gananciasEntre(LocalDate desde, LocalDate hasta) {
        return repo.sumaTotalEntre(desde, hasta);
    }

    public long gananciasDia(LocalDate dia) {
        return gananciasEntre(dia, dia);
    }

    public long gananciasMes(YearMonth ym) {
        return gananciasEntre(ym.atDay(1), ym.atEndOfMonth());
    }

    public long gananciasAnio(Year y) {
        return gananciasEntre(y.atDay(1), y.atMonth(12).atEndOfMonth());
    }
}
