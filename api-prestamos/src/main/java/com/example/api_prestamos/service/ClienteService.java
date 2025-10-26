package com.example.api_prestamos.service;

import com.example.api_prestamos.model.Cliente;
import com.example.api_prestamos.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public Cliente CrearCliente(Cliente cliente){
        return clienteRepository.save(cliente);
    }
    public List<Cliente> obtenerTodosLosClientes(){
        return clienteRepository.findAll();
    }
    public Optional<Cliente> obtenerClientePorId(Long id){
        return clienteRepository.findById(id);
    }
}
