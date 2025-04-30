package org.example;

public class Expendedor {
    final private Deposito<Moneda> monedas;
    final private Deposito<CocaCola> cocacola;
    final private Deposito<Fanta> fanta;
    final private Deposito<Sprite> sprite;
    final private Deposito<Snickers> snicker;
    final private Deposito<Super8> super8;

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

    public Moneda getVuelto(){
        return monedas.getObjeto();
    }

    public Producto comprar(Moneda moneda, int codigo) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {
        if (moneda == null){throw new PagoIncorrectoException();}
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
        int vuelto = (indice.precio - moneda.getValor())/100;

        for(int i = 0; i < vuelto; i++){
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
