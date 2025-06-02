package vista;

import javax.swing.*;
import java.awt.*;

public class PanelPrincipal extends JPanel {//se ve en el centro de la ventana
    private PanelComprador panelComprador;
    private PanelExpendedor panelExpendedor;

    public PanelPrincipal() {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        panelExpendedor = new PanelExpendedor();
        panelComprador = new PanelComprador();
        PanelBoton panelBoton = new PanelBoton();

        panelExpendedor.setPreferredSize(new Dimension(214,360));
        panelComprador.setPreferredSize(new Dimension(426,360));
        this.add(panelComprador);
        this.add(panelExpendedor);
        this.add(panelBoton);
    }

}
