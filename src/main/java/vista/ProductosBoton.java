package vista;

import modelo.Producto;

import javax.swing.*;

public abstract class ProductosBoton extends JButton {

    private Producto producto;

    public ProductosBoton(Producto prod){
        producto = prod;
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
    }

    public Producto getProducto(){
        return producto;
    }
}
