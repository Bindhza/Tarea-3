package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {
    Expendedor exp;
    Comprador comprador;
    public PanelMonedas(Comprador comp) {
        comprador = comp;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(166, 166, 166));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
