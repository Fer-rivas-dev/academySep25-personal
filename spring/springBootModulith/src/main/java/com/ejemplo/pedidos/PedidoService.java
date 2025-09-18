package com.ejemplo.pedidos;

import com.ejemplo.shared.PedidoCompletado;
import com.ejemplo.shared.PedidoCancelado;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class PedidoService {
    
    private final PedidoRepository pedidoRepository;
    private final ApplicationEventPublisher eventPublisher;
    
    public PedidoService(PedidoRepository pedidoRepository, ApplicationEventPublisher eventPublisher) {
        this.pedidoRepository = pedidoRepository;
        this.eventPublisher = eventPublisher;
    }
    
    @Transactional
    public Pedido crearPedido(Long clienteId) {
        Pedido pedido = new Pedido(clienteId);
        return pedidoRepository.save(pedido);
    }
    
    @Transactional
    public void agregarProducto(Long pedidoId, Long productoId, String nombreProducto, int cantidad, BigDecimal precio) {
        Pedido pedido = pedidoRepository.findById(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + pedidoId));
        
        pedido.agregarLinea(productoId, nombreProducto, cantidad, precio);
        pedidoRepository.save(pedido);
    }
    
    @Transactional
    public void completarPedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.findByIdWithLineas(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + pedidoId));

        pedido.completar();
        pedidoRepository.save(pedido);

        // Publicar evento de dominio
        eventPublisher.publishEvent(new PedidoCompletado(pedido.getId(), pedido.getLineasDTO()));
    }
    
    @Transactional
    public void cancelarPedido(Long pedidoId) {
        Pedido pedido = pedidoRepository.findByIdWithLineas(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + pedidoId));

        pedido.cancelar();
        pedidoRepository.save(pedido);

        // Publicar evento de dominio
        eventPublisher.publishEvent(new PedidoCancelado(pedido.getId(), pedido.getLineasDTO()));
    }
    
    @Transactional(readOnly = true)
    public Pedido obtenerPedido(Long pedidoId) {
        return pedidoRepository.findByIdWithLineas(pedidoId)
            .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado: " + pedidoId));
    }
}