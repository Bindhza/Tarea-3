package modelo;

/**
 * Clase abstracta que representa un objeto comestible que se puede comprar
 */
public abstract class Producto {
    protected final int precio;
    protected final String sabor;
    protected final int serie;

    public Producto(int precio, String sabor, int serie){
        this.serie = serie;
        this.precio = precio;
        this.sabor = sabor;
    }

    public int getSerie(){
        return serie;
    }
}
