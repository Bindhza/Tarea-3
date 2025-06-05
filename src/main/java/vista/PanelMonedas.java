package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;

public class PanelMonedas extends JPanel {

    private JPanel m100 = new JPanel();
    private JPanel m500 = new JPanel();
    private JPanel m1000 = new JPanel();
    private MonedasBoton moneda;
    private int cantidadMonedas = 0;

    public PanelMonedas(){



        this.setLayout(new GridLayout(4,1));
        this.add(new JLabel("Monedero"));
        m100.setLayout(new FlowLayout());
        m100.setOpaque(false);
        m500.setLayout(new FlowLayout());
        m500.setOpaque(false);
        m1000.setLayout(new FlowLayout());
        m1000.setOpaque(false);

        this.add(m100);
        this.add(m500);
        this.add(m1000);

        this.crearMonedas(12 );
    }

    public void crearMonedas(int cantidad){
        for(int i = cantidadMonedas; i< cantidad; i++){
            moneda = new MonedasBoton100(100+i);
            moneda.setPreferredSize(new Dimension(60,60));
            m100.add(moneda);

            moneda = new MonedasBoton500(500+i);
            moneda.setPreferredSize(new Dimension(60,60));
            m500.add(moneda);

            moneda = new MonedasBoton1000(1000+i);
            moneda.setPreferredSize(new Dimension(60,60));
            m1000.add(moneda);
            cantidadMonedas = i;
        }
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(166, 166, 166));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}
