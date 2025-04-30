package org.example;

public abstract class Bebida extends Producto{
    public Bebida (int precio, String sabor){
        super(precio,sabor);
    }

    /**
     * Bebe la bebida y retorna su sabor
     * @return sabor de la bebida
     */

    public String beber(){
        return sabor;
    }
}
