package org.example;

/**
 * Enumeracion que guarda el nombre y el sabor de todos los productos que distribuye una maquina expendedora
 */
public enum IndiceProductos {
    CocaCola (700,"cocacola"),
    Sprite   (700,"sprite"),
    Fanta    (800,"fanta"),
    Super8   (300,"super8"),
    Snickers (500,"snickers");

    final int precio;
    final String nombre;
    IndiceProductos(int precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    /**
     * regresa el precio del producto
     * @return el precio del producto
     */
    public int getPrecio() {return precio;}

    /**
     * regresa el nombre del producto
     * @return el nombre del producto
     */
    public String getNombre() {return nombre;}
}
