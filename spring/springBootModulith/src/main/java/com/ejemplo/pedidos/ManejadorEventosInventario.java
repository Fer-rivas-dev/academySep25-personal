package com.ejemplo.pedidos;

import com.ejemplo.shared.StockBajo;
import com.ejemplo.shared.StockRepuesto;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEventosInventario {
    
    @ApplicationModuleListener
    public void cuandoStockBajo(StockBajo evento) {
        System.out.println("⚠️ ALERTA: Stock bajo detectado!");
        System.out.println("   Producto: " + evento.nombreProducto());
        System.out.println("   Stock actual: " + evento.stockActual());
        System.out.println("   Stock mínimo: " + evento.stockMinimo());
        
        // Aquí podrías implementar lógica para:
        // - Notificar al departamento de compras
        // - Enviar email de alerta
        // - Bloquear temporalmente nuevos pedidos de este producto
        // - Etc.
    }
    
    @ApplicationModuleListener
    public void cuandoStockRepuesto(StockRepuesto evento) {
        System.out.println("✅ Stock repuesto exitosamente!");
        System.out.println("   Producto: " + evento.nombreProducto());
        System.out.println("   Cantidad repuesta: " + evento.cantidadRepuesta());
        
        // Aquí podrías implementar lógica para:
        // - Reactivar pedidos que estaban en espera
        // - Notificar a ventas que el producto está disponible
        // - Etc.
    }
}