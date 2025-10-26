package com.example.api_prestamos.controller;

import com.example.api_prestamos.model.Prestamo;
import com.example.api_prestamos.service.PrestamoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PrestamoController {
    private final PrestamoService prestamoService;

    @PostMapping("/clientes/{clienteId}/prestamos")
    public ResponseEntity<Prestamo> crearPrestamo(
            @PathVariable Long clienteId,
            @RequestBody Prestamo prestamo){
        Prestamo nuevoPrestamo = prestamoService.crearPrestamo(clienteId, prestamo);
        return  new ResponseEntity<>(nuevoPrestamo, HttpStatus.CREATED);
    }

    @GetMapping("/clientes/{clienteId}/prestamos")
    public ResponseEntity<List<Prestamo>> obtenerPrestamosPorCliente(@PathVariable Long clienteId){
        List<Prestamo> prestamos = prestamoService.obtenerPrestamosPorClientes(clienteId);
        return new ResponseEntity<>(prestamos, HttpStatus.OK);
    }
}
