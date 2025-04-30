package org.example;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String entrada;
        int seleccion;
        Moneda monedaPago = null;
        Comprador usuario;
        Expendedor maquina;

        System.out.println("Cuantos productos tendra su maquina expendedora?");
        seleccion = scan.nextInt();
        maquina = new Expendedor(seleccion);

        System.out.println("");
        System.out.println("");


        System.out.println("*******************************************");
        System.out.println("*   Bienvenido a la maquina expendedora   *");
        System.out.println("*******************************************");
        System.out.println("");
        System.out.println("-------------------------------------------");
        System.out.println("");

        int salida = 1;
        while(salida != 0){

            System.out.println("Desea comprar algun producto? (Si/No)");
            entrada = scan.nextLine();
            entrada = entrada.toUpperCase();
            System.out.println();
            System.out.println();

            if(entrada == "NO"){salida = 0;}
            else if(entrada == "SI"){
                System.out.println("Con que moneda desea pagar?(seleccione una opcion)");
                System.out.println("   1.  100");
                System.out.println("   2.  500");
                System.out.println("   3.  1000");
                System.out.println();


                seleccion = 8;  //para que entre al while
                while(seleccion != 1 || seleccion != 2 || seleccion != 3) {
                    seleccion = scan.nextInt();
                    System.out.println("");
                }
                switch (seleccion) {
                        case 1:
                            monedaPago = new Moneda100();
                            System.out.println();
                            break;
                        case 2:
                            monedaPago = new Moneda500();
                            break;
                        case 3:
                            monedaPago = new Moneda1000();
                            break;
                        default:
                                System.out.println("Opcion invalida, seleccione nuevamente:");

                                System.out.println();
                                System.out.println("   1.  100");
                                System.out.println("   2.  500");
                                System.out.println("   3.  1000");
                                System.out.println();
                            break;
                }


                System.out.println("");
                System.out.println("Que producto desea comprar?");
                System.out.println("   1.  Coca-Cola");
                System.out.println("   2.  Sprite");
                System.out.println("   3.  Fanta");
                System.out.println("   4.  Sniker");
                System.out.println("   5.  Super 8");

                System.out.println();

                seleccion = scan.nextInt();
                System.out.println("");


                seleccion = 14; // para que entre al while
                while(seleccion  != 1 || seleccion  !=2 || seleccion  != 3 || seleccion  != 4 || seleccion  != 5) {
                    seleccion = scan.nextInt();
                    System.out.println("");
                    switch (seleccion) {

                        case 1:
                            try {
                                usuario = new Comprador(monedaPago, Expendedor.COCACOLA, maquina);
                            } catch (PagoIncorrectoException e) {
                                System.out.println("OCURRIO UN ERROR AL MOMENTO DE REALIZAR SU PAGO");
                                return;
                            } catch (PagoInsuficienteException e) {
                                System.out.println("EROR: Dinero insuficiente");
                                break;
                            } catch (NoHayProductoException e) {
                                System.out.println("Error: No hay stock de su producto");
                                break;
                            }
                            System.out.println("Usted a comprado una " + usuario.queCompraste());
                            System.out.println("Su vuelto es de: $" + usuario.cuantoVuelto());

                        case 2:
                            try {
                                usuario = new Comprador(monedaPago, Expendedor.SPRITE, maquina);
                            } catch (PagoIncorrectoException e) {
                                System.out.println("OCURRIO UN ERROR AL MOMENTO DE REALIZAR SU PAGO");
                                return;
                            } catch (PagoInsuficienteException e) {
                                System.out.println("EROR: Dinero insuficiente");
                                break;
                            } catch (NoHayProductoException e) {
                                System.out.println("Error: No hay stock de su producto");
                                break;
                            }
                            System.out.println("Usted a comprado una " + usuario.queCompraste());
                            System.out.println("Su vuelto es de: $" + usuario.cuantoVuelto());
                        case 3:
                            try {
                                usuario = new Comprador(monedaPago, Expendedor.FANTA, maquina);
                            } catch (PagoIncorrectoException e) {
                                System.out.println("OCURRIO UN ERROR AL MOMENTO DE REALIZAR SU PAGO");
                                return;
                            } catch (PagoInsuficienteException e) {
                                System.out.println("EROR: Dinero insuficiente");
                                break;
                            } catch (NoHayProductoException e) {
                                System.out.println("Error: No hay stock de su producto");
                                break;
                            }
                            System.out.println("Usted a comprado una " + usuario.queCompraste());
                            System.out.println("Su vuelto es de: $" + usuario.cuantoVuelto());
                        case 4:
                            try {
                                usuario = new Comprador(monedaPago, Expendedor.SNIKERS, maquina);
                            } catch (PagoIncorrectoException e) {
                                System.out.println("OCURRIO UN ERROR AL MOMENTO DE REALIZAR SU PAGO");
                                return;
                            } catch (PagoInsuficienteException e) {
                                System.out.println("EROR: Dinero insuficiente");
                                break;
                            } catch (NoHayProductoException e) {
                                System.out.println("Error: No hay stock de su producto");
                                break;
                            }
                            System.out.println("Usted a comprado una " + usuario.queCompraste());
                            System.out.println("Su vuelto es de: $" + usuario.cuantoVuelto());
                        case 5:
                            try {
                                usuario = new Comprador(monedaPago, Expendedor.SUPER8, maquina);
                            } catch (PagoIncorrectoException e) {
                                System.out.println("OCURRIO UN ERROR AL MOMENTO DE REALIZAR SU PAGO");
                                return;
                            } catch (PagoInsuficienteException e) {
                                System.out.println("EROR: Dinero insuficiente");
                                break;
                            } catch (NoHayProductoException e) {
                                System.out.println("Error: No hay stock de su producto");
                                break;
                            }
                            System.out.println("Usted a comprado una " + usuario.queCompraste());
                            System.out.println("Su vuelto es de: $" + usuario.cuantoVuelto());
                        default:
                            System.out.println("Opcion invalida, seleccione nuevamente:");

                            System.out.println();
                            System.out.println("   1.  Coca-Cola");
                            System.out.println("   2.  Sprite");
                            System.out.println("   3.  Fanta");
                            System.out.println("   4.  Sniker");
                            System.out.println("   5.  Super 8");
                            System.out.println();


                    }
                }
            }
        }
    }
}