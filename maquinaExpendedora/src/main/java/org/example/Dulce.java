package org.example;

public abstract class Dulce extends Producto{

    public Dulce(int precio,String sabor){
        super(precio,sabor);
    }

    /**
     * Come el dulce y registra su sabor
     * @return sabor del dulce
     */
    public String comer(){
        return sabor;
    }
}
