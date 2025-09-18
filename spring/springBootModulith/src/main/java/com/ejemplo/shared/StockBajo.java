package com.ejemplo.shared;

import com.ejemplo.shared.DomainEvent;

public class StockBajo extends DomainEvent {
    
    private final Long productoId;
    private final String nombreProducto;
    private final int stockActual;
    private final int stockMinimo;
    
    public StockBajo(Long productoId, String nombreProducto, int stockActual, int stockMinimo) {
        super();
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }
    
    public Long productoId() {
        return productoId;
    }
    
    public String nombreProducto() {
        return nombreProducto;
    }
    
    public int stockActual() {
        return stockActual;
    }
    
    public int stockMinimo() {
        return stockMinimo;
    }
}