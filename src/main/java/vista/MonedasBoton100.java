package vista;

import modelo.Moneda;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class MonedasBoton100 extends MonedasBoton{

    private URL url;
    private ImageIcon imagen;

    public MonedasBoton100(Moneda monedaEntrada) {
        super(monedaEntrada);
        url = getClass().getResource("/moneda100.png");
        imagen = new ImageIcon(url);
        this.setPreferredSize(new Dimension(100,100));
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
        int y = (((getHeight() - medidaTexto.getHeight()) / 2) + medidaTexto.getAscent())+20;//cambiar el numero para bajar o subir

        g2.drawString(texto, x, y);
    }


}
