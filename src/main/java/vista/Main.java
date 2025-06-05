package vista;

import modelo.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(7);
        Comprador comp = new Comprador(950);
        MonedaFactory generador = MonedaFactory.obtenerGen();
        comp.darMoneda(generador.generarMoneda100());
        comp.darMoneda(generador.generarMoneda100());
        comp.darMoneda(generador.generarMoneda100());
        exp.insertarMoneda(generador.generarMoneda1000());
        PanelPrincipal panelPrincipal = new PanelPrincipal(exp,comp);
        panelPrincipal.setVisible(true);
        JFrame f = new JFrame();
        f.add(panelPrincipal);
        f.setVisible(true);
        f.setSize(1292,720); // el tamaño está feo, pero si no hago algo asi hay problemas menores
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        panelPrincipal.revalidate();
    }
}
