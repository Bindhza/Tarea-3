package modelo;

/**
 * Clase que representa una Coca Cola
 */
public class CocaCola extends Bebida{
    public CocaCola(int codigo){
        super(IndiceProductos.CocaCola.precio, IndiceProductos.CocaCola.nombre,codigo);
    }
}
