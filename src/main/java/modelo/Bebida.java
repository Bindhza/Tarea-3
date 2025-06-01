package modelo;

/**
 * Clase abstracta que representa un objeto que se puede beber
 */
public abstract class Bebida extends Producto{
    public Bebida (int precio, String sabor){
        super(precio,sabor);
    }

    /**
     * Bebe la bebida y retorna su sabor
     * @return sabor de la bebida
     */

    public String beber(){
        return sabor;
    }
}
