package modelo;

/**
 * Clase que representa una bebida Sprite
 */
public class Sprite extends Bebida{
    public Sprite(int serie){
        super(IndiceProductos.Sprite.precio, IndiceProductos.Sprite.nombre,serie);
    }
}
