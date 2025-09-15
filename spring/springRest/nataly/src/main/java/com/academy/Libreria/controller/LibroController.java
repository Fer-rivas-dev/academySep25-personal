package com.academy.Libreria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import com.academy.Libreria.model.Libro;
import com.academy.Libreria.repository.LibroRepository;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroRepository libroRepository;

    // Obtener todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    // Obtener un libro por ID
    @GetMapping("/{id}")
    public Optional<Libro> getLibroById(@PathVariable String id) {
        return libroRepository.findById(id);
    }

    // Crear un nuevo libro
    @PostMapping
    public Libro addLibro(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

    // Actualizar un libro existente
    @PutMapping("/{id}")
    public Libro updateLibro(@PathVariable String id, @RequestBody Libro updatedLibro) {
        return libroRepository.findById(id)
                .map(libro -> {
                    libro.setTitulo(updatedLibro.getTitulo());
                    libro.setAutor(updatedLibro.getAutor());
                    libro.setGenero(updatedLibro.getGenero());
                    libro.setAnioPublicacion(updatedLibro.getAnioPublicacion());
                    return libroRepository.save(libro);
                })
                .orElseGet(() -> {
                    updatedLibro.setId(id);
                    return libroRepository.save(updatedLibro);
                });
    }

    // Eliminar un libro por ID
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable String id) {
        libroRepository.deleteById(id);
    }
}

