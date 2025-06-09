package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

/**
 * Panel que maneja compras de un comprador en un expendedor
 */
public class PanelExpendedor extends JPanel implements ActionListener {
    private final JPanel panelBotones;
    private final JPanel panelVuelto;
    private MonedasBoton botonVuelto;
    private JLabel saldo;
    private final JButton producto;
    private final Image imagenExpendedor;
    private boolean compraErronea;
    private final ArrayList<JButton> botonesCompra, botonesVitrina;
    private final Expendedor expendedor;
    private final Comprador comprador;
    private final ActionListener padre;

    /**
     * Inicializa un panel con BorderLayout, con un título arriba, botones de vuelto y producto
     * abajo y los productos al centro
     * @param exp el expendedor asociado
     * @param padre el panel que generó este panel
     */
    public PanelExpendedor(Expendedor exp, Comprador comp, ActionListener padre) {
        this.setLayout(new BorderLayout());
        this.padre = padre;
        URL url = getClass().getResource("/vitrina_expendedor.png");
        ImageIcon imagen = new ImageIcon(url);
        imagenExpendedor = imagen.getImage();

        compraErronea = false;
        expendedor = exp;
        comprador = comp;

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(0,95));
        bottomPanel.setLayout(null);
        bottomPanel.setOpaque(false);
        add(bottomPanel, BorderLayout.SOUTH);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(null);
        panelCentral.setOpaque(false);
        panelCentral.setPreferredSize(new Dimension(imagenExpendedor.getWidth(this),imagenExpendedor.getHeight(this)));
        add(panelCentral, BorderLayout.CENTER);

        producto = new JButton();
        producto.setContentAreaFilled(false);
        producto.setBorderPainted(false);
        producto.setFocusPainted(false);
        producto.setOpaque(false);
        producto.setBounds(112,0,95,95);
        producto.addActionListener(this);
        producto.setName("retirar");
        bottomPanel.add(producto);

        panelVuelto = new JPanel();
        panelVuelto.setLayout(new GridLayout(1,1));
        panelVuelto.setBounds(310,0,95,95);
        bottomPanel.add(panelVuelto);

        botonesVitrina = crearBotonesVitrina(panelCentral);
        for(int i = 0; i < 5; i++){actualizarLeyendaVitrina(i);}
        crearTitulo();

        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new GridLayout(8,2));
        add(panelBotones,BorderLayout.EAST);
        crearSaldo();
        botonesCompra = crearBotones();
        repaint();
    }

    /**
     * Crea todos los botones para comprar y los guarda en un arreglo
     * @param panel el panel donde viviran estos botones
     * @return el arreglo de botones
     */
    private ArrayList<JButton> crearBotonesVitrina(JPanel panel) {
        IndiceProductos[] productos = IndiceProductos.values();
        ArrayList<JButton> botones = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            JButton b = new JButton();
            b.setOpaque(false);
            b.setContentAreaFilled(false);
            b.setBorderPainted(false);
            b.setFocusPainted(false);

            String producto = "/" + productos[i].nombre + "_producto.png";
            b.setIcon(new ImageIcon(getClass().getResource(producto)));
            if(i < 3){
                b.setBounds(23+82*i,75,95,95);
            } else {
                b.setBounds(59+94*(i-3),255,95,95);
            }
            b.setName(""+i);
            b.addActionListener(this);
            panel.add(b);
            botones.add(b);
        }
        return botones;
    }

    private void actualizarLeyendaVitrina(int codigo){
        botonesVitrina.get(codigo).setToolTipText("<html> Stock = " + expendedor.obtenerStock()[codigo]+ "<br>Precio = $"+ IndiceProductos.values()[codigo].precio+"</html>");
    }

    /**
     * Instancia los botones para comprar los productos, y los guarda en un ArrayList
     * @return ArrayList con los botones
     */
    private ArrayList<JButton> crearBotones() {
        ArrayList<JButton> botones = new ArrayList<>();
        for(int i = 1; i <= 5; i++){
            JButton boton = new JButton();
            URL direccionBoton = getClass().getResource("/button"+i+"_panel.png");
            URL direccionBotonPresionado = getClass().getResource("/buttonpressed"+i+"_panel.png");
            ImageIcon imagenBoton = new ImageIcon(direccionBoton);
            ImageIcon imagenBotonPresionado= new ImageIcon(direccionBotonPresionado);

            boton.setIcon(imagenBoton);
            boton.setPressedIcon(imagenBotonPresionado);
            boton.setName(""+i);

            boton.setContentAreaFilled(false);
            boton.setFocusPainted(false);
            boton.setBorderPainted(false);
            boton.addActionListener(this);
            panelBotones.add(boton);
            botones.add(boton);

            String producto = IndiceProductos.values()[i-1].nombre;
            ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/"+producto+"_logo.png"));
            JLabel label = new JLabel(iconoProducto);
            panelBotones.add(label);
        }
        return botones;
    }

    private void crearSaldo() {
        saldo = new JLabel();
        saldo.setText("$");
        saldo.setHorizontalAlignment(SwingConstants.CENTER);
        saldo.setVerticalAlignment(SwingConstants.CENTER);
        saldo.setForeground(Color.white);
        saldo.setFont(saldo.getFont().deriveFont(22.1F));
        saldo.setPreferredSize(new Dimension(40,20));
        panelBotones.add(saldo);
        panelBotones.add(new JLabel(""));
    }

    /**
     * crea una nueva moneda en el vuelto en caso de que quede vuelto, de lo contrario simplemente borra la actual
     * y no hace nada mas
     */
    private void crearNuevoVuelto(){
        if (botonVuelto != null) {
            panelVuelto.removeAll();
        }
        Moneda m = expendedor.getVuelto();
        if (m == null){
            botonVuelto = null;
            return;
        }
        MonedasBoton boton = new MonedasBoton(m);
        boton.setPreferredSize(new Dimension(60,60));
        boton.setToolTipText("Obtener el vuelto");
        boton.setName("vuelto");
        boton.addActionListener(this);
        boton.addActionListener(padre);
        panelVuelto.add(boton);
        botonVuelto = boton;
    }
    private void crearTitulo() {
        JLabel titulo = new JLabel();
        titulo.setPreferredSize(new Dimension(1292,720/8));
        titulo.setText("Maquina Expendedora");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.CENTER);
        titulo.setForeground(Color.LIGHT_GRAY);
        titulo.setFont(new Font("Tahoma", Font.BOLD, 33));
        add(titulo,BorderLayout.NORTH);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(!compraErronea){
            saldo.setText("$"+expendedor.getSaldo());
        } else {
            compraErronea = false;
        }
        boolean[] depositosVacios = expendedor.depositosVacios();
        for(int i = 0; i < 5; i++){
            if(depositosVacios[i]){
                botonesVitrina.get(i).setIcon(new ImageIcon(getClass().getResource("/sin_stock.png")));
                botonesVitrina.get(i).setToolTipText("SIN STOCK");
            }
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRoundRect(76,600,166,87,10,10);
        g2.drawImage(imagenExpendedor, 20, 100, imagenExpendedor.getWidth(this), imagenExpendedor.getHeight(this), this);
    }

    /**
     * Maneja todos los casos del expendedor, en caso de tocar el botón de vuelto o el de producto
     * el padre de este panel igual se entera
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton boton)){return;}
        if(e.getSource() == botonVuelto){
            crearNuevoVuelto();
            revalidate();
            repaint();
            return;
        }
        if(botonesCompra.contains((JButton) e.getSource())){
            int codigo = ((JButton) e.getSource()).getName().charAt(0) - '0'-1;
            try {
                expendedor.comprarProducto(IndiceProductos.values()[codigo]);
                ImageIcon imagenProducto = switch(expendedor.verProducto()){
                    case CocaCola -> new ImageIcon(getClass().getResource("/cocacola_producto.png"));
                    case Sprite -> new ImageIcon(getClass().getResource("/sprite_producto.png"));
                    case Fanta -> new ImageIcon(getClass().getResource("/fanta_producto.png"));
                    case Super8 -> new ImageIcon(getClass().getResource("/super8_producto.png"));
                    case Snickers -> new ImageIcon(getClass().getResource("/snickers_producto.png"));
                };
                producto.setIcon(imagenProducto);
                actualizarLeyendaVitrina(codigo);
                if (botonVuelto != null){
                    return;
                }
                crearNuevoVuelto();

            } catch (NoHayProductoException ex) {
                System.out.println("no hay producto");
                saldo.setText("ERROR");
                compraErronea = true;
                if(botonVuelto == null){
                    crearNuevoVuelto();
                }
            } catch (PagoInsuficienteException ex) {
                System.out.println("no hay plata");
                saldo.setText("ERROR");
                compraErronea = true;
                if(botonVuelto == null){
                    crearNuevoVuelto();
                }
            }
            return;
        }
        if(e.getSource() == producto){
            try {
                comprador.retirarProducto(expendedor);
                producto.setIcon(null);
                padre.actionPerformed(e);
            } catch (NoHayProductoException ex) {
                System.out.println("no hay producto");
            }
            return;
        }
        if(botonesVitrina.contains((JButton) e.getSource())){
            int codigo = boton.getName().charAt(0) - '0' + 1;
            expendedor.rellenarDeposito(codigo,5);
            actualizarLeyendaVitrina(codigo-1);
            boton.setIcon(new ImageIcon(getClass()
                    .getResource("/"
                            +IndiceProductos.values()[codigo-1].nombre
                            +"_producto.png")));
            System.out.println("Se relleno el deposito numero " + codigo);
        }
        if(((JButton) e.getSource()).getName().equals("monedaPanel")){repaint();}
    }
}