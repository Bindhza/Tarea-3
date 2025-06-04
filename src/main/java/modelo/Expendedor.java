package modelo;


/**
 * Representacion de un expendedor que guarda una cantidad finita de productos con precio especifico y
 * acepta dinero a cambio de estos
 */
public class Expendedor {
    final private Deposito<Moneda> monedasSaldo;
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
     * Instancia los depósitos del expendedor y los llena con productos
     * @param n la cantidad de producto con la que inicia cada depósito
     */
    public Expendedor(int n){
        saldo = 0;
        monedasSaldo = new Deposito<>();
        monedasGanadas = new Deposito<>();
        cocacola = new Deposito<>();
        fanta = new Deposito<>();
        sprite = new Deposito<>();
        super8 = new Deposito<>();
        snicker = new Deposito<>();
        monedasVuelto = new Deposito<>();
        productoComprado = null;
        ProductoFactory generador = ProductoFactory.obtenerGen();
        for (int i = 0; i < n; i++){
            cocacola.addObjeto(generador.generarCocaCola());
            fanta.addObjeto(generador.generarFanta());
            sprite.addObjeto(generador.generarSprite());
            super8.addObjeto(generador.generarSuper8());
            snicker.addObjeto(generador.generarSnickers());
        }
    }

    public void insertarMoneda(Moneda m){
        if(m == null){
            throw new NullPointerException();
        }
        monedasSaldo.addObjeto(m);
        saldo += m.getValor();
    }

    public void soltarSaldo(){
        saldo = 0;
        monedasVuelto.dumpDeposito(monedasSaldo);
    }

    public int getSaldo(){
        return saldo;
    }

    /**
     * accede al deposito de monedas y entrega una moneda de este
     * @return una moneda del deposito de monedas, o null si no hay ninguna
     */
    public Moneda getVuelto(){
        return monedasVuelto.getObjeto();
    }

    public IndiceProductos verProducto() throws NoHayProductoException {
        if (productoComprado == null){
            throw new NoHayProductoException();
        }
        return productoComprado.indice;
    }

    public Producto getProducto() throws NoHayProductoException {
        if (productoComprado == null){
            throw new NoHayProductoException();
        }
        Producto aux = productoComprado;
        productoComprado = null;
        return aux;
    }

    /**
     * metodo principal de Expendedor con el cual se compra un producto, lo guarda en su deposito
     * @param codigo el codigo que identifica al producto
     * @throws NoHayProductoException en caso de que el codigo no lo maneje la maquina
     * o si el producto está fuera de stock
     * @throws PagoInsuficienteException si el monto pagado no es suficiente
     */
    public void comprarProducto(int codigo) throws NoHayProductoException, PagoInsuficienteException {

        IndiceProductos indice = switch (codigo) {
            case 1  -> IndiceProductos.CocaCola;
            case 2  -> IndiceProductos.Sprite;
            case 3  -> IndiceProductos.Fanta;
            case 4  -> IndiceProductos.Super8;
            case 5  -> IndiceProductos.Snickers;
            default -> {
                soltarSaldo();
                throw new NoHayProductoException();
            }
        };
        if (indice.precio > saldo){
            soltarSaldo();
            throw new PagoInsuficienteException();
        }
        int vuelto = saldo - indice.precio;
        saldo = 0;
        monedasGanadas.dumpDeposito(monedasSaldo);

        MonedaFactory generador = MonedaFactory.obtenerGen();
        int monedas1000 = vuelto / 1000;
        vuelto %= 1000;
        int monedas500 = vuelto / 500;
        vuelto %= 500;
        int monedas100 = vuelto / 100;

        for(int i = 0; i < monedas1000; i++){
            monedasVuelto.addObjeto(generador.generarMoneda1000());
        }
        for(int i = 0; i < monedas500; i++){
            monedasVuelto.addObjeto(generador.generarMoneda500());
        }
        for(int i = 0; i < monedas100; i++){
            monedasVuelto.addObjeto(generador.generarMoneda100());
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

    //no me gusta
    public void rellenarDeposito(int codigo, int n) {
        ProductoFactory generador = ProductoFactory.obtenerGen();
        switch (codigo) {
            case 1 -> {
                for (int i = 0; i < n; i++){
                    cocacola.addObjeto(generador.generarCocaCola());
                }
            }
            case 2 -> {
                for(int i = 0; i < n; i++){
                    fanta.addObjeto(generador.generarFanta());
                }
            }
            case 3 -> {
                for(int i = 0; i < n; i++){
                    sprite.addObjeto(generador.generarSprite());
                }
            }
            case 4 -> {
                for(int i = 0; i < n; i++){
                    super8.addObjeto(generador.generarSuper8());
                }
            }
            case 5 -> {
                for(int i = 0; i < n; i++){
                    snicker.addObjeto(generador.generarSnickers());
                }
            }
            default -> {
                return;
            }
        };
    }

}
