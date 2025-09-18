package com.ejemplo.pedidos;

import com.ejemplo.shared.LineaPedidoDTO;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "cliente_id", nullable = false)
    private Long clienteId;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EstadoPedido estado;
    
    @Column(nullable = false)
    private BigDecimal total;
    
    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LineaPedido> lineas = new ArrayList<>();
    
    protected Pedido() {}
    
    public Pedido(Long clienteId) {
        this.clienteId = clienteId;
        this.estado = EstadoPedido.PENDIENTE;
        this.total = BigDecimal.ZERO;
        this.fechaCreacion = LocalDateTime.now();
    }
    
    public void agregarLinea(Long productoId, String nombreProducto, int cantidad, BigDecimal precio) {
        LineaPedido linea = new LineaPedido(this, productoId, nombreProducto, cantidad, precio);
        this.lineas.add(linea);
        this.total = this.total.add(precio.multiply(BigDecimal.valueOf(cantidad)));
    }
    
    public void completar() {
        if (this.estado != EstadoPedido.PENDIENTE) {
            throw new IllegalStateException("Solo se pueden completar pedidos pendientes");
        }
        this.estado = EstadoPedido.COMPLETADO;
    }
    
    public void cancelar() {
        if (this.estado == EstadoPedido.COMPLETADO) {
            throw new IllegalStateException("No se puede cancelar un pedido completado");
        }
        this.estado = EstadoPedido.CANCELADO;
    }
    
    // Getters
    public Long getId() { return id; }
    public Long getClienteId() { return clienteId; }
    public EstadoPedido getEstado() { return estado; }
    public BigDecimal getTotal() { return total; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public List<LineaPedido> getLineas() { return new ArrayList<>(lineas); }
    
    public List<LineaPedidoDTO> getLineasDTO() {
        return lineas.stream()
            .map(linea -> new LineaPedidoDTO(
                linea.getProductoId(),
                linea.getNombreProducto(),
                linea.getCantidad(),
                linea.getPrecio()
            ))
            .toList();
    }
}