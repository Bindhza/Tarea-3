package modelo;

/**
 * Clase abstracta que representa un objeto comestible que se puede comprar
 */
public abstract class Producto {
    protected final int precio;
    protected final int serie;
    protected final IndiceProductos indice;

    public Producto(int serie, IndiceProductos indice) {
        this.serie = serie;
        this.precio = indice.precio;
        this.indice = indice;
    }

    public IndiceProductos getIndice(){
        return indice;
    }
    public int getSerie(){
        return serie;
    }
}
