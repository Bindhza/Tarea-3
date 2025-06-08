package vista;

import modelo.CocaCola;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SnickersBoton extends ProductosBoton {

    private URL url;
    private ImageIcon imagen;

    public SnickersBoton(int serie, JPanel panel){
        super(new CocaCola(serie));

        url = getClass().getResource("/snickers_producto.png");
        imagen = new ImageIcon(url);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"MMMM Usted se comio un Snickers", "Expendedor", JOptionPane.PLAIN_MESSAGE);
                JButton boton = (JButton) e.getSource();
                Component panel = boton.getParent();
                ((JPanel)panel).remove(boton);
                ((JPanel)panel).revalidate();
                ((JPanel) panel).repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        g2.drawImage(imagen.getImage(), 0, 0, getWidth(), getHeight(), this);
        super.paintComponent(g);
    }
}
