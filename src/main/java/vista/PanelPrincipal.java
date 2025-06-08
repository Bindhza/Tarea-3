package vista;

import modelo.Comprador;
import modelo.Expendedor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal extends JPanel implements ActionListener {//se ve en el centro de la ventana
    private PanelComprador panelComprador;
    private PanelExpendedor panelExpendedor;

    public PanelPrincipal(Expendedor exp, Comprador comp) {
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));

        panelExpendedor = new PanelExpendedor(exp, comp, this);
        panelExpendedor.setBackground(new Color(62,62,62));
        panelComprador = new PanelComprador(exp, comp,this);


        panelExpendedor.setPreferredSize(new Dimension(428,720));
        panelComprador.setPreferredSize(new Dimension(852,720));
        this.add(panelExpendedor);
        this.add(panelComprador);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton boton = (JButton) e.getSource();
            switch (boton.getName()) {
                case "monedaPanel" -> {
                    System.out.println("evento desde panelmonedas!!");
                    panelExpendedor.actionPerformed(e);
                }
                case "vuelto" -> {
                    panelComprador.actionPerformed(e);
                    System.out.println("alguien quiere vuelto");
                }
                case "retirar" ->{
                    panelComprador.actionPerformed(e);
                }
                default -> System.out.println("Error");
            }
        }
    }
}
