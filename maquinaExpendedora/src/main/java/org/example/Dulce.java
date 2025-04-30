package org.example;

public abstract class Dulce extends Producto{

    public Dulce(int precio,String sabor){
        super(precio,sabor);
    }

    public String comer(){
        return sabor;
    }
}
