package com.ejemplo.demo;

import com.ejemplo.inventario.InventarioService;
import com.ejemplo.pedidos.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Controller específico para demostraciones reproducibles de Spring Modulith.
 * Proporciona endpoints predefinidos que siempre producen los mismos resultados.
 */
@RestController
@RequestMapping("/api/demo")
public class DemoController {
    
    private final PedidoService pedidoService;
    private final InventarioService inventarioService;
    
    public DemoController(PedidoService pedidoService, InventarioService inventarioService) {
        this.pedidoService = pedidoService;
        this.inventarioService = inventarioService;
    }
    
    /**
     * Demo 1: Crear un pedido completo paso a paso
     */
    @PostMapping("/scenario-1-pedido-completo")
    public ResponseEntity<Map<String, Object>> demoScenario1() {
        System.out.println("\n🎬 === DEMO SCENARIO 1: PEDIDO COMPLETO ===");
        
        // Crear nuevo pedido
        var pedido = pedidoService.crearPedido(200L); // Cliente demo
        System.out.println("✅ Pedido creado: ID " + pedido.getId());
        
        // Agregar productos
        pedidoService.agregarProducto(pedido.getId(), 3L, "Teclado Mecánico", 2, new BigDecimal("89.99"));
        pedidoService.agregarProducto(pedido.getId(), 4L, "Monitor 4K", 1, new BigDecimal("399.99"));
        System.out.println("📦 Productos agregados al pedido");
        
        // Completar pedido (esto disparará eventos)
        pedidoService.completarPedido(pedido.getId());
        System.out.println("🚀 Pedido completado - Eventos disparados automáticamente");
        
        return ResponseEntity.ok(Map.of(
            "scenario", "Pedido Completo",
            "pedidoId", pedido.getId(),
            "clienteId", 200L,
            "productos", "Teclado Mecánico (2x), Monitor 4K (1x)",
            "eventos", "PedidoCompletado → Reducción automática de stock"
        ));
    }
    
    /**
     * Demo 2: Cancelar el pedido pre-creado
     */
    @PostMapping("/scenario-2-cancelar-pedido")
    public ResponseEntity<Map<String, Object>> demoScenario2() {
        System.out.println("\n🎬 === DEMO SCENARIO 2: CANCELACIÓN DE PEDIDO ===");
        
        // Usar el pedido pre-creado (ID 1)
        Long pedidoId = 1L;
        
        // Cancelar pedido
        pedidoService.cancelarPedido(pedidoId);
        System.out.println("❌ Pedido " + pedidoId + " cancelado - Evento disparado");
        
        return ResponseEntity.ok(Map.of(
            "scenario", "Cancelación de Pedido",
            "pedidoId", pedidoId,
            "accion", "Pedido cancelado",
            "eventos", "PedidoCancelado → Sin acción de inventario requerida"
        ));
    }
    
    /**
     * Demo 3: Provocar stock bajo
     */
    @PostMapping("/scenario-3-stock-bajo")
    public ResponseEntity<Map<String, Object>> demoScenario3() {
        System.out.println("\n🎬 === DEMO SCENARIO 3: ALERTA DE STOCK BAJO ===");
        
        // Crear pedido grande que agote stock
        var pedido = pedidoService.crearPedido(300L);
        
        // Agregar muchas webcams para provocar stock bajo
        pedidoService.agregarProducto(pedido.getId(), 5L, "Webcam HD", 10, new BigDecimal("59.99"));
        System.out.println("📦 Agregadas 10 webcams al pedido");
        
        // Completar - esto reducirá stock de 12 a 2 (por debajo del mínimo de 3)
        pedidoService.completarPedido(pedido.getId());
        System.out.println("⚠️ Stock bajo detectado automáticamente");
        
        return ResponseEntity.ok(Map.of(
            "scenario", "Stock Bajo",
            "pedidoId", pedido.getId(),
            "producto", "Webcam HD",
            "stockAnterior", 12,
            "stockActual", 2,
            "eventos", "PedidoCompletado → StockBajo → Alerta de reposición"
        ));
    }
    
    /**
     * Status actual del sistema
     */
    @GetMapping("/status")
    public ResponseEntity<Map<String, Object>> getStatus() {
        var productos = Map.of(
            "producto1", Map.of("id", 1L, "nombre", "Laptop Gaming", "stock", 
                inventarioService.obtenerProducto(1L).getStockActual()),
            "producto2", Map.of("id", 2L, "nombre", "Mouse Inalámbrico", "stock", 
                inventarioService.obtenerProducto(2L).getStockActual()),
            "producto3", Map.of("id", 3L, "nombre", "Teclado Mecánico", "stock", 
                inventarioService.obtenerProducto(3L).getStockActual()),
            "producto4", Map.of("id", 4L, "nombre", "Monitor 4K", "stock", 
                inventarioService.obtenerProducto(4L).getStockActual()),
            "producto5", Map.of("id", 5L, "nombre", "Webcam HD", "stock", 
                inventarioService.obtenerProducto(5L).getStockActual())
        );
        
        return ResponseEntity.ok(Map.of(
            "sistema", "Spring Modulith Demo",
            "productos", productos,
            "pedidoPrecreado", Map.of("id", 1L, "cliente", 100L, "status", 
                pedidoService.obtenerPedido(1L).getEstado().toString()),
            "scenarios", Map.of(
                "scenario1", "POST /api/demo/scenario-1-pedido-completo",
                "scenario2", "POST /api/demo/scenario-2-cancelar-pedido", 
                "scenario3", "POST /api/demo/scenario-3-stock-bajo"
            )
        ));
    }
}