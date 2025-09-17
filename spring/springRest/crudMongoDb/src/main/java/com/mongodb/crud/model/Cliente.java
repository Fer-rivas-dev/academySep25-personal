package com.mongodb.crud.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@Document(collection = "clientes")
public class Cliente {

    @Id
    private String id;

    private String nombre;

    @Indexed(unique = true)
    private String email;

    private String telefono;

    private LocalDateTime fechaRegistro;

    public Cliente() {
        this.fechaRegistro = LocalDateTime.now();
    }

    public Cliente(String nombre, String email, String telefono) {
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.fechaRegistro = LocalDateTime.now();
    }
    
}