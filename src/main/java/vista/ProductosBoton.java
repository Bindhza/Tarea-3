package vista;

import modelo.Producto;

import javax.swing.*;
import java.awt.*;

/**
 * Boton que guarda un producto
 */
public class ProductosBoton extends JButton {

    private Producto producto;
    private ImageIcon icono;

    /**
     * Crea un boton relacionado a un producto
     * @param prod el producto asociado al boton
     */
    public ProductosBoton(Producto prod){
        producto = prod;
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
        setPreferredSize(new Dimension(40,40));
        if (prod == null){
            return;
        }
        setToolTipText("Serie = " + prod.getSerie());
        icono = new ImageIcon(new ImageIcon(getClass().getResource("/"+prod.getIndice().nombre+"_producto.png"))
                .getImage()
                .getScaledInstance(40,40,Image.SCALE_SMOOTH));
        setIcon(icono);
    }

    /**
     * Cambia el producto del botón
     * @param prod el producto al cual cambiar
     */
    public void actualizarProducto(Producto prod){
        producto = prod;
        if(prod == null){
            icono = null;
            setIcon(null);
            setToolTipText("");
            return;
        }
        icono = new ImageIcon(new ImageIcon(getClass().getResource("/"+prod.getIndice().nombre+"_producto.png"))
                .getImage()
                .getScaledInstance(60,60,Image.SCALE_SMOOTH));setIcon(icono);
        setToolTipText("Serie = " + prod.getSerie());
    }
}
