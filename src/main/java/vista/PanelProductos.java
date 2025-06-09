package vista;

import modelo.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Panel que guarda un inventario de productos
 */
public class PanelProductos extends JPanel {
    private final Comprador comprador;
    protected ArrayList<JPanel> paneles;

    /**
     * Crea un panel que contiene los productos de un comprador específico
     * @param comprador el comprador del que se extrae su inventario
     */
    public PanelProductos(Comprador comprador) {
        this.comprador = comprador;

        setLayout(new BorderLayout());

        JPanel panelTitulo = new JPanel(new BorderLayout());
        panelTitulo.setPreferredSize(new Dimension(0, 80));

        JLabel titulo = new JLabel("Productos", SwingConstants.CENTER);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 33));
        titulo.setForeground(Color.GRAY);
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

    /**
     * Actualiza el panel con el deposito de productos del comprador, añadiendo el ultimo producto
     */
    public void actualizarPanel() {
        Producto ultimoProducto = comprador.getProductos().getLast();
        setProducto(ultimoProducto);
    }

    /**
     * Añade un producto al panel de productos respectivo
     * @param prod el producto a añadir al panel
     */
    public void setProducto(Producto prod) {
        paneles.get(prod.getIndice().ordinal()).add(new ProductosBoton(prod));
        revalidate();
        repaint();
    }
}