package org.example;

public class Comprador {
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida producto = exp.comprarBebida(m, cualBebida);
        if (producto != null) {
            sonido = producto.beber();
        } else {
            sonido = null;
        }
        vuelto = 0;
        Moneda tmp = exp.getVuelto();
        while (tmp != null) {
            vuelto = vuelto + tmp.getValor();
            tmp = exp.getVuelto();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }
}
