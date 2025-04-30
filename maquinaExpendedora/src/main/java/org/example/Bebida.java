package org.example;

public abstract class Bebida extends Producto{
    public Bebida (int precio, String sabor){
        super(precio,sabor);
    }
    public String beber(){
        return sabor;
    };
}
