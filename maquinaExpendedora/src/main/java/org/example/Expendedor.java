package org.example;

public class Expendedor {
    private Deposito<CocaCola> cocacola;
    private Deposito<Fanta> fanta;
    private Deposito<Sprite> sprite;
    private Deposito<Moneda> monedas;
    private Deposito<Snickers> snicker;  //agregar funcionamiento
    private Deposito<Super8> super8;     //tambien agregar funcionamiento
    public Expendedor(int n){
        cocacola = new Deposito<>();
        fanta = new Deposito<>();
        sprite = new Deposito<>();
        super8 = new Deposito<>();
        snicker = new Deposito<>();
        monedas = new Deposito<>();
        for (int i = 0; i < n; i++){
            cocacola.addObjeto(new CocaCola());
            fanta.addObjeto(new Fanta());
            sprite.addObjeto(new Sprite());
            super8.addObjeto(new Super8());
            snicker.addObjeto(new Snickers());
        }
    }

    public Moneda getVuelto(){
        return monedas.getObjeto();
    }

    public Producto comprar(Moneda moneda, int codigo){
        if (moneda == null){throw new ArithmeticException();} //por mientras
    }
}
