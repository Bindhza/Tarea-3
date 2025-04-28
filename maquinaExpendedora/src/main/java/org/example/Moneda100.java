package org.example;

/**
 * Representacion de una moneda de valor 100 pesos
 */
public class Moneda100 extends Moneda{
    /**
     * Llama al constructor de Moneda(esta vacio)
     */
    public Moneda100(){
        super();
    }

    /**
     * Sirve para saber el valor de la moneda
     * @return valor de la moneda 100 pesos
     */
    public int getValor(){
        return 100;
    }
}
