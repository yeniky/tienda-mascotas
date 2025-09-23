package com.example.tienda_mascotas.repository;

import com.example.tienda_mascotas.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;

public interface VentaRepository extends JpaRepository<Venta, Long> {

    // suma de total entre dos fechas
    @Query("SELECT COALESCE(SUM(v.total),0) FROM Venta v WHERE v.fecha BETWEEN :desde AND :hasta")
    long sumaTotalEntre(LocalDate desde, LocalDate hasta);
}
