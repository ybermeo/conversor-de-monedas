import java.util.Scanner;

/**
 * @author ybermeo
 * @since 1.0.0
 **/

// Aplicación Desarrollada en Java para la conversión de divisas
public class Principal {

    // Punto de inicio de la aplicación
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            Menu.mostrarMenu();

            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("\nOpción incorrecta... Intente de nuevo.");
                Menu.mostrarMenu();
            }
            opcion = scanner.nextInt();

            if (opcion == 7) {
                System.out.println("\nSe finalizo el programa.");
                break;
            } else {
                switch (opcion) {
                    case 1: // USD → MXN
                        System.out.print("\nIngrese cantidad en dólares: ");
                        double usd1 = scanner.nextDouble();
                        double tasaMXN = ServicioCambio.obtenerTasaCambio("MXN");
                        if (tasaMXN > 0) {
                            System.out.printf("Resultado: %.2f USD = %.2f MXN\n", usd1, usd1 * tasaMXN);
                        } else {
                            System.out.println("No se pudo obtener la tasa de cambio.");
                        }
                        break;

                    case 2: // MXN → USD
                        System.out.print("\nIngrese cantidad en pesos mexicanos: ");
                        double mxn = scanner.nextDouble();
                        double tasaMXNtoUSD = ServicioCambio.obtenerTasaCambio("MXN");
                        if (tasaMXNtoUSD > 0) {
                            System.out.printf("Resultado: %.2f MXN = %.2f USD\n", mxn, mxn / tasaMXNtoUSD);
                        } else {
                            System.out.println("No se pudo obtener la tasa de cambio.");
                        }
                        break;

                    case 3: // USD → ARS
                        System.out.print("\nIngrese cantidad en dólares: ");
                        double usd2 = scanner.nextDouble();
                        double tasaARS = ServicioCambio.obtenerTasaCambio("ARS");
                        if (tasaARS > 0) {
                            System.out.printf("Resultado: %.2f USD = %.2f ARS\n", usd2, usd2 * tasaARS);
                        } else {
                            System.out.println("No se pudo obtener la tasa de cambio.");
                        }
                        break;

                    case 4: // ARS → USD
                        System.out.print("\nIngrese cantidad en pesos argentinos: ");
                        double ars = scanner.nextDouble();
                        double tasaARStoUSD = ServicioCambio.obtenerTasaCambio("ARS");
                        if (tasaARStoUSD > 0) {
                            System.out.printf("Resultado: %.2f ARS = %.2f USD\n", ars, ars / tasaARStoUSD);
                        } else {
                            System.out.println("No se pudo obtener la tasa de cambio.");
                        }
                        break;

                    case 5: // USD → COP
                        System.out.print("\nIngrese cantidad en dólares: ");
                        double usd3 = scanner.nextDouble();
                        double tasaCOP = ServicioCambio.obtenerTasaCambio("COP");
                        if (tasaCOP > 0) {
                            System.out.printf("Resultado: %.2f USD = %.2f COP\n", usd3, usd3 * tasaCOP);
                        } else {
                            System.out.println("No se pudo obtener la tasa de cambio.");
                        }
                        break;

                    case 6: // COP → USD
                        System.out.print("\nIngrese cantidad en pesos colombianos: ");
                        double cop = scanner.nextDouble();
                        double tasaCOPtoUSD = ServicioCambio.obtenerTasaCambio("COP");
                        if (tasaCOPtoUSD > 0) {
                            System.out.printf("Resultado: %.2f COP = %.2f USD\n", cop, cop / tasaCOPtoUSD);
                        } else {
                            System.out.println("No se pudo obtener la tasa de cambio.");
                        }
                        break;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        break;
                }

            }
        } while (true);
    }
}
