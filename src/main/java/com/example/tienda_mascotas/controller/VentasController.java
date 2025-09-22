package com.example.tienda_mascotas.controller;

import com.example.tienda_mascotas.dto.VentaDTO;
import com.example.tienda_mascotas.model.Venta;
import com.example.tienda_mascotas.service.VentaService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Year;
import java.time.YearMonth;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {

    private final VentaService service;

    public VentasController(VentaService service) {
        this.service = service;
    }

    // ---------- CRUD ----------
    @GetMapping
    public List<Venta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Venta obtener(@PathVariable long id) {
        return service.obtener(id);
    }

    @PostMapping
    public Venta crear(@Valid @RequestBody VentaDTO dto) {
        return service.crear(dto);
    }

    @PutMapping("/{id}")
    public Venta actualizar(@PathVariable long id, @Valid @RequestBody VentaDTO dto) {
        return service.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public Map<String, Object> eliminar(@PathVariable long id) {
        service.eliminar(id);
        return Map.of("eliminado", true, "id", id);
    }

    // ------ GANANCIAS (día/mes/año y rango) ------
    @GetMapping("/ganancias/dia/{yyyyMMdd}")
    public Map<String, Object> gananciasDia(@PathVariable String yyyyMMdd) {
        LocalDate d = LocalDate.parse(yyyyMMdd);
        return Map.of("dia", d, "gananciaTotal", service.gananciasDia(d));
    }

    @GetMapping("/ganancias/mes/{yyyyMM}")
    public Map<String, Object> gananciasMes(@PathVariable String yyyyMM) {
        YearMonth ym = YearMonth.parse(yyyyMM);
        return Map.of("mes", ym, "gananciaTotal", service.gananciasMes(ym));
    }

    @GetMapping("/ganancias/anio/{yyyy}")
    public Map<String, Object> gananciasAnio(@PathVariable String yyyy) {
        Year y = Year.parse(yyyy);
        return Map.of("anio", y, "gananciaTotal", service.gananciasAnio(y));
    }

    @GetMapping("/ganancias/total")
    public Map<String, Object> gananciasRango(@RequestParam String desde, @RequestParam String hasta) {
        LocalDate d = LocalDate.parse(desde);
        LocalDate h = LocalDate.parse(hasta);
        return Map.of("desde", d, "hasta", h, "gananciaTotal", service.gananciasEntre(d, h));
    }
}
