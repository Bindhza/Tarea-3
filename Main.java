package org.example;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

    }
}

class Comprador{
    private String sonido;
    private int vuelto;

    public Comprador(Moneda m, int cualBebida, Expendedor exp){
        Bebida producto = exp.comprarBebida(m, cualBebida);
        if (producto != null) {
            sonido = producto.beber();
            } else {
            sonido =null;
        }
        vuelto = 0;
        Moneda tmp = exp.getVuelto();
        while (tmp != null) {
            vuelto = vuelto + tmp.getValor();
            tmp = exp.getVuelto();
        }
    }

    public int cuantoVuelto() {
        return vuelto;
    }

    public String queBebiste(){
        return sonido;
    }

}

class Deposito{

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

class DepositoM{

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


abstract class Bebida{

    private int serie;

    public Bebida(int serie){
        this.serie = serie;
    }
    public int getSerie(){
        return serie;
    }
    public abstract String beber();
}

class Sprite extends Bebida{

    public Sprite(int serie){
        super(serie);
    }
    public String beber(){
        String tmp = "sprite";
        return tmp;
    }
}

class CocaCola extends Bebida{

    public CocaCola(int serie){
        super(serie);
    }
    public String beber(){
        String tmp = "cocacola";
        return tmp;
    }
}

class Expendedor{

    private Deposito coca, sprite;
    private DepositoM monVu;
    public static final int  COCA=1;
    public static final int  SPRITE=2;
    private int precioBebida;

    public Expendedor(int max, int precioBebida){
        coca = new Deposito();
        sprite = new Deposito();
        this.precioBebida = precioBebida;
        monVu = new DepositoM();

        for(int i = 0;i < max; i++){

            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
        }
    }

    public Bebida comprarBebida(Moneda moneda, int num){

        if(moneda != null){ //revisa si es que tiene moneda
            if(moneda.getValor() >= precioBebida) {
                if (num == COCA) { //Coca Cola
                    Bebida tmp = coca.getBebida();
                    if (tmp != null) {//mira si es que hay que hay bebida
                        if (moneda.getValor() > precioBebida) { //mira si es que hay que dar vuelto
                            for (int i = 0; i < (moneda.getValor() - precioBebida); i += 100) {
                                Moneda100 monNueva = new Moneda100();
                                monVu.addMoneda(monNueva);
                            }
                        }
                        return tmp;
                    }
                    else{
                        monVu.addMoneda(moneda);
                        return tmp;
                    }
                } else if (num == SPRITE) { // Sprite
                    Bebida tmp = sprite.getBebida();
                    if(tmp != null) { //valida si hay bebida
                        if (moneda.getValor() > precioBebida) {//mira si es que hay que dar vuelto
                            for (int i = 0; i < (moneda.getValor() - precioBebida); i += 100) {
                                Moneda100 monNueva = new Moneda100();
                                monVu.addMoneda(monNueva);
                            }
                        }
                        return tmp;
                    }
                    else{
                        monVu.addMoneda(moneda);
                    }
                } else {//cuando se ingresa una bebida invalida
                    monVu.addMoneda(moneda);
                    return null;
                }
            }
            else {
                monVu.addMoneda(moneda);
                return null;
            }
        }
        else {
            return null;
        }
        return null;
    }

    public Moneda getVuelto(){
        return monVu.getMoneda();
    }

}

abstract class Moneda{
    public Moneda(){
    }
    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}

class Moneda1500 extends Moneda{

    public Moneda1500(){
        super();
    }
    public int getValor(){
        return (1500);
    }
}

class Moneda1000 extends Moneda{

    public Moneda1000(){
        super();
    }
    public int getValor(){
        return (1000);
    }
}

class Moneda500 extends Moneda{

    public Moneda500(){
        super();
    }
    public int getValor(){
        return 500;
    }
}

class Moneda100 extends Moneda{

    public Moneda100(){
        super();
    }
    public int getValor(){
        return 100;
    }
}
