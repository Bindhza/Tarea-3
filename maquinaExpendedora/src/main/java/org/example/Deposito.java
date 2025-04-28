package org.example;
import java.util.ArrayList;

/**
 * Deposito donde se almacenaran los productos de la maquina expendedora
 * @param <T> tipo producto
 */
public class Deposito<T> {
    private ArrayList<T> deposito;

    /**
     * en el constructor se crea la nueva instancia del ArrayList del deposito
     */
    public Deposito(){
        deposito = new ArrayList<T>();
    }

    /**
     * Sirve para añadir productos al deposito
     * @param objeto producto a añadir
     */
    public void addObjeto(T objeto){
        deposito.add(objeto);
    }

    /**
     * Saca un objeto del deposito en en caso de que exista, si no retorna null
     * @return producto seleccionado
     */
    public T getObjeto(){
        if(deposito.isEmpty()) {

            return null;
        }
        else{
            T tmp = deposito.removeFirst();
            return tmp;
        }
    }
}
