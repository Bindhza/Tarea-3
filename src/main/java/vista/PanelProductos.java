package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {

    protected JPanel coca = new JPanel(new FlowLayout());
    protected JPanel fanta = new JPanel(new FlowLayout());
    protected JPanel sprite = new JPanel(new FlowLayout());
    protected JPanel snicker = new JPanel(new FlowLayout());
    protected JPanel super8 = new JPanel(new FlowLayout());


    public PanelProductos() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        crearTitulo();
        crearEstructura();
    }

    private void crearEstructura(){
        coca.setOpaque(false);
        fanta.setOpaque(false);
        sprite.setOpaque(false);
        snicker.setOpaque(false);
        super8.setOpaque(false);
        this.add(coca);
        this.add(fanta);
        this.add(sprite);
        this.add(snicker);
        this.add(super8);
    }

    private void crearTitulo() {
        JLabel titulo = new JLabel();
        titulo.setText("Productos");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.RED);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 33));
        titulo.setPreferredSize(new Dimension(912, 95));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        titulo.setAlignmentY(Component.CENTER_ALIGNMENT);
        add(titulo);
        setProducto(new CocaBoton(15));
        setProducto(new CocaBoton(12));

    }

    public void setProducto(ProductosBoton prod){ //falta crear los botones

        if(prod.getProducto() instanceof CocaCola){
            coca.add(prod);
        }
        else if (prod.getProducto() instanceof Sprite){
            sprite.add(prod);
        }
        else if (prod.getProducto() instanceof Fanta){
            fanta.add(prod);
        }
        else if (prod.getProducto() instanceof Snickers){
            snicker.add(prod);
        }
        else if (prod.getProducto() instanceof Super8){
            super8.add(prod);
        }
    }
}
