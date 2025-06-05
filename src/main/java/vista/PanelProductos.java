package vista;

import javax.swing.*;
import java.awt.*;

public class PanelProductos extends JPanel {
    public PanelProductos() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        crearTitulo();
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
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
