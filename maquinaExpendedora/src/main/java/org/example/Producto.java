package org.example;

public abstract class Producto {
    protected final int precio;
    protected final String sabor;
    public Producto(int precio, String sabor){
        this.precio = precio;
        this.sabor = sabor;
    }
}
