package vista;

import modelo.Moneda;

import javax.swing.*;
import java.awt.*;
import modelo.*;
import java.net.URL;

public class MonedasBoton500 extends MonedasBoton{

    private URL url;
    private ImageIcon imagen;

    public MonedasBoton500(int serie) {

        super(new Moneda500(serie));
        url = getClass().getResource("/moneda500.png");
        imagen = new ImageIcon(url);

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
}

