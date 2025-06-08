package vista;

import modelo.CocaCola;
import modelo.Producto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class CocaBoton extends ProductosBoton {

    private URL url;
    private ImageIcon imagen;

    public CocaBoton(int serie){
        super(new CocaCola(serie));

        url = getClass().getResource("/cocacola_producto.png");
        imagen = new ImageIcon(url);

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"MMMM Usteda ha consumido una Coca-Cola", "Expendedor", JOptionPane.PLAIN_MESSAGE);
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
