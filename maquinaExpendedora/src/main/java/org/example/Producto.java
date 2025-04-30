package org.example;

public abstract class Producto {
    protected int precio;
    protected String sabor;
    public Producto(int precio, String sabor){
        this.precio = precio;
        this.sabor = sabor;
    }
}
