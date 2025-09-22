package com.example.tienda_mascotas.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ManejadorErrores {

    // 400 - errores de validación (@Valid en DTOs)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validar(MethodArgumentNotValidException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "Datos inválidos");
        body.put("errores", ex.getBindingResult().getFieldErrors().stream()
                .map(fe -> Map.of("campo", fe.getField(), "error", fe.getDefaultMessage()))
                .toList());
        return ResponseEntity.badRequest().body(body);
    }

    // 404 - recurso no encontrado
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<?> noEncontrado(NoSuchElementException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensaje", ex.getMessage()));
    }

    // 500 - fallback genérico
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errorGenerico(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("mensaje", "Error interno", "detalle", ex.getClass().getSimpleName()));
    }
}
