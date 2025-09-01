package com.example.tienda_mascotas;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class VentasController {

    private final List<Venta> ventas = new ArrayList<>();

    public VentasController() {
        ventas.add(new Venta(1, "2025-08-01", "Alimento Acana 11,5kg", "Alimento", 2, 68990, "Débito"));
        ventas.add(new Venta(2, "2025-08-01", "Shampoo Piel Sensible", "Higiene", 1, 8990, "Crédito"));
        ventas.add(new Venta(3, "2025-08-02", "Juguete Pelota", "Accesorio", 3, 2990, "Efectivo"));
        ventas.add(new Venta(4, "2025-08-03", "Arnés Talla L", "Accesorio", 1, 14990, "Crédito"));
        ventas.add(new Venta(5, "2025-08-10", "Arena Sanitaria 18kg", "Higiene", 1, 14990, "Débito"));
        ventas.add(new Venta(6, "2025-08-12", "Snack Dentales", "Alimento", 4, 1990, "Efectivo"));
        ventas.add(new Venta(7, "2025-09-01", "Cama Mediana Rosa", "Accesorio", 1, 24990, "Crédito"));
        ventas.add(new Venta(8, "2025-09-01", "Alimento Orijen 5kg", "Alimento", 2, 59990, "Débito"));
        ventas.add(new Venta(9, "2025-09-02", "Correa 5 Mts", "Accesorio", 1, 10990, "Débito"));
        ventas.add(new Venta(10,"2025-09-02", "Snack Natural Pollo", "Alimento", 6, 1290, "Efectivo"));
    }
//Para que traiga listado de todas las ventas
    @GetMapping({"/ventas", "/ventas/"})
    public List<Venta> getVentas() {
        return ventas;
    }

//Para buscar por ID
    @GetMapping("/ventas/{id}")
    public Venta getVentaById(@PathVariable int id) {
        for (Venta v : ventas) {
            if (v.getId() == id) return v;
        }
        return null;
    }

//La suma de todas las ventas
    @GetMapping("/ventas/ganancias/total")
    public Ganancia_actual gananciasTotal() {
        int total = 0;
        for (Venta v : ventas) {
            total += v.getTotal();
        }
        return new Ganancia_actual(total, ventas.size());
    }


}
