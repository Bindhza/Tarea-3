package vista;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class PanelExpendedor extends JPanel {
    private JPanel panelBotones = new JPanel();
    private ImageIcon imagen;
    private URL url;
    public PanelExpendedor(){
        panelBotones.setLayout(new GridLayout(8,2));
        this.setLayout(new BorderLayout());
        PanelBoton boton1 = new PanelBoton("/button1_panel.png","/buttonpressed1_panel.png");
        logosLabel coca = new logosLabel("/coca_logo.png", 3);
        PanelBoton boton2 = new PanelBoton("/button2_panel.png","/buttonpressed2_panel.png");
        logosLabel sprite = new logosLabel("/sprite_logo.png", 3);
        PanelBoton boton3 = new PanelBoton("/button3_panel.png","/buttonpressed3_panel.png");
        logosLabel fanta = new logosLabel("/fanta_logo.png", 10);
        PanelBoton boton4 = new PanelBoton("/button4_panel.png","/buttonpressed4_panel.png");
        logosLabel snikers = new logosLabel("/snickers_logo.png", 3);
        PanelBoton boton5 = new PanelBoton("/button5_panel.png","/buttonpressed5_panel.png");
        logosLabel super8 = new logosLabel("/super8_logo.png", 30);
        this.add(panelBotones,BorderLayout.EAST);
        panelBotones.add(boton1);
        panelBotones.add(coca);
        panelBotones.add(boton2);
        panelBotones.add(sprite);
        panelBotones.add(boton3);
        panelBotones.add(fanta);
        panelBotones.add(boton4);
        panelBotones.add(snikers);
        panelBotones.add(boton5);
        panelBotones.add(super8);

        panelBotones.setOpaque(false);


    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(62,62,62));
        g2.fillRect(0, 0, getWidth(), getHeight());

    }
}
