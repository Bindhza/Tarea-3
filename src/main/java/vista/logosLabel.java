package vista;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class logosLabel extends JLabel {
    private Image imagenEscalable;
    private ImageIcon imagenOriginal, imagenFinal;
    private URL url;
    public logosLabel(String strImagen, int escalable){
        url = getClass().getResource(strImagen);
        imagenOriginal = new ImageIcon(url);
        float proporcion = escalable/100.0f;
        int ancho= (int)(imagenOriginal.getIconWidth()* proporcion);
        int largo= (int)(imagenOriginal.getIconHeight()* proporcion);
        imagenEscalable = imagenOriginal.getImage().getScaledInstance(ancho, largo, Image.SCALE_SMOOTH);
        imagenFinal = new ImageIcon(imagenEscalable);
        this.setIcon(imagenFinal);

    }
}
