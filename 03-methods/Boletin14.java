import java.util.*;

public class Boletin14 {

    /**
     * Calcula la tangente de un número dada en radianes.
     * 
     * @param numeroX Número al que le calcularemos la tangente.
     * @return La tangente de un número.
     */
    // (tan(x)=sen(x)/cos(x))
    public static double tangente(double numeroX) {
        return Math.sin(numeroX) / Math.cos(numeroX);
    }

    /**
     * Convierte un ángulo de grados a radianes.
     * 
     * @param numeroConvertir Número que convertiremos de grados a radianes.
     * @return Un número en radianes.
     */
    public static double conversor(double numeroConvertir) {
        return numeroConvertir * Math.PI / 180;
    }

    /**
     * Pide al usuario un número con un mensaje personalizado según la situación.
     * 
     * @param conversionSiNo Valor que se usa para determinar True si esta en
     *                       Grados, False si está en radianes.
     * @param senCosTan      Valor que se usa para determinar 1 Coseno, 2 Seno y 3
     *                       Tangente.
     * @return Un número introducido por el usuario.
     */
    public static double pedir(boolean conversionSiNo, int senCosTan) {
        Scanner sc = new Scanner(System.in);

        double angulo;
        String textConversionSiNo = "Prueba", textoSenCosTan = "Prueba";

        if (conversionSiNo) {
            textConversionSiNo = "Grados";
        } else {
            textConversionSiNo = "Radian";
        }
        switch (senCosTan) {
        case 1:
            textoSenCosTan = "el Cose";
            break;
        case 2:
            textoSenCosTan = "el Seno";
            break;
        case 3:
            textoSenCosTan = "la Tang";
            break;
        }
        System.out.println("+-----------------------------+");
        System.out.println("|    Introduce un angulo en   |");
        System.out.println("|     " + textConversionSiNo + " para calcular    |");
        System.out.println("|           " + textoSenCosTan + "           |");
        System.out.println("+-----------------------------+");
        angulo = sc.nextDouble();
        return angulo;
    }

    /**
     * Muestra esta en pantalla un mensaje con el resultado.
     * @param resultado Número que se mostrará como resultado.
     * @param unidad La unidad de medida que se usará para acompañar al número.
     */
    public static void mostrarResultado(double resultado, String unidad) {
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("+-----------------------------+");
        System.out.println("|         El resultado:       |");
        System.out.println("+-----------------------------+");
        System.out.println("   " + resultado + " " + unidad);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu, menuConversion;
        boolean conversion = true;
        String unidad = "Prueba";

        System.out.println("\033[H\033[2J");
        System.out.flush();

        do {
            System.out.println("+-----------------------------+");
            System.out.println("|   En que quieres trabajar?  |");
            System.out.println("+-----------------------------+");
            System.out.println("|          1.Grados           |");
            System.out.println("|          2.Radianes         |");
            System.out.println("+-----------------------------+");
            menuConversion = sc.nextInt();
        } while (menuConversion != 1 && menuConversion != 2);

        switch (menuConversion) {
        case 1:
            conversion = true;
            unidad = "Grados";
            break;
        case 2:
            conversion = false;
            unidad = "Radianes";
            break;
        default:
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("+-----------------------------+");
            System.out.println("|      ERROR: Elige 1 o 2     |");
            break;
        }
        System.out.println("\033[H\033[2J");
        System.out.flush();

        do {
            System.out.println("+-----------------------------+");
            System.out.println("|      Elige una opcion:      |");
            System.out.println("+-----------------------------+");
            System.out.println("|     1.Coseno de un angulo   |");
            System.out.println("|     2.Seno de un angulo     |");
            System.out.println("|     3.Tangente de un angulo |");
            System.out.println("|     4.Salir                 |");
            System.out.println("+-----------------------------+");
            menu = sc.nextInt();
            switch (menu) {
            case 1:
                if (conversion) {
                    mostrarResultado(Math.cos(conversor(pedir(conversion, 1))), unidad);
                } else {
                    mostrarResultado(Math.cos((pedir(conversion, 1))), unidad);
                }
                break;
            case 2:
                if (conversion) {
                    mostrarResultado(Math.sin(conversor(pedir(conversion, 2))), unidad);
                } else {
                    mostrarResultado(Math.sin((pedir(conversion, 2))), unidad);
                }
                break;
            case 3:
                if (conversion) {
                    mostrarResultado(tangente((conversor(pedir(conversion, 3)))), unidad);
                } else {
                    mostrarResultado(tangente(((pedir(conversion, 3)))), unidad);
                }
                break;
            case 4:
                break;
            default:
                System.out.println("\033[H\033[2J");
                System.out.flush();
                System.out.println("+-----------------------------+");
                System.out.println("|  ERROR: Elige 1, 2, 3 o 4   |");
                break;
            }
        } while (menu != 4);

    }
}
