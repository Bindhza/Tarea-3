package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {

    public PanelMonedas(){
        this.setLayout(new GridLayout(1,0));
        MonedasBoton moneda = new MonedasBoton100(new Moneda100(1232));
        this.add(moneda);
        this.add(new MonedasBoton100(new Moneda100(65782)));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(166, 166, 166));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
