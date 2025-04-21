package org.example;

public class Expendedor {
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

        if(moneda != null){
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
