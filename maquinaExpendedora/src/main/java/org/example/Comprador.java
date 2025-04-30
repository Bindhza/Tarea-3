package org.example;

public class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){

    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }
}
