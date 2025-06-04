package modelo;

/**
 * Clase abstracta que representa un objeto que se puede beber
 */
public abstract class Bebida extends Producto{
    public Bebida (int serie, IndiceProductos indice){
        super(serie,indice);
    }

    /**
     * Bebe la bebida y retorna su sabor
     * @return sabor de la bebida
     */

    public String beber(){
        return indice.nombre;
    }
}
