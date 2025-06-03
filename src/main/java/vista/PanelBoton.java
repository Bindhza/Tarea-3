package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class PanelBoton extends JButton {
    private URL url, urlPresionado;
    private ImageIcon icon, iconPresionado;
    private Image escalado, escaladoPresionado;
    Timer timer;

    public PanelBoton(String direccion, String direccionPresionado) {
        url = getClass().getResource(direccion);
        icon = new ImageIcon(url);
        escalado = icon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        icon = new ImageIcon(escalado);

        urlPresionado = getClass().getResource(direccionPresionado);
        iconPresionado = new ImageIcon(urlPresionado);
        escaladoPresionado = iconPresionado.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        iconPresionado = new ImageIcon(escaladoPresionado);

        this.setIcon(icon);
        this.setBorderPainted(false);
        this.setContentAreaFilled(false);
        this.setFocusPainted(false);

        timer = new Timer(300, e -> {
            this.setIcon(icon);
        });
        timer.setRepeats(false);

        addMouseListener(new MouseAdapter() {
                             @Override
                             public void mousePressed(MouseEvent e) {
                                 setIcon(iconPresionado);
                                 timer.restart();
                             }
                         }
        );
    }
}
