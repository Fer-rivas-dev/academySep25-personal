package com.ejemplo.shared;

import com.ejemplo.shared.DomainEvent;
import java.util.List;

public class PedidoCancelado extends DomainEvent {
    
    private final Long pedidoId;
    private final Integer totalLineas; // Simplificado para evitar problemas de serialización
    
    public PedidoCancelado() {
        super();
        this.pedidoId = null;
        this.totalLineas = null;
    }
    
    public PedidoCancelado(Long pedidoId, List<LineaPedidoDTO> lineas) {
        super();
        this.pedidoId = pedidoId;
        this.totalLineas = lineas != null ? lineas.size() : 0;
    }
    
    public Long getPedidoId() {
        return pedidoId;
    }
    
    public Integer getTotalLineas() {
        return totalLineas;
    }
    
    // Métodos de conveniencia para compatibilidad
    public Long pedidoId() {
        return pedidoId;
    }
    
    public Integer totalLineas() {
        return totalLineas;
    }
}