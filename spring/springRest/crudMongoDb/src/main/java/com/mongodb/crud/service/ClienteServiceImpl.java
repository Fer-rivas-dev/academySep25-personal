package com.mongodb.crud.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.crud.model.Cliente;
import com.mongodb.crud.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
	
    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente save(Cliente cliente) {
        if (cliente.getFechaRegistro() == null) {
            cliente.setFechaRegistro(LocalDateTime.now());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(String id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente update(String id, Cliente cliente) {
        Optional<Cliente> existingCliente = clienteRepository.findById(id);
        if (existingCliente.isPresent()) {
            Cliente clienteToUpdate = existingCliente.get();
            clienteToUpdate.setNombre(cliente.getNombre());
            clienteToUpdate.setEmail(cliente.getEmail());
            clienteToUpdate.setTelefono(cliente.getTelefono());
            return clienteRepository.save(clienteToUpdate);
        }
        throw new RuntimeException("Cliente not found with id: " + id);
    }

    @Override
    public void deleteById(String id) {
        clienteRepository.deleteById(id);
    }
}
