package vista;

import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelProductos extends JPanel {
    private final Comprador comprador;
    protected ArrayList<JPanel> paneles;

    public PanelProductos(Comprador comprador) {
        this.comprador = comprador;

        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setPreferredSize(new Dimension(0, 80));

        JLabel titulo = new JLabel("PRODUCTOS", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 33));
        titulo.setForeground(Color.RED);
        panelTitulo.add(titulo, BorderLayout.CENTER);

        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelProductos = new JPanel();
        panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
        paneles = new ArrayList<>();

        for(IndiceProductos i: IndiceProductos.values()) {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
            panel.setName(i.nombre);
            panel.setBorder(BorderFactory.createTitledBorder(i.nombre));
            paneles.add(panel);
            panelProductos.add(panel);
        }

        add(panelProductos, BorderLayout.CENTER);

        for(Producto p: comprador.getProductos()) {
            paneles.get(p.getIndice().ordinal()).add(new ProductosBoton(p));
        }
    }

    public void actualizarPanel() {
        Producto ultimoProducto = comprador.getProductos().getLast();
        setProducto(ultimoProducto);
    }

    public void setProducto(Producto prod) {
        paneles.get(prod.getIndice().ordinal()).add(new ProductosBoton(prod));
        revalidate();
        repaint();
    }
}