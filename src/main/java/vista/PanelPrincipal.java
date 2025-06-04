package vista;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador panelComprador;
    private PanelExpendedor panelExpendedor;

    public PanelPrincipal() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));


        panelExpendedor = new PanelExpendedor();
        panelComprador = new PanelComprador();


        panelExpendedor.setPreferredSize(new Dimension(428,720));
        panelComprador.setPreferredSize(new Dimension(852,720));
        this.add(panelExpendedor);
        this.add(panelComprador);

    }

}
