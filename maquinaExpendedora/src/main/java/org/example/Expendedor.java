package org.example;

public class Expendedor {
    private Deposito<CocaCola> cocacola;
    private Deposito<Sprite> sprite;
    private Deposito<Moneda> monedas;
    private int precio;
    public static final int COCA = 1;
    public static final int SPRITE = 2;
    public Expendedor(int n,int p){
        precio = p;
        cocacola = new Deposito<CocaCola>();
        sprite = new Deposito<Sprite>();
        monedas = new Deposito<Moneda>();
        for (int i = 0; i < n; i++){
            cocacola.addObjeto(new CocaCola(100+i));
            sprite.addObjeto(new Sprite(200+i));
        }
    }

    public Moneda getVuelto(){
        return monedas.getObjeto();
    }

    public Bebida comprarBebida(Moneda m, int b){
        if (m == null) {return null;}
        int v = m.getValor();
        Bebida b2 = null;
        if (v - precio >= 0 && (b == COCA || b == SPRITE) ) {
            if (b == COCA){
                b2 = cocacola.getObjeto();
            } else if (b == SPRITE){
                b2 = sprite.getObjeto();
            }
            if (b2 != null){
                v -= precio;
            }
        }
        for (int i = 0; i < v/100; i++){
            monedas.addObjeto(new Moneda100());
        }
        return b2;
    }
}
