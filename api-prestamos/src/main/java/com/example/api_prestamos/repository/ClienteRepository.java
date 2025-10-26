package com.example.api_prestamos.repository;

import java.util.List;
import java.util.Optional;

import com.example.api_prestamos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findAllByBajaFalse();

    Optional<Cliente> findByIdAndBajaFalse(Long id);

}
