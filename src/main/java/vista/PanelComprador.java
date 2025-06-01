package vista;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{
    PanelMonedas panelMonedas;
    PanelProductos panelProductos;
    public PanelComprador(){
        this.setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        this.setBackground(Color.BLUE);
        panelMonedas = new PanelMonedas();
        panelProductos = new PanelProductos();
        panelMonedas.setPreferredSize(new Dimension(213,360));
        panelProductos.setPreferredSize(new Dimension(213,360));
        add(panelMonedas);
        add(panelProductos);


    }



}
