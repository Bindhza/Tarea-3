package modelo;

/**
 * Representacion de una moneda de 1000 pesos
 */
public class Moneda1000 extends Moneda{
    public Moneda1000(int serie){
        super(serie);
    }
    public int getValor(){
        return 1000;
    }
}
