package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMonedas extends JPanel {

    private JPanel m100 = new JPanel();
    private JPanel m500 = new JPanel();
    private JPanel m1000 = new JPanel();
    private JPanel titulo = new JPanel();
    private MonedasBoton moneda;
    private int cantidadMonedas = 0;
    private int aux;
    private JLabel title = new JLabel();

    public PanelMonedas(Expendedor comp, PanelExpendedor exp){

        this.setLayout(new GridLayout(4,1));

        this.crearTitulo(this, comp, exp);


        m100.setLayout(new FlowLayout());
        m100.setOpaque(false);
        m500.setLayout(new FlowLayout());
        m500.setOpaque(false);
        m1000.setLayout(new FlowLayout());
        m1000.setOpaque(false);

        this.add(m100);
        this.add(m500);
        this.add(m1000);

        this.crearMonedas(5, comp, exp);
    }

    public void crearMonedas(int cantidad, Expendedor comp, PanelExpendedor exp){
        m100.removeAll();
        m500.removeAll();
        m1000.removeAll();

        for(int i = cantidadMonedas; i < (cantidadMonedas + cantidad); i++){
            moneda = new MonedasBoton100(100+i, comp, m100, exp);
            moneda.setPreferredSize(new Dimension(60,60));
            m100.add(moneda);

            moneda = new MonedasBoton500(500+i, comp, m500, exp);
            moneda.setPreferredSize(new Dimension(60,60));
            m500.add(moneda);

            moneda = new MonedasBoton1000(1000+i, comp, m1000, exp);
            moneda.setPreferredSize(new Dimension(60,60));
            m1000.add(moneda);
            aux = i;
        }

        cantidadMonedas = aux;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(166, 166, 166));
        g2.fillRect(0, 0, getWidth(), getHeight());
    }

    private void crearTitulo(PanelMonedas panel, Expendedor comp, PanelExpendedor exp) {
        titulo.setLayout(new BorderLayout());
        title.setText("Billetera");
        title.setForeground(Color.ORANGE);
        title.setFont(new Font("Tahoma", Font.ITALIC, 70));
        titulo.add(title, BorderLayout.NORTH);
        titulo.setOpaque(false);
        JButton reiniciar = new JButton("Reiniciar");
        reiniciar.setSize(15,50);
        titulo.add(reiniciar, BorderLayout.EAST);
        reiniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.crearMonedas(5, comp, exp);
                panel.revalidate();
                panel.repaint();
            }
        });
        this.add(titulo);
    }
}
