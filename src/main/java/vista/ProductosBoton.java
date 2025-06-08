package vista;

import modelo.Producto;

import javax.swing.*;
import java.awt.*;

public class ProductosBoton extends JButton {

    private Producto producto;
    private ImageIcon icono;

    public ProductosBoton(Producto prod){
        producto = prod;
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setToolTipText("Serie = " + prod.getSerie());
        icono = new ImageIcon(new ImageIcon(getClass().getResource("/"+prod.getIndice().nombre+"_producto.png"))
                .getImage()
                .getScaledInstance(40,40,Image.SCALE_SMOOTH));
        setIcon(icono);
        setPreferredSize(new Dimension(40,40));
    }

    public void actualizarProducto(Producto prod){
        producto = prod;
        icono = new ImageIcon(new ImageIcon(getClass().getResource("/"+prod.getIndice().nombre+"_producto.png"))
                .getImage()
                .getScaledInstance(60,60,Image.SCALE_SMOOTH));setIcon(icono);
        setToolTipText("Serie = " + prod.getSerie());
    }
}
