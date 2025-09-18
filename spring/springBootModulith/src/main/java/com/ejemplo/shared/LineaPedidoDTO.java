package com.ejemplo.shared;

import java.math.BigDecimal;

/**
 * DTO para representar líneas de pedido en eventos de dominio.
 * Evita dependencias circulares entre módulos.
 */
public class LineaPedidoDTO {
    
    private final Long productoId;
    private final String nombreProducto;
    private final Integer cantidad;
    private final BigDecimal precio;
    
    public LineaPedidoDTO(Long productoId, String nombreProducto, Integer cantidad, BigDecimal precio) {
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public Long getProductoId() { return productoId; }
    public String getNombreProducto() { return nombreProducto; }
    public Integer getCantidad() { return cantidad; }
    public BigDecimal getPrecio() { return precio; }
    
    public BigDecimal getSubtotal() {
        return precio.multiply(BigDecimal.valueOf(cantidad));
    }
}