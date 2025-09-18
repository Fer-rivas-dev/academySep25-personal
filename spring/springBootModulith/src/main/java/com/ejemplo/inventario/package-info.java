/**
 * Módulo de gestión de inventario.
 * 
 * Responsabilidades:
 * - Gestionar productos y stock
 * - Reservar y liberar inventario
 * - Notificar sobre niveles de stock
 */
@ApplicationModule(
    allowedDependencies = {"shared"}
)
package com.ejemplo.inventario;

import org.springframework.modulith.ApplicationModule;