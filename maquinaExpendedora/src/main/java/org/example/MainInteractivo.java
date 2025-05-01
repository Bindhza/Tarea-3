package org.example;
import java.util.Scanner;

public class MainInteractivo {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Expendedor maquina = null;
        maquina = crearExpendedor(scan);

        System.out.println("\n\n*******************************************");
        System.out.println("*   Bienvenido a la maquina expendedora   *");
        System.out.println("*******************************************");
        System.out.println(" ");
        System.out.println("-------------------------------------------");
        System.out.println(" ");

        boolean terminado = false;
        while (!terminado) {

            Moneda m = seleccionarMoneda(scan);
            int codigoProducto = seleccionarProducto(scan);

            try {
                Comprador cp = new Comprador(m,codigoProducto,maquina);
                System.out.println("Usted ha comprado un/a " + cp.queCompraste());
                System.out.println("Su vuelto es de $" + cp.cuantoVuelto());

            } catch (PagoIncorrectoException e) {
                System.out.println("Error : La moneda entregada es invalida.");
            } catch (PagoInsuficienteException e) {
                System.out.println("Error: dinero insuficiente");
            } catch (NoHayProductoException e) {
                System.out.println("Lo sentimos, el producto comprado se encuentra fuera de stock");
            } finally {
                if (!confirmarEleccion(scan,"Operacion terminada. ¿Desea seguir comprando? (Si/No)")){
                    terminado = true;
                }
            }


        }

        }



    private static int seleccionarProducto(Scanner scan) {
        int codigoProducto = -1;
        System.out.println("Que producto desea comprar?");
        System.out.println("   1.  Coca-Cola");
        System.out.println("   2.  Sprite");
        System.out.println("   3.  Fanta");
        System.out.println("   4.  Sniker");
        System.out.println("   5.  Super 8");
        while(codigoProducto == -1){
            codigoProducto = switch (scan.nextInt()) {
                case 1 -> Expendedor.COCACOLA;
                case 2 -> Expendedor.SPRITE;
                case 3 -> Expendedor.FANTA;
                case 4 -> Expendedor.SNIKERS;
                case 5 -> Expendedor.SUPER8;
                default -> {
                    System.out.print("\nSeleccion incorrecta, intente nuevamente: ");
                    yield -1;
                }

            };
            scan.nextLine();
        }
        return codigoProducto;
    }

    private static Moneda seleccionarMoneda(Scanner scan) {
        Moneda m = null;

        System.out.println("Con que moneda desea pagar? (Seleccione solo una opcion)");
        System.out.println("   1.  100");
        System.out.println("   2.  500");
        System.out.println("   3.  1000");

        while (m == null) {
            int seleccion = scan.nextInt();
            scan.nextLine();
            switch (seleccion) {
                case 1 -> m = new Moneda100();
                case 2 -> m = new Moneda500();
                case 3 -> m = new Moneda1000();
                default -> System.out.println("Opcion invalida, seleccione nuevamente:");
            }
        }
        return m;
    }

    private static Expendedor crearExpendedor(Scanner scan) {
        Expendedor maquina = null;
        while (maquina == null){
            System.out.println("Cuantos productos tendra su maquina expendedora?");
            int seleccion = scan.nextInt();
            scan.nextLine();
            if (seleccion > 0){
                maquina = new Expendedor(seleccion);
            } else {
                System.out.println("Cantidad invalida, ingrese denuevo");
            }

        }
        return maquina;
    }

    private static boolean confirmarEleccion(Scanner scan, String mensaje) {
        while (true) {
            System.out.println(mensaje);
            String entrada = scan.nextLine();
            switch (entrada.toUpperCase()) {
                case "SI" -> {
                    return true;
                }
                case "NO" -> {
                    return false;
                }
                default -> System.out.println("Seleccion invalida, intente denuevo");
            }
        }
    }
}
