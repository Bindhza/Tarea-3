/**
 * Maquina expendedora
 * @author Maximo Beltran
 * @author Benjamin Poblete
 */

package org.example;

public class Main {
    public static void main(String[] args) {

        Expendedor maquina = new Expendedor(4);
        Comprador comprador;
        Moneda pago = new Moneda1000();
        System.out.println(pago);
        try {
            comprador = new Comprador(pago , Expendedor.COCACOLA, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(comprador.cuantoVuelto());
        System.out.println(comprador.queCompraste());
        System.out.println();

        try {
            comprador = new Comprador(pago , Expendedor.COCACOLA, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }
        try {
            comprador = new Comprador(pago , Expendedor.COCACOLA, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }


        //Prueba de todos los producctos y sus metodos correspondientes
        try {
            comprador = new Comprador(pago , Expendedor.SNIKERS, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(comprador.cuantoVuelto());
        System.out.println(comprador.queCompraste());
        System.out.println();

        try {
            comprador = new Comprador(pago , Expendedor.SUPER8, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(comprador.cuantoVuelto());
        System.out.println(comprador.queCompraste());
        System.out.println();

        try {
            comprador = new Comprador(pago , Expendedor.SPRITE, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(comprador.cuantoVuelto());
        System.out.println(comprador.queCompraste());
        System.out.println();

        try {
            comprador = new Comprador(pago , Expendedor.FANTA, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }

        System.out.println(comprador.cuantoVuelto());
        System.out.println(comprador.queCompraste());
        System.out.println();

        /**
         * este caso muestra una excepcion de pago insuficiente
         *
        pago = new Moneda500();
        try {
            comprador = new Comprador(pago , Expendedor.COCACOLA, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }
         */

        /**
         * si se agrega esta linea de codigo da la excepcion de que no hay mas productos
         *
        try {
            comprador = new Comprador(pago , Expendedor.COCACOLA, maquina);
        } catch (PagoIncorrectoException e) {
            throw new RuntimeException(e);
        } catch (PagoInsuficienteException e) {
            throw new RuntimeException(e);
        } catch (NoHayProductoException e) {
            throw new RuntimeException(e);
        }
         */
    }
}