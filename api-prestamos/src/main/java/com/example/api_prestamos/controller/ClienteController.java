package com.example.api_prestamos.controller;

import com.example.api_prestamos.model.Cliente;
import com.example.api_prestamos.repository.ClienteRepository;
import com.example.api_prestamos.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> crearCliete(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.CrearCliente(cliente), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodosLosCLientes(){
        return  new ResponseEntity<>(clienteService.obtenerTodosLosClientes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id){
        return  clienteService.obtenerClientePorId(id)
                .map(cliente -> new ResponseEntity<>(cliente, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(
            @PathVariable Long id,
            @RequestBody Cliente clienteDetalles){

        return clienteService.actualizaCliente(id, clienteDetalles)
                .map(clienteActualizado -> new ResponseEntity<>(clienteActualizado, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> bajaCliente(@PathVariable Long id){
        clienteService.bajaCliente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
