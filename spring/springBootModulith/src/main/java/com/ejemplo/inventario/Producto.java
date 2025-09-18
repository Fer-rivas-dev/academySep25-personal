package com.ejemplo.inventario;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nombre;
    
    @Column(nullable = false)
    private String sku;
    
    @Column(name = "stock_actual", nullable = false)
    private Integer stockActual;
    
    @Column(name = "stock_minimo", nullable = false)
    private Integer stockMinimo;
    
    protected Producto() {}
    
    public Producto(String nombre, String sku, int stockActual, int stockMinimo) {
        this.nombre = nombre;
        this.sku = sku;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
    }
    
    public void reducirStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        if (stockActual < cantidad) {
            throw new IllegalStateException("Stock insuficiente. Disponible: " + stockActual + ", Solicitado: " + cantidad);
        }
        this.stockActual -= cantidad;
    }
    
    public void aumentarStock(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        this.stockActual += cantidad;
    }
    
    public boolean necesitaReposicion() {
        return stockActual <= stockMinimo;
    }
    
    public boolean tieneStockDisponible(int cantidad) {
        return stockActual >= cantidad;
    }
    
    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getSku() { return sku; }
    public Integer getStockActual() { return stockActual; }
    public Integer getStockMinimo() { return stockMinimo; }
    
    // Setter para demos con IDs específicos
    public void setId(Long id) { 
        this.id = id; 
    }
}