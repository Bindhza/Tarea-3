package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(1);
        Comprador comp = new Comprador(10900);
        PanelPrincipal panelPrincipal = new PanelPrincipal(exp,comp);
        JFrame f = new JFrame();
        f.add(panelPrincipal);
        f.setVisible(true);
        f.setSize(1292,720); // el tamaño está feo, pero si no hago algo asi hay problemas menores
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
