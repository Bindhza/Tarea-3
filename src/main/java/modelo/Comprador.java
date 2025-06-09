package modelo;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Representacion de una persona que compra un producto en un expendedor con una moneda de valor especifico
 */
public class Comprador {
    private int saldo;
    private final ArrayList<Producto> productos;
    private final ArrayList<Moneda> monedas;


    public Comprador(int monto) {
        productos = new ArrayList<>();
        monedas = new ArrayList<>();
        MonedaFactory generador = MonedaFactory.obtenerGen();
        int monedas1000 = monto / 1000;
        monto %= 1000;
        int monedas500 = monto / 500;
        monto %= 500;
        int monedas100 = monto / 100;

        for(int i = 0; i < monedas1000; i++){
            monedas.add(generador.generarMoneda1000());
        }
        for(int i = 0; i < monedas500; i++){
            monedas.add(generador.generarMoneda500());
        }
        for(int i = 0; i < monedas100; i++){
            monedas.add(generador.generarMoneda100());
        }
    }

    public ArrayList<Producto> getProductos() {
        return productos;
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
        productos.add(p);
    }



    /**
     * Retorna el sabor del producto comprado
     * @return String que representa el sabor del producto
     */
    public String queCompraste(){
        return "hi";
    }
}
