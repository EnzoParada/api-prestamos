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
        return clienteRepository.findAllByBajaFalse();
    }
    public Optional<Cliente> obtenerClientePorId(Long id){
        return clienteRepository.findByIdAndBajaFalse(id);
    }
    public Optional<Cliente> actualizaCliente(Long id, Cliente clienteDetalles){
        return clienteRepository.findById(id)
                .map(clienteExistente ->{
                    clienteExistente.setNombre(clienteDetalles.getNombre());
                    clienteExistente.setApellido(clienteDetalles.getApellido());
                    clienteExistente.setDni(clienteDetalles.getDni());
                    return clienteRepository.save(clienteExistente);
                });
    }
    public void bajaCliente(Long id){
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);

        if (clienteOpt.isPresent()){
            Cliente cliente = clienteOpt.get();
            cliente.setBaja(true);
            clienteRepository.save(cliente);
        }else{
            throw new RuntimeException("Cliente no encontrado");
        }
    }
}
