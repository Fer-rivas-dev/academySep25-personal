package com.ejemplo.pedidos;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "lineas_pedido")
public class LineaPedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;
    
    @Column(name = "producto_id", nullable = false)
    private Long productoId;
    
    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;
    
    @Column(nullable = false)
    private Integer cantidad;
    
    @Column(nullable = false)
    private BigDecimal precio;
    
    protected LineaPedido() {}
    
    public LineaPedido(Pedido pedido, Long productoId, String nombreProducto, int cantidad, BigDecimal precio) {
        this.pedido = pedido;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public BigDecimal getSubtotal() {
        return precio.multiply(BigDecimal.valueOf(cantidad));
    }
    
    // Getters
    public Long getId() { return id; }
    public Long getProductoId() { return productoId; }
    public String getNombreProducto() { return nombreProducto; }
    public Integer getCantidad() { return cantidad; }
    public BigDecimal getPrecio() { return precio; }
}