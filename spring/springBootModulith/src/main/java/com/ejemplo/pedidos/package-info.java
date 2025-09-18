/**
 * Módulo de gestión de pedidos.
 * 
 * Responsabilidades:
 * - Crear y gestionar pedidos
 * - Procesar estados de pedidos  
 * - Publicar eventos relacionados con pedidos
 */
@ApplicationModule(
    allowedDependencies = {"shared"}
)
package com.ejemplo.pedidos;

import org.springframework.modulith.ApplicationModule;