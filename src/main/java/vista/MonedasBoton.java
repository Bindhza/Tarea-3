package vista;

import javax.swing.*;
import modelo.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class MonedasBoton extends JButton {
    Moneda moneda;

    public MonedasBoton(Moneda monedaEntrada, Expendedor comp, JPanel panel, PanelExpendedor exp){
        moneda = monedaEntrada;
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comp.insertarMoneda(moneda);
                //panel.remove(this);
                JButton boton = (JButton) e.getSource();
                panel.remove(boton);
                panel.revalidate();
                panel.repaint();
                exp.repaint();
            }
        });
    }


    public int getSerie(){
        return moneda.getSerie();
    }

    public int getValor(){
        return moneda.getValor();
    }
    public JButton getMoneda(){
        return this;
    }

}
