package modelo;

/**
 * Representacion de una moneda de 500 pesos
 */
public class Moneda500 extends Moneda {
    public Moneda500(int serie){
        super(serie);
    }
    public int getValor(){
        return 500;
    }
}
