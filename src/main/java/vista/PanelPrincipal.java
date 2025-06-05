package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador panelComprador;
    private PanelExpendedor panelExpendedor;

    public PanelPrincipal(Expendedor exp, Comprador comp) {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        panelExpendedor = new PanelExpendedor(exp, comp);
        panelExpendedor.setBackground(new Color(62,62,62));
        panelComprador = new PanelComprador(exp, comp);


        panelExpendedor.setPreferredSize(new Dimension(428,720));
        panelComprador.setPreferredSize(new Dimension(852,720));
        this.add(panelExpendedor);
        this.add(panelComprador);
    }

}
