package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class PanelExpendedor extends JPanel implements ActionListener {
    private JPanel panelBotones;
    private JLabel titulo,saldo;
    private JButton producto;
    private Image imagenExpendedor;
    private boolean compraErronea;
    private final ArrayList<JButton> botonesCompra, botonesVitrina;
    private final Expendedor expendedor;
    private final Comprador comprador;
    public PanelExpendedor(Expendedor exp, Comprador comp) {
        this.setLayout(new BorderLayout());

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
        bottomPanel.add(producto);

        botonesVitrina = crearBotonesVitrina(panelCentral);
        crearTitulo();

        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new GridLayout(8,2));
        add(panelBotones,BorderLayout.EAST);

        crearSaldo();
        botonesCompra = crearBotones();
        repaint();
    }

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
                b.setBounds(69+82*(i-3),255,95,95);
            }
            b.setName(""+i);
            b.addActionListener(this);
            panel.add(b);
            botones.add(b);
        }
        return botones;
    }

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

    private void crearTitulo() {
        titulo = new JLabel();
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
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.black);
        g2.fillRoundRect(76,600,166,87,10,10);
        g2.drawImage(imagenExpendedor, 20, 100, imagenExpendedor.getWidth(this), imagenExpendedor.getHeight(this), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton)){return;}
        if(botonesCompra.contains((JButton) e.getSource())){
            int codigo = ((JButton) e.getSource()).getName().charAt(0) - '0';
            try {
                expendedor.comprarProducto(codigo);
                ImageIcon imagenProducto = switch(expendedor.verProducto()){
                    case CocaCola -> new ImageIcon(getClass().getResource("/cocacola_producto.png"));
                    case Sprite -> new ImageIcon(getClass().getResource("/sprite_producto.png"));
                    case Fanta -> new ImageIcon(getClass().getResource("/fanta_producto.png"));
                    case Super8 -> new ImageIcon(getClass().getResource("/super8_producto.png"));
                    case Snickers -> new ImageIcon(getClass().getResource("/snickers_producto.png"));
                };
                producto.setIcon(imagenProducto);
            } catch (NoHayProductoException ex) {
                System.out.println("no hay producto");
                saldo.setText("ERROR");
                compraErronea = true;
            } catch (PagoInsuficienteException ex) {
                System.out.println("no hay plata");
                saldo.setText("ERROR");
                compraErronea = true;
            }
            return;
        }
        if(e.getSource() == producto){
            try {
                comprador.retirarProducto(expendedor);
                producto.setIcon(null);
            } catch (NoHayProductoException ex) {
                System.out.println("no hay producto");
            }
            return;
        }
        if(botonesVitrina.contains((JButton) e.getSource())){
            int codigo = ((JButton) e.getSource()).getName().charAt(0) - '0' + 1;
            expendedor.rellenarDeposito(codigo,5);
            System.out.println("Se relleno el deposito numero " + codigo);
        }

    }
}