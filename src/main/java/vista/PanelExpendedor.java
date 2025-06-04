package vista;

import modelo.IndiceProductos;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelExpendedor extends JPanel {
    private JPanel panelBotones = new JPanel();
    private ImageIcon imagen;
    private URL url, url2;
    private ImageIcon imagenOriginal, imagenFinal;
    private Image imagenEscalable;
    public PanelExpendedor(){
        panelBotones.setLayout(new GridLayout(8,2));
        this.setLayout(new BorderLayout());
        this.add(panelBotones,BorderLayout.EAST);
        for(int i = 0; i < 5; i++){
            JButton boton = new JButton();
            URL direccionBoton = getClass().getResource("/button"+(i+1)+"_panel.png");
            URL direccionBotonPresionado = getClass().getResource("/buttonpressed"+(i+1)+"_panel.png");
            ImageIcon imagenBoton = new ImageIcon(direccionBoton);
            ImageIcon imagenBotonPresionado= new ImageIcon(direccionBotonPresionado);

            boton.setIcon(imagenBoton);
            boton.setPressedIcon(imagenBotonPresionado);

            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
            boton.setBorderPainted(false);

            panelBotones.add(boton);

            String producto = IndiceProductos.values()[i].nombre;
            ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/"+producto+"_logo.png"));
            JLabel label = new JLabel(iconoProducto);
            panelBotones.add(label);
        }
        panelBotones.setOpaque(false);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(62,62,62));
        g2.fillRect(0, 0, getWidth(), getHeight());

        url2 = getClass().getResource("/vitrina_expendedor.png");
        imagenOriginal = new ImageIcon(url2);
        imagenEscalable = imagenOriginal.getImage().getScaledInstance(265, 480, Image.SCALE_SMOOTH);
        //se pueden cambiar las dimensiones de la imagen agusto

        imagenFinal = imagenOriginal;
        g2.drawImage(imagenFinal.getImage(), 20, 20, this);

    }
}
