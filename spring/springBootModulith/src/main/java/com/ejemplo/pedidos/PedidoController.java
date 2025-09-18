package com.ejemplo.pedidos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    
    private final PedidoService pedidoService;
    
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    @PostMapping
    public ResponseEntity<Pedido> crearPedido(@RequestParam Long clienteId) {
        Pedido pedido = pedidoService.crearPedido(clienteId);
        return ResponseEntity.ok(pedido);
    }
    
    @PostMapping("/{pedidoId}/productos")
    public ResponseEntity<Void> agregarProducto(
            @PathVariable Long pedidoId,
            @RequestParam Long productoId,
            @RequestParam String nombreProducto,
            @RequestParam int cantidad,
            @RequestParam BigDecimal precio) {
        
        pedidoService.agregarProducto(pedidoId, productoId, nombreProducto, cantidad, precio);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{pedidoId}/completar")
    public ResponseEntity<Void> completarPedido(@PathVariable Long pedidoId) {
        pedidoService.completarPedido(pedidoId);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/{pedidoId}/cancelar")
    public ResponseEntity<Void> cancelarPedido(@PathVariable Long pedidoId) {
        pedidoService.cancelarPedido(pedidoId);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> obtenerPedido(@PathVariable Long pedidoId) {
        Pedido pedido = pedidoService.obtenerPedido(pedidoId);
        return ResponseEntity.ok(pedido);
    }
}