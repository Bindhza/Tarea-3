package modelo;

/**
 * Enumeracion que guarda el nombre y el sabor de todos los productos que distribuye una maquina expendedora
 */
public enum IndiceProductos {
    CocaCola (1,700,"cocacola"),
    Sprite   (2,700,"sprite"),
    Fanta    (3,800,"fanta"),
    Super8   (4,300,"super8"),
    Snickers (5,500,"snickers");

    final int codigo;
    final int precio;
    final String nombre;
    IndiceProductos(int codigo, int precio, String nombre) {
        this.codigo = codigo;
        this.precio = precio;
        this.nombre = nombre;
    }

}
