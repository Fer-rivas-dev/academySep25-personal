package com.ejemplo.inventario;

import com.ejemplo.shared.PedidoCompletado;
import com.ejemplo.shared.PedidoCancelado;
import com.ejemplo.shared.LineaPedidoDTO;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ManejadorEventosPedidos {
    
    private final InventarioService inventarioService;
    
    public ManejadorEventosPedidos(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }
    
    @ApplicationModuleListener
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void cuandoPedidoCompletado(PedidoCompletado evento) {
        System.out.println("📦 Procesando pedido completado: " + evento.pedidoId());
        System.out.println("📋 Total de líneas en el pedido: " + evento.totalLineas());
        
        // Usar las líneas incluidas en el evento (respetando boundaries de módulos)
        var lineasPedido = evento.lineas();
        System.out.println("🔍 Procesando " + lineasPedido.size() + " líneas del evento");
        
        // Procesar cada línea del pedido
        for (var linea : lineasPedido) {
            try {
                System.out.println("🔄 Reduciendo stock: " + linea.getNombreProducto() + 
                                 " (ID: " + linea.getProductoId() + ") cantidad: " + linea.getCantidad());
                
                inventarioService.reducirStock(linea.getProductoId(), linea.getCantidad());
                System.out.println("✅ Stock reducido exitosamente para " + linea.getNombreProducto());
                
            } catch (Exception e) {
                System.err.println("❌ Error reduciendo stock para " + linea.getNombreProducto() + 
                                 ": " + e.getMessage());
            }
        }
        
        System.out.println("✅ Procesamiento de pedido completado: " + evento.pedidoId());
    }
    
    @ApplicationModuleListener
    @Async
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void cuandoPedidoCancelado(PedidoCancelado evento) {
    	System.out.println("***********LISTENER INVENTARIOS************");
        System.out.println("🔄 Procesando cancelación de pedido: " + evento.pedidoId());
        System.out.println("📋 Total de líneas canceladas: " + evento.totalLineas());
        
        // En este caso, como es una cancelación, no necesitamos hacer nada con el stock
        // ya que el stock no se redujo previamente
        System.out.println("ℹ️ No se requiere acción de inventario para pedido cancelado");
    }
}