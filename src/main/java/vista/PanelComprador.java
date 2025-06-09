package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel que guarda todo lo relacionado con un comprador
 * tiene dos sub paneles que guardan las monedas y los productos
 */

public class PanelComprador extends JPanel implements ActionListener{
    private final PanelMonedas panelMonedas;
    private final PanelProductos panelProductos;
    public PanelComprador(Expendedor exp, Comprador comp, ActionListener padre) {
        panelMonedas = new PanelMonedas(exp, comp, padre);
        panelMonedas.setBackground(new Color(166, 166, 166));

        panelProductos = new PanelProductos(comp);
        panelProductos.setBackground(new Color(217, 217, 217));

        // Crear un JSplitPane horizontal
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                panelMonedas, panelProductos);
        splitPane.setDividerLocation(480); // Posición inicial del divisor
        splitPane.setResizeWeight(0.7);   // 70% para panelMonedas, 30% para panelProductos
        splitPane.setDividerSize(5);      // Grosor del divisor

        this.setLayout(new BorderLayout());
        this.add(splitPane, BorderLayout.CENTER);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            switch (((JButton) e.getSource()).getName()){
                case "vuelto" -> panelMonedas.actionPerformed(e);
                case "retirar" -> panelProductos.actualizarPanel();
            }
        }
    }
}
