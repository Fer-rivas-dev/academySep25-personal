package com.ejemplo.demo;

import com.ejemplo.inventario.InventarioService;
import com.ejemplo.pedidos.PedidoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Inicializador de datos determinísticos específico para el módulo demo.
 * Movido desde el package principal para respetar boundaries de módulos.
 */
@Component
public class DemoDataSeeder implements CommandLineRunner {
    
    private final InventarioService inventarioService;
    private final PedidoService pedidoService;
    
    public DemoDataSeeder(InventarioService inventarioService, PedidoService pedidoService) {
        this.inventarioService = inventarioService;
        this.pedidoService = pedidoService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        System.out.println("🌱 Inicializando datos de demo...");
        
        // Productos con IDs y datos fijos para demos reproducibles
        inventarioService.crearProducto(1L, "Laptop Gaming", 5);
        inventarioService.crearProducto(2L, "Mouse Inalámbrico", 20);
        inventarioService.crearProducto(3L, "Teclado Mecánico", 15);
        inventarioService.crearProducto(4L, "Monitor 4K", 8);
        inventarioService.crearProducto(5L, "Webcam HD", 12);
        
        // Pedido de ejemplo pre-creado para demostraciones
        var pedidoDemo = pedidoService.crearPedido(100L); // Cliente ID fijo
        pedidoService.agregarProducto(pedidoDemo.getId(), 1L, "Laptop Gaming", 1, new BigDecimal("1299.99"));
        pedidoService.agregarProducto(pedidoDemo.getId(), 2L, "Mouse Inalámbrico", 2, new BigDecimal("29.99"));
        
        System.out.println("✅ Datos de demo inicializados:");
        System.out.println("   📦 5 productos en inventario");
        System.out.println("   🛒 1 pedido pre-creado (ID: " + pedidoDemo.getId() + ")");
        System.out.println("   👤 Cliente demo: ID 100");
        System.out.println();
        System.out.println("🎯 Para probar eventos:");
        System.out.println("   POST /api/pedidos/" + pedidoDemo.getId() + "/completar");
        System.out.println("   POST /api/pedidos/" + pedidoDemo.getId() + "/cancelar");
        System.out.println();
    }
}