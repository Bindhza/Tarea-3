package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{
    PanelMonedas panelMonedas;
    PanelProductos panelProductos;
    public PanelComprador(Expendedor exp, Comprador comp){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBackground(Color.BLUE);

        panelMonedas = new PanelMonedas();
        panelProductos = new PanelProductos();

        panelMonedas.setPreferredSize(new Dimension(getWidth()/2,360*2));
        panelProductos.setPreferredSize(new Dimension(getWidth()/2,360*2));

        add(panelMonedas);
        add(panelProductos);


    }



}
