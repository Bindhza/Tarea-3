package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelComprador extends JPanel implements ActionListener{
    private PanelMonedas panelMonedas;
    private PanelProductos panelProductos;
    JPanel padre;
    public PanelComprador(Expendedor exp, Comprador comp, ActionListener padre){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelMonedas = new PanelMonedas(exp,comp,padre);
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            switch (((JButton) e.getSource()).getName()){
                case "vuelto" -> panelMonedas.actionPerformed(e);
            }
        }
    }
}
