package vista;

import javax.swing.*;
import modelo.*;

public abstract class MonedasBoton extends JButton {
    Moneda moneda;

    public MonedasBoton(Moneda monedaEntrada){
        moneda = monedaEntrada;
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);
    }


    public int getSerie(){
        return moneda.getSerie();
    }

    public int getValor(){
        return moneda.getValor();
    }
}
