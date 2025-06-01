package vista;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        PanelPrincipal panelPrincipal = new PanelPrincipal();
        panelPrincipal.setVisible(true);
        Frame f = new Frame();
        f.add(panelPrincipal);
        f.setVisible(true);
        f.setSize(646,360); // el tamaño está feo, pero si no hago algo asi hay problemas menores
        panelPrincipal.revalidate();
    }
}
