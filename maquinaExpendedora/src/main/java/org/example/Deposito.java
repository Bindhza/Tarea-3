package org.example;
import java.util.ArrayList;

public class Deposito {
    private ArrayList<Bebida> list;

    public Deposito(){
        list = new ArrayList();
    }

    public void addBebida(Bebida bbd){
        list.add(bbd);
    }

    public Bebida getBebida(){
        if(list.size() == 0) {

            return null;
        }
        else{
            Bebida tmp = list.get(0);
            list.remove(0);
            return tmp;
        }
    }
}
