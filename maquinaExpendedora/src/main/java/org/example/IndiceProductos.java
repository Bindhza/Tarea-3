package org.example;

public enum IndiceProductos {
    CocaCola(700,"cocacola"),
    Sprite(750,"sprite"),
    Fanta(800,"fanta"),
    Super8(300,"super8"),
    Snickers(500,"snickers");

    final int precio;
    final String nombre;
    IndiceProductos(int precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }
}
