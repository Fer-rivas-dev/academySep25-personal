package com.ejemplo.inventario;

import com.ejemplo.shared.StockBajo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.PublishedEvents;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@ApplicationModuleTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb-inventario",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
class InventarioModuleTest {
    
    @Autowired
    InventarioService inventarioService;
    
    @Test
    void deberiaCrearProductoCorrectamente() {
        // Given
        String nombre = "Laptop";
        String sku = "LAP001";
        int stockActual = 10;
        int stockMinimo = 5;
        
        // When
        Producto producto = inventarioService.crearProducto(nombre, sku, stockActual, stockMinimo);
        
        // Then
        assertThat(producto).isNotNull();
        assertThat(producto.getNombre()).isEqualTo(nombre);
        assertThat(producto.getSku()).isEqualTo(sku);
        assertThat(producto.getStockActual()).isEqualTo(stockActual);
        assertThat(producto.getStockMinimo()).isEqualTo(stockMinimo);
        assertThat(producto.necesitaReposicion()).isFalse();
    }
    
    @Test
    void deberiaReducirStockCorrectamente() {
        // Given
        Producto producto = inventarioService.crearProducto("Mouse", "MOU001", 15, 5);
        int cantidadAReducir = 3;
        
        // When
        inventarioService.reducirStock(producto.getId(), cantidadAReducir);
        
        // Then
        Producto productoActualizado = inventarioService.obtenerProducto(producto.getId());
        assertThat(productoActualizado.getStockActual()).isEqualTo(12);
    }
    
    @Test
    void deberiaPublicarEventoStockBajoCuandoStockEsBajo(PublishedEvents events) {
        // Given
        Producto producto = inventarioService.crearProducto("Teclado", "TEC001", 6, 5);
        
        // When - Reducir stock hasta el mínimo
        inventarioService.reducirStock(producto.getId(), 2);
        
        // Then
        var eventosStockBajo = events.ofType(StockBajo.class)
            .matching(event -> event.productoId().equals(producto.getId()));
        
        assertThat(eventosStockBajo).hasSize(1);
        
        StockBajo evento = eventosStockBajo.iterator().next();
        assertThat(evento.stockActual()).isEqualTo(4);
        assertThat(evento.stockMinimo()).isEqualTo(5);
    }
    
    @Test
    void deberiaLanzarExcepcionCuandoStockInsuficiente() {
        // Given
        Producto producto = inventarioService.crearProducto("Monitor", "MON001", 3, 2);
        
        // When & Then
        assertThatThrownBy(() -> inventarioService.reducirStock(producto.getId(), 5))
            .isInstanceOf(IllegalStateException.class)
            .hasMessageContaining("Stock insuficiente");
    }
    
    @Test
    void deberiaVerificarDisponibilidadCorrectamente() {
        // Given
        Producto producto = inventarioService.crearProducto("Altavoz", "ALT001", 8, 3);
        
        // When & Then
        assertThat(inventarioService.verificarDisponibilidad(producto.getId(), 5)).isTrue();
        assertThat(inventarioService.verificarDisponibilidad(producto.getId(), 10)).isFalse();
    }
}