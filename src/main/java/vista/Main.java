package vista;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        panelPrincipal.setVisible(true);
        JFrame f = new JFrame();
        f.add(panelPrincipal);
        f.setVisible(true);
        f.setSize(646*2,360*2); // el tamaño está feo, pero si no hago algo asi hay problemas menores
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelPrincipal.revalidate();
    }
}
