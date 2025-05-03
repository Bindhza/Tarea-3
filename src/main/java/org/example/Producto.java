package org.example;

/**
 * Clase abstracta que representa un objeto comestible que se puede comprar
 */
public abstract class Producto {
    protected final int precio;
    protected final String sabor;

    public Producto(int precio, String sabor){
        this.precio = precio;
        this.sabor = sabor;
    }
}
