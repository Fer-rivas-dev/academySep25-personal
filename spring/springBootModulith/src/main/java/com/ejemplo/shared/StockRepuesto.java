package com.ejemplo.shared;

import com.ejemplo.shared.DomainEvent;

public class StockRepuesto extends DomainEvent {
    
    private final Long productoId;
    private final String nombreProducto;
    private final int cantidadRepuesta;
    
    public StockRepuesto(Long productoId, String nombreProducto, int cantidadRepuesta) {
        super();
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidadRepuesta = cantidadRepuesta;
    }
    
    public Long productoId() {
        return productoId;
    }
    
    public String nombreProducto() {
        return nombreProducto;
    }
    
    public int cantidadRepuesta() {
        return cantidadRepuesta;
    }
}