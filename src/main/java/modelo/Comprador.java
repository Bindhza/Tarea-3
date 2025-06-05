package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representacion de una persona que compra un producto en un expendedor con una moneda de valor especifico
 */
public class Comprador {
    private int saldo;
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

    public void quitarMoneda(Moneda m){
        monedas.remove(m);
    }
    public ArrayList<Moneda> obtenerMonedero(){
        return monedas;
    }

    public void retirarProducto(Expendedor exp) throws NoHayProductoException {
        Producto p = exp.getProducto();
        if(p == null){
            throw new NoHayProductoException();
        }
        productos.addObjeto(p);
    }



    /**
     * Retorna el sabor del producto comprado
     * @return String que representa el sabor del producto
     */
    public String queCompraste(){
        return "hi";
    }
}
