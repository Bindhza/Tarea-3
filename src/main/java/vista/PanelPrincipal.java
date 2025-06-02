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


        panelExpendedor.setPreferredSize(new Dimension(214*2,360*2));
        panelComprador.setPreferredSize(new Dimension(426*2,360*2));
        this.add(panelExpendedor);
        this.add(panelComprador);

    }

}
