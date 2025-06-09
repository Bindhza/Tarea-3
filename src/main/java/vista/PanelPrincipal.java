package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel que contiene todo un expendedor y el comprador que interactúa con este
 */
public class PanelPrincipal extends JPanel implements ActionListener {
    final private PanelComprador panelComprador;
    final private PanelExpendedor panelExpendedor;

    public PanelPrincipal(Expendedor exp, Comprador comp) {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        panelExpendedor = new PanelExpendedor(exp, comp, this);
        panelExpendedor.setBackground(new Color(62,62,62));
        panelComprador = new PanelComprador(exp, comp,this);

        panelExpendedor.setPreferredSize(new Dimension(428,720));
        panelComprador.setPreferredSize(new Dimension(852,720));
        add(panelExpendedor);
        add(panelComprador);
    }

    /**
     * Se pasan eventos entre ventanas, sin modificar el estado externamente
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton boton) {
            switch (boton.getName()) {
                case "monedaPanel" -> panelExpendedor.actionPerformed(e);
                case "vuelto", "retirar" -> panelComprador.actionPerformed(e);
                default -> System.out.println("Error");
            }
        }
    }
}
