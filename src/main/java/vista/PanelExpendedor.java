package vista;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(62,62,62));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
