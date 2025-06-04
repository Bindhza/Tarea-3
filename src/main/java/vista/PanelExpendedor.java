package vista;

import modelo.IndiceProductos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class PanelExpendedor extends JPanel implements ActionListener {
    private JPanel panelBotones;
    private JLabel titulo,saldo;
    ArrayList<JButton> botonesCompra;
    public PanelExpendedor(){
        this.setLayout(new BorderLayout());

        panelBotones = new JPanel();
        panelBotones.setOpaque(false);
        panelBotones.setLayout(new GridLayout(8,2));
        add(panelBotones,BorderLayout.EAST);

        crearSaldo();
        botonesCompra = crearBotones();
        crearTitulo();
    }

    private ArrayList<JButton> crearBotones() {
        ArrayList<JButton> botones = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            JButton boton = new JButton();
            URL direccionBoton = getClass().getResource("/button"+(i+1)+"_panel.png");
            URL direccionBotonPresionado = getClass().getResource("/buttonpressed"+(i+1)+"_panel.png");
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

            String producto = IndiceProductos.values()[i].nombre;
            ImageIcon iconoProducto = new ImageIcon(getClass().getResource("/"+producto+"_logo.png"));
            JLabel label = new JLabel(iconoProducto);
            panelBotones.add(label);
        }
        return botones;
    }

    private void crearSaldo() {
        saldo = new JLabel();
        saldo.setText("$0");
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
        titulo.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()/8));
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(62,62,62));
        g2.fillRect(0, 0, getWidth(), getHeight());
        URL url = getClass().getResource("/vitrina_expendedor.png");
        ImageIcon imagen = new ImageIcon(url);
        g2.drawImage(imagen.getImage(), 20, 100, imagen.getIconWidth(), imagen.getIconHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!(e.getSource() instanceof JButton)){return;}
        if(botonesCompra.contains((JButton) e.getSource())){
            int codigo = ((JButton) e.getSource()).getName().charAt(0) - '0';
            System.out.println(codigo);
        }
    }
}
