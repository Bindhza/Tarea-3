package org.example;

/**
 * Clase abstracta que para generar objetos del tipo moneda
 */
public abstract class Moneda {

    public Moneda(){
    }

    /**
     * metodo que retorna a la moneda
     * @return direccion de la instancia
     */
    public Moneda getSerie(){
        return this;
    }

    /**
     * metodo para saber el valor de el objeto moneda
     * @return el valor int de la moneda
     */
    public abstract int getValor();
}
