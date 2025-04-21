package org.example;
import java.util.ArrayList;

public class DepositoM {
    private ArrayList<Moneda> list;

    public DepositoM(){
        list = new ArrayList();
    }

    public void addMoneda(Moneda mnd){
        list.add(mnd);
    }

    public Moneda getMoneda(){
        if(list.size() == 0) {

            return null;
        }
        else{
            Moneda tmp = list.get(0);
            list.remove(0);
            return tmp;
        }
    }
}
