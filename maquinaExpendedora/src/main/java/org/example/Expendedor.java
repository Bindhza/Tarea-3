package org.example;


/**
 * Representacion de un expendedor que guarda una cantidad finita de productos con precio especifico y
 * acepta dinero a cambio de estos
 */
public class Expendedor {
    final private Deposito<Moneda> monedas;
    final private Deposito<CocaCola> cocacola;
    final private Deposito<Fanta> fanta;
    final private Deposito<Sprite> sprite;
    final private Deposito<Snickers> snicker;
    final private Deposito<Super8> super8;
    final static int COCACOLA = 1;
    final static int FANTA = 2;
    final static int SPRITE = 3;
    final static int SUPER8 = 4;
    final static int SNIKERS = 5;

    /**
     * Instancia los depositos del expendedor y los llena con productos
     * @param n la cantidad de producto con la que inicia cada deposito
     */
    public Expendedor(int n){
        cocacola = new Deposito<>();
        fanta = new Deposito<>();
        sprite = new Deposito<>();
        super8 = new Deposito<>();
        snicker = new Deposito<>();
        monedas = new Deposito<>();
        for (int i = 0; i < n; i++){
            cocacola.addObjeto(new CocaCola());
            fanta.addObjeto(new Fanta());
            sprite.addObjeto(new Sprite());
            super8.addObjeto(new Super8());
            snicker.addObjeto(new Snickers());
        }
    }

    /**
     * accede al deposito de monedas y entrega una moneda de este
     * @return una moneda del deposito de monedas, o null si no hay ninguna
     */
    public Moneda getVuelto(){
        return monedas.getObjeto();
    }

    /**
     * metodo principal de Expendedor con el cual se compra un producto
     * @param moneda la moneda con la cual se compra el producto
     * @param codigo el codigo que identifica al producto
     * @return el producto comprado
     * @throws NoHayProductoException en caso de que el codigo no lo maneje la maquina
     * o si el producto esta fuera de stock
     * @throws PagoIncorrectoException si se paga con una moneda invalida
     * @throws PagoInsuficienteException si el monto pagado no es suficiente
     */
    public Producto comprarProducto(Moneda moneda, int codigo) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        if (moneda == null) {
            throw new PagoIncorrectoException();
        }

        IndiceProductos indice = switch (codigo) {
            case 1 -> IndiceProductos.CocaCola;
            case 2 -> IndiceProductos.Fanta;
            case 3 -> IndiceProductos.Sprite;
            case 4 -> IndiceProductos.Super8;
            case 5 -> IndiceProductos.Snickers;
            default -> {
                monedas.addObjeto(moneda);
                throw new NoHayProductoException();
            }
        };
        if (indice.precio > moneda.getValor()){
            monedas.addObjeto(moneda);
            throw new PagoInsuficienteException();
        }
        int vuelto = (moneda.getValor() - indice.precio);

        for(int i = 0; i < vuelto; i += 100){
            monedas.addObjeto(new Moneda100());
        }

        Deposito<? extends Producto> productos = switch (indice) {
            case CocaCola -> cocacola;
            case Fanta ->    fanta;
            case Sprite ->   sprite;
            case Super8 ->   super8;
            case Snickers -> snicker;
        };

        if (productos.estaVacio()){
            throw new NoHayProductoException();
        }

        return productos.getObjeto();
    }

}
