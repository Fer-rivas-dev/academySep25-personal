package com.ejemplo.shared;

import com.ejemplo.shared.DomainEvent;
import java.util.List;

public class PedidoCompletado extends DomainEvent {
    
    private final Long pedidoId;
    private final List<LineaPedidoDTO> lineas;
    
    public PedidoCompletado() {
        super();
        this.pedidoId = null;
        this.lineas = null;
    }
    
    public PedidoCompletado(Long pedidoId, List<LineaPedidoDTO> lineas) {
        super();
        this.pedidoId = pedidoId;
        this.lineas = lineas != null ? List.copyOf(lineas) : List.of();
    }
    
    public Long getPedidoId() {
        return pedidoId;
    }
    
    public List<LineaPedidoDTO> getLineas() {
        return lineas;
    }
    
    // Métodos de conveniencia para compatibilidad
    public Long pedidoId() {
        return pedidoId;
    }
    
    public List<LineaPedidoDTO> lineas() {
        return lineas;
    }
    
    public Integer totalLineas() {
        return lineas != null ? lineas.size() : 0;
    }
}