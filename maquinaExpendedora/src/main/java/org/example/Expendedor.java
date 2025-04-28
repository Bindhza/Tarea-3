package org.example;

public class Expendedor {
    private Deposito<CocaCola> cocacola;
    private Deposito<Fanta> sprite;
    private Deposito<Moneda> monedas;
    private Deposito<Super8> snicker;  //agregar funcionamiento
    private Deposito<Super8> super8;     //tambien agregar funcionamiento
    private int preciobbd, precioS8, precioS;  //precioS8 precio super 8
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public Expendedor(int n,int p, int precioS8, int precioS){
        preciobbd = p;
        cocacola = new Deposito<CocaCola>();
        sprite = new Deposito<Fanta>();
        monedas = new Deposito<Moneda>();
        for (int i = 0; i < n; i++){
            cocacola.addObjeto(new CocaCola(100+i));
            sprite.addObjeto(new Fanta(200+i));
            super8.addObjeto(new Super8(i));
            snicker.addObjeto(new Super8(i));
        }
    }

    public Moneda getVuelto(){
        return monedas.getObjeto();
    }

    public Bebida comprarBebida(Moneda m, int b){
        if (m == null) {return null;}
        int v = m.getValor();
        Bebida b2 = null;
        if (v - preciobbd >= 0 && (b == COCA || b == SPRITE) ) {
            if (b == COCA){
                b2 = cocacola.getObjeto();
            } else if (b == SPRITE){
                b2 = sprite.getObjeto();
            }
            if (b2 != null){
                v -= preciobbd;
            }
        }
        for (int i = 0; i < v/100; i++){
            monedas.addObjeto(new Moneda100());
        }
        return b2;
    }
    public Dulce comprarDulce(){

    }
}
