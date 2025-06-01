package modelo;

import java.util.ArrayList;

/**
 * Representacion de una persona que compra un producto en un expendedor con una moneda de valor especifico
 */
public class Comprador {
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
        return monedas
                .stream()
                .map(Moneda::getValor)
                .reduce(0, Integer::sum);
    }

    public void comprar(){

    }

    public void darMoneda(Moneda m){
        if(m == null){
            throw new NullPointerException();
        }
        monedas.add(m);
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
