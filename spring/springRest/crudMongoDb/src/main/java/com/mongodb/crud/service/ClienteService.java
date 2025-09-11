package com.mongodb.crud.service;

import java.util.List;
import java.util.Optional;

import com.mongodb.crud.model.Cliente;

public interface ClienteService {
	
    Cliente save(Cliente cliente);
    
    List<Cliente> findAll();
    
    Optional<Cliente> findById(String id);
           
    Cliente update(String id, Cliente cliente);
    
    void deleteById(String id);

}
