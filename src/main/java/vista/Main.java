package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7);
        Comprador comp = new Comprador(950);
        exp.insertarMoneda(new Moneda1000(12983));
        PanelPrincipal panelPrincipal = new PanelPrincipal(exp,comp);
        panelPrincipal.setVisible(true);
        JFrame f = new JFrame();
        f.add(panelPrincipal);
        f.setVisible(true);
        f.setSize(1292,720); // el tamaño está feo, pero si no hago algo asi hay problemas menores
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelPrincipal.revalidate();
    }
}
