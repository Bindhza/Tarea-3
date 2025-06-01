package modelo;

/**
 * Representacion de una persona que compra un producto en un expendedor con una moneda de valor especifico
 */
public class Comprador {
    private final String sabor;
    private int vuelto;

    /**
     * Metodo donde se crea un comprador, y este compra el producto pedido, registrando su sabor y el vuelto que le queda
     * @param m La moneda la cual el Comprador entrega al Expendedor
     * @param cualProducto Codigo que representa el producto que va a comprar
     * @param exp Expendedor al cual se le compra el producto
     * @throws PagoIncorrectoException Si el comprador compra con una moneda nula
     * @throws PagoInsuficienteException Si el comprador no tiene el dinero suficiente para comprar el producto pedido
     * @throws NoHayProductoException Si el expendedor no tiene stock del producto pedido
     */
    public Comprador(Moneda m, int cualProducto, Expendedor exp) throws PagoIncorrectoException,PagoInsuficienteException,NoHayProductoException{
        exp.comprarProducto(m,cualProducto);
        Producto p = exp.getProducto();
        sabor = p.sabor;
        vuelto = 0;
        Moneda tmp = exp.getVuelto();
        while(tmp != null){
            vuelto += tmp.getValor();
            tmp = exp.getVuelto();
        }
    }

    /**
     * Retorna el vuelto recibido en pesos
     * @return un entero que representa el vuelto recibido
     */
    public int cuantoVuelto() {
        return vuelto;
    }

    /**
     * retorna el sabor del producto comprado
     * @return String que representa el sabor del producto
     */
    public String queCompraste(){
        return sabor;
    }
}
