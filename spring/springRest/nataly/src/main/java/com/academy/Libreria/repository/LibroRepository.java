package com.academy.Libreria.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.academy.Libreria.model.Libro; // Asegúrate de tener tu clase Libro en este paquete

@Repository
public interface LibroRepository extends MongoRepository<Libro, String> {
    // Aquí puedes agregar métodos personalizados si los necesitas, por ejemplo:
    // List<Libro> findByAutor(String autor);
}
