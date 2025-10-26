package com.example.api_prestamos.service;

import com.example.api_prestamos.model.Cliente;
import com.example.api_prestamos.model.Prestamo;
import com.example.api_prestamos.repository.ClienteRepository;
import com.example.api_prestamos.repository.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrestamoService {
    private final PrestamoRepository prestamoRepository;
    private final ClienteRepository clienteRepository;

    public Prestamo crearPrestamo(Long clienteId, Prestamo prestamo){
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliete no encontrado"));
        prestamo.setCliente(cliente);
        return prestamoRepository.save(prestamo);
    }
    public List<Prestamo> obtenerPrestamosPorClientes(Long clienteId){
        return prestamoRepository.findByCliente_Id(clienteId);
    }
}
