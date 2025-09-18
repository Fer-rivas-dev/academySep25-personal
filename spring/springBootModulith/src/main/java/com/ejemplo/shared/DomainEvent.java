package com.ejemplo.shared;

import java.time.Instant;

/**
 * Clase base para eventos de dominio del sistema.
 */
public abstract class DomainEvent {
    
    private final Instant occurredOn;
    
    protected DomainEvent() {
        this.occurredOn = Instant.now();
    }
    
    public Instant getOccurredOn() {
        return occurredOn;
    }
    
    // Método de conveniencia para compatibilidad
    public Instant occurredOn() {
        return occurredOn;
    }
}