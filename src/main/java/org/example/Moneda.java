package org.example;

/**
 * Clase abstracta que para generar objetos del tipo moneda
 */
public abstract class Moneda implements Comparable<Moneda> {

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

    /**
     * Overriding del metodo toString
     * @return una cadena que contiene el hashcode de la moneda, y su valor en pesos
     */
    @Override
    public String toString() {
        return hashCode() + ": " + getValor() + " pesos";
    }

    /**
     * Implementacion de la interfaz Comparable
     * @param o la moneda a la que se compara por valor.
     * @return cero si son iguales en valor, negativo si la otra es mayor,
     *          positivo si esta lo es
     */
    @Override
    public int compareTo(Moneda o) {
        return Integer.compare(this.getValor(), o.getValor());
    }
}
