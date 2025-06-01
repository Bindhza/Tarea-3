package vista;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(217, 217, 217));
        g2.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
