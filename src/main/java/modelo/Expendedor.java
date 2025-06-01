package modelo;


/**
 * Representacion de un expendedor que guarda una cantidad finita de productos con precio especifico y
 * acepta dinero a cambio de estos
 */
public class Expendedor {
    final private Deposito<Moneda> saldoDeposito;
    final private Deposito<Moneda> monedasVuelto;
    final private Deposito<Moneda> monedasGanadas;
    final private Deposito<CocaCola> cocacola;
    final private Deposito<Fanta> fanta;
    final private Deposito<Sprite> sprite;
    final private Deposito<Snickers> snicker;
    final private Deposito<Super8> super8;
    private Producto productoComprado;
    private int saldo;

    /**
     * Instancia los depositos del expendedor y los llena con productos
     * @param n la cantidad de producto con la que inicia cada deposito
     */
    public Expendedor(int n){
        saldo = 0;
        saldoDeposito = new Deposito<>();
        monedasGanadas = new Deposito<>();
        cocacola = new Deposito<>();
        fanta = new Deposito<>();
        sprite = new Deposito<>();
        super8 = new Deposito<>();
        snicker = new Deposito<>();
        monedasVuelto = new Deposito<>();
        productoComprado = null;
        for (int i = 0; i < n; i++){
            cocacola.addObjeto(new CocaCola());
            fanta.addObjeto(new Fanta());
            sprite.addObjeto(new Sprite());
            super8.addObjeto(new Super8());
            snicker.addObjeto(new Snickers());
        }
    }

    public void ingresarMoneda(Moneda m){
        if(m == null){
            throw new NullPointerException();
        }
        saldoDeposito.addObjeto(m);
        saldo += m.getValor();
    }

    /**
     * accede al deposito de monedas y entrega una moneda de este
     * @return una moneda del deposito de monedas, o null si no hay ninguna
     */
    public Moneda getVuelto(){
        return monedasVuelto.getObjeto();
    }

    public Producto getProducto() throws NoHayProductoException {
        if (productoComprado == null){
            throw new NoHayProductoException();
        }
        return productoComprado;
    }

    /**
     * metodo principal de Expendedor con el cual se compra un producto, lo guarda en su deposito
     * @param codigo el codigo que identifica al producto
     * @throws NoHayProductoException en caso de que el codigo no lo maneje la maquina
     * o si el producto esta fuera de stock
     * @throws PagoIncorrectoException si se paga con una moneda invalida
     * @throws PagoInsuficienteException si el monto pagado no es suficiente
     */
    public void comprarProducto(int codigo) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {

        IndiceProductos indice = switch (codigo) {
            case 1 -> IndiceProductos.CocaCola;
            case 2 -> IndiceProductos.Fanta;
            case 3 -> IndiceProductos.Sprite;
            case 4 -> IndiceProductos.Super8;
            case 5 -> IndiceProductos.Snickers;
            default -> {
                saldo = 0;
                monedasVuelto.dumpDeposito(saldoDeposito);
                throw new NoHayProductoException();
            }
        };
        if (indice.precio > saldo){
            saldo = 0;
            monedasVuelto.dumpDeposito(saldoDeposito);
            throw new PagoInsuficienteException();
        }
        int vuelto = saldo - indice.precio;
        monedasGanadas.dumpDeposito(saldoDeposito);


        int monedas1000 = vuelto / 1000;
        vuelto %= 1000;
        int monedas500 = vuelto / 500;
        vuelto %= 500;
        int monedas100 = vuelto / 100;

        for(int i = 0; i < monedas1000; i++){
            monedasVuelto.addObjeto(new Moneda1000());
        }
        for(int i = 0; i < monedas500; i++){
            monedasVuelto.addObjeto(new Moneda500());
        }
        for(int i = 0; i < monedas100; i++){
            monedasVuelto.addObjeto(new Moneda100());
        }

        Deposito<? extends Producto> productos = switch (indice) {
            case CocaCola ->  cocacola;
            case Fanta    ->  fanta;
            case Sprite   ->  sprite;
            case Super8   ->  super8;
            case Snickers ->  snicker;
        };

        if (productos.estaVacio()){
            throw new NoHayProductoException();
        }

        productoComprado = productos.getObjeto();
    }

}
