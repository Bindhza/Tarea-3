/**
 * Maquina expendedora
 * @author Maximo Beltran
 * @author Benjamin Poblete
 */

package org.example;

public class Main {
    public static void main(String[] args) {

        Expendedor maquina = new Expendedor(7);
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
    }
}