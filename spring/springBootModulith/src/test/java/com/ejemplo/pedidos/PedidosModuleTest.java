package com.ejemplo.pedidos;

import com.ejemplo.shared.PedidoCompletado;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.PublishedEvents;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
@TestPropertySource(properties = {
    "spring.datasource.url=jdbc:h2:mem:testdb-pedidos",
    "spring.jpa.hibernate.ddl-auto=create-drop"
})
class PedidosModuleTest {
    
    @Autowired
    PedidoService pedidoService;
    
    @Test
    void deberiaCrearPedidoCorrectamente() {
        // Given
        Long clienteId = 1L;
        
        // When
        Pedido pedido = pedidoService.crearPedido(clienteId);
        
        // Then
        assertThat(pedido).isNotNull();
        assertThat(pedido.getClienteId()).isEqualTo(clienteId);
        assertThat(pedido.getEstado()).isEqualTo(EstadoPedido.PENDIENTE);
        assertThat(pedido.getTotal()).isEqualTo(BigDecimal.ZERO);
    }
    
    @Test
    void deberiaAgregarProductoAlPedido() {
        // Given
        Pedido pedido = pedidoService.crearPedido(1L);
        Long productoId = 100L;
        String nombreProducto = "Laptop";
        int cantidad = 2;
        BigDecimal precio = BigDecimal.valueOf(1000);
        
        // When
        pedidoService.agregarProducto(pedido.getId(), productoId, nombreProducto, cantidad, precio);
        
        // Then
        Pedido pedidoActualizado = pedidoService.obtenerPedido(pedido.getId());
        assertThat(pedidoActualizado.getLineas()).hasSize(1);
        assertThat(pedidoActualizado.getTotal()).isEqualByComparingTo(BigDecimal.valueOf(2000));
    }
    
    @Test
    void deberiaPublicarEventoCuandoPedidoSeCompleta(PublishedEvents events) {
        // Given
        Pedido pedido = pedidoService.crearPedido(1L);
        pedidoService.agregarProducto(pedido.getId(), 100L, "Laptop", 1, BigDecimal.valueOf(1000));
        
        // When
        pedidoService.completarPedido(pedido.getId());
        
        // Then
        var eventosCompletado = events.ofType(PedidoCompletado.class)
            .matching(event -> event.pedidoId().equals(pedido.getId()));
        
        assertThat(eventosCompletado).hasSize(1);
        
        // Verificar estado del pedido
        Pedido pedidoCompletado = pedidoService.obtenerPedido(pedido.getId());
        assertThat(pedidoCompletado.getEstado()).isEqualTo(EstadoPedido.COMPLETADO);
    }
}