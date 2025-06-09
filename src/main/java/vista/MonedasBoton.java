package vista;

import modelo.Moneda;

import javax.swing.*;
import java.awt.*;

import java.net.URL;


/**
 * Boton que guarda una moneda
 */
public class MonedasBoton extends JButton{

    private URL url;
    private ImageIcon imagen;

    private Moneda moneda;

    public MonedasBoton(Moneda m) {
        url = getClass().getResource("/moneda"+ m.getValor()+".png");
        imagen = new ImageIcon(url);
        moneda = m;
        setPreferredSize(new Dimension(100,100));
        setBorderPainted(false);
        setContentAreaFilled(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        super.paintComponent(g);

        g2.setColor(Color.BLACK); // Color del texto
        g2.setFont(new Font("Arial", Font.PLAIN, 13)); // Fuente del texto

        String texto = moneda.getSerie() + ""; // Texto a mostrar
        FontMetrics medidaTexto = g2.getFontMetrics();

        // Calcular posición para centrar el texto
        int x = (getWidth() - medidaTexto.stringWidth(texto)) / 2;
        int y = (((getHeight() - medidaTexto.getHeight()) / 2) + medidaTexto.getAscent())+10;//cambiar el numero para bajar o subir

        g2.drawString(texto, x, y);
    }

    public Moneda getMoneda() {
        return moneda;
    }


}
