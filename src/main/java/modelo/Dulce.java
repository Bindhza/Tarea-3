package modelo;


/**
 * Clase abstracta que representa un dulce que se puede comer
 */
public abstract class Dulce extends Producto{

    public Dulce(int serie, IndiceProductos indice){
        super(serie, indice);
    }

    /**
     * Come el dulce y registra su sabor
     * @return sabor del dulce
     */
    public String comer(){
        return indice.nombre;
    }
}
