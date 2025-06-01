package modelo;


/**
 * Clase abstracta que representa un dulce que se puede comer
 */
public abstract class Dulce extends Producto{

    public Dulce(int precio,String sabor){
        super(precio,sabor);
    }

    /**
     * Come el dulce y registra su sabor
     * @return sabor del dulce
     */
    public String comer(){
        return sabor;
    }
}
