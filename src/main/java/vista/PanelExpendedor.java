package vista;

import javax.swing.*;
import java.awt.*;

public class PanelExpendedor extends JPanel {
    public PanelExpendedor(){
        this.setLayout(new BorderLayout());
        PanelBoton boton1 = new PanelBoton("button1_panel.png");
        this.add(boton1,BorderLayout.EAST);
        PanelBoton boton2 = new PanelBoton("button2_panel.png");
        this.add(boton2,BorderLayout.EAST);
        PanelBoton boton3 = new PanelBoton("button3_panel.png");
        this.add(boton3,BorderLayout.EAST);
        PanelBoton boton4 = new PanelBoton("button4_panel.png");
        this.add(boton4,BorderLayout.EAST);
        PanelBoton boton5 = new PanelBoton("button5_panel.png");
        this.add(boton5,BorderLayout.EAST);


    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(62,62,62));
        g2.fillRect(0, 0, getWidth(), getHeight());

    }
}
