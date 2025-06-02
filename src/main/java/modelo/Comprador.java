package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representacion de una persona que compra un producto en un expendedor con una moneda de valor especifico
 */
public class Comprador {
    private int saldo;
    private Expendedor expendedor;
    private final Deposito<Producto> productos;
    private final ArrayList<Moneda> monedas;


    public Comprador(int monto) {
        productos = new Deposito<>();
        monedas = new ArrayList<>();
    }

    /**
     * Retorna el vuelto recibido en pesos
     * @return un entero que representa el vuelto recibido
     */
    public int cuantoVuelto() {
        return saldo;
    }

    public void darMoneda(Moneda m){
        if(m == null){
            throw new NullPointerException();
        }
        saldo += m.getValor();
        monedas.add(m);
        Collections.sort(monedas);
    }

    public ArrayList<Moneda> obtenerMonedero(Moneda m){
        return monedas;
    }



    /**
     * Retorna el sabor del producto comprado
     * @return String que representa el sabor del producto
     */
    public String queCompraste(){
        return "hi";
    }
}
