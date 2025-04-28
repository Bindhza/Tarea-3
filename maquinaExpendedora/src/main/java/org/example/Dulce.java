package org.example;

public abstract class Dulce extends Producto{
    private int serie;

    public Dulce(int serie){
        this.serie = serie;
    }

    public int getSerie(){
        return serie;
    }
    public abstract String comer();
}
