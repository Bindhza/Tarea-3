package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{
    PanelMonedas panelMonedas;
    PanelProductos panelProductos;
    public PanelComprador(Expendedor exp, Comprador comp, PanelExpendedor lasMonedas){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelMonedas = new PanelMonedas(exp, lasMonedas);
        panelMonedas.setBackground(new Color(166, 166, 166));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelMonedas, gbc);

        panelProductos = new PanelProductos();
        panelProductos.setBackground(new Color(217, 217, 217));
        gbc.gridx = 1;
        add(panelProductos, gbc);
    }



}
