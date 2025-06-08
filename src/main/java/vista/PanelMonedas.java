package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class PanelMonedas extends JPanel implements ActionListener {

    private final JPanel m100, m500, m1000;
    private final ArrayList<MonedasBoton> monedas100, monedas500, monedas1000;
    private final Comprador comp;
    private final Expendedor exp;
    private ArrayList<Moneda> cacheMonedas;
    private ActionListener padre;
    public PanelMonedas(Expendedor exp, Comprador comp, ActionListener padre){
        this.comp = comp;
        this.exp = exp;
        this.padre = padre;
        this.setLayout(new GridLayout(4,1));

        cacheMonedas = new ArrayList<>(comp.obtenerMonedero());
        JLabel titulo = new JLabel("Monedas");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 23));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setVerticalAlignment(SwingConstants.TOP);
        this.add(titulo);

        m100 = new JPanel();
        m500 = new JPanel();
        m1000 = new JPanel();
        monedas100 = new ArrayList<>();
        monedas500 = new ArrayList<>();
        monedas1000 = new ArrayList<>();
        m100.setOpaque(false);
        m500.setOpaque(false);
        m1000.setOpaque(false);

        this.add(m100);
        this.add(m500);
        this.add(m1000);
        crearMonedas();
    }

    public void crearMonedas(){
        ArrayList<Moneda> monedas = comp.obtenerMonedero();
        for(Moneda m : monedas){
            MonedasBoton monedaVista = new MonedasBoton(m);
            monedaVista.setName("monedaPanel");
            monedaVista.setPreferredSize(new Dimension(60,60));
            monedaVista.addActionListener(this);
            agregarMonedaAPanel(monedaVista);
        }
    }

    private void actualizarPaneles(){
        if(cacheMonedas.size() == comp.obtenerMonedero().size()){return;}
        if (cacheMonedas.size() > comp.obtenerMonedero().size()){
            ArrayList<Moneda> monedasFaltantes = cacheMonedas
                    .stream()
                    .filter(m -> !comp.obtenerMonedero().contains(m))
                    .collect(Collectors.toCollection(ArrayList::new));
            for(Moneda m: monedasFaltantes){
                ArrayList<MonedasBoton> botones = obtenerListaBotones(m.getValor());
                JPanel panel = obtenerPanel(m.getValor());
                MonedasBoton b = botones
                        .stream()
                        .filter(boton -> boton.getMoneda().getSerie() == m.getSerie())
                        .toList()
                        .getFirst();
                panel.remove(b);
                botones.remove(b);
            }
            cacheMonedas = new ArrayList<>(comp.obtenerMonedero());
            revalidate();
            repaint();
            return;
        }
        System.out.println("moneda nueva");
        ArrayList<Moneda> monedasNuevas = comp
                .obtenerMonedero()
                .stream()
                .filter(m -> !cacheMonedas.contains(m))
                .collect(Collectors.toCollection(ArrayList::new));
        for(Moneda m : monedasNuevas){
            MonedasBoton monedaVista = new MonedasBoton(m);
            monedaVista.setPreferredSize(new Dimension(60,60));
            monedaVista.addActionListener(this);
            monedaVista.setName("monedaPanel");
            agregarMonedaAPanel(monedaVista);
        }
        cacheMonedas = new ArrayList<>(comp.obtenerMonedero());
        revalidate();
        repaint();
    }


    private ArrayList<MonedasBoton> obtenerListaBotones(int valor) {
        return switch (valor) {
            case 100 -> monedas100;
            case 500 -> monedas500;
            case 1000 -> monedas1000;
            default -> throw new IllegalStateException("Valor de moneda no soportado: " + valor);
        };
    }

    private JPanel obtenerPanel(int valor) {
        return switch (valor) {
            case 100 -> m100;
            case 500 -> m500;
            case 1000 -> m1000;
            default -> throw new IllegalStateException("Valor de moneda no soportado: " + valor);
        };
    }

    private void agregarMonedaAPanel(MonedasBoton monedaVista) {
        int valor = monedaVista.getMoneda().getValor();
        obtenerPanel(valor).add(monedaVista);
        obtenerListaBotones(valor).add(monedaVista);
    }

    //no me gusta tampoco, pero que se le va a hacer
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof MonedasBoton){
            Moneda m = ((MonedasBoton) e.getSource()).getMoneda();
            if(((MonedasBoton) e.getSource()).getName().equals("vuelto")){
                comp.darMoneda(((MonedasBoton) e.getSource()).getMoneda());
                actualizarPaneles();
                System.out.println(comp.obtenerMonedero());
                return;
            }
            System.out.println("no es vuelto");
            comp.quitarMoneda(m);
            exp.insertarMoneda(m);
            actualizarPaneles();
            padre.actionPerformed(e);
        }
    }
}
