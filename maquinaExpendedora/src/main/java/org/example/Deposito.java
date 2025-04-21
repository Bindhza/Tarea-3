package org.example;
import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> deposito;

    public Deposito(){
        deposito = new ArrayList<T>();
    }

    public void addObjeto(T objeto){
        deposito.add(objeto);
    }

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
