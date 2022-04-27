import java.util.*;

public class Boletin13 {

    /**
     * Saca un número aleatorio entre 1 y 10.
     * 
     * @return Un número al azar entre 1 y 10.
     */
    public static int coordenadaXCpu() {
        return (int) (Math.random() * 10 + 1);
    }

    /**
     * Muestra un mensaje en pantalla para que el usuario introduzca un número entre
     * 1 y 10 y lo recoge.
     * 
     * @return un número entre 1 y 10.
     */
    public static int coordenadaXUsuario() {
        System.out.println("================================================");
        System.out.println("Introduce la coordenada X (1-10):");
        return filtroX();
    }

    /**
     * Saca una letra aleatoria entre A y J.
     * 
     * @return Una letra al azar entre A y J.
     */
    public static char coordenadaYCpu() {
        return (char) (Math.random() * 10 + 'A');
    }

    /**
     * Muestra un mensaje en pantalla para que el usuario introduzca una letra entre
     * A y J la recoge.
     * 
     * @return una letra entre A y J.
     */
    public static char coordenadaYUsuario() {
        System.out.println("================================================");
        System.out.println("Introduce la coordenada Y (A-J):");
        return filtroY();
    }

    /**
     * Recoge un número entre 1 y 10. Muestrar error si el número no esta en el
     * rango y lo vuelve a pedir.
     * 
     * @return Un número entre 1 y 10.
     */
    public static int filtroX() {
        Scanner sc = new Scanner(System.in);
        int numero;
        do {
            numero = sc.nextInt();
            if (numero < 1 || numero > 10) {
                System.out.println("================================================");
                System.out.println("ERROR: entre 1-10");
            }
        } while (numero < 1 || numero > 10);

        return numero;
    }

    /**
     * Recoge una letra entre A y J. Muestrar error si la letra no esta en el rango
     * y la vuelve a pedir.
     * 
     * @return Una letra entre A y J.
     */
    public static char filtroY() {
        Scanner sc = new Scanner(System.in);
        String numero;
        char letra;
        do {
            numero = sc.nextLine().toUpperCase();
            letra = numero.charAt(0);
            if (letra < 'A' || letra > 'J') {
                System.out.println("================================================");
                System.out.println("ERROR: entre A-J");
            }
        } while (letra < 'A' || letra > 'J');

        return letra;
    }

    /**
     * Compara las coordenas X e Y con otras coordenadas X e Y de un rival.
     * 
     * @param coordenadaX         Número (o coordenada X) que usaremos para comparar
     *                            con su equivalente en el rival.
     * @param coordenadaXComparar Número (o coordenada x) del rival que usaremos
     *                            para comparar con su equivalente.
     * @param coordenadaY         Número (o coordenada Y) que usaremos para comparar
     *                            con su equivalente en el rival.
     * @param coordenadaYComparar Número (o coordenada x) del rival que usaremos
     *                            para comparar con su equivalente.
     * @return True si las dos coordenadas coinciden, False si alguna de las dos, o
     *         las dos no coindicen.
     */
    public static boolean comprobarDisp(int coordenadaX, int coordenadaXComparar, char coordenadaY,
            char coordenadaYComparar) {
        if (coordenadaX == coordenadaXComparar && coordenadaY == coordenadaYComparar) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int xCpu, xUsuario, dispUsuarioX, dispCpuX;
        char yCpu, yUsuario, dispUsuarioY, dispCpuY;
        boolean comprobacionUsuario, comprobacionCpu = false;
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println();
        System.out.println();
        System.out.println("                       |\\");
        System.out.println("                       | \\");
        System.out.println("                       |  \\");
        System.out.println("                       |___\\");
        System.out.println("               _____\\--|----/______");
        System.out.println("                     \\_____/");
        System.out.println("================================================");
        System.out.println("              HUNDIR   LA   FLOTA               ");
        yCpu = coordenadaYCpu();
        xCpu = coordenadaXCpu();
        yUsuario = coordenadaYUsuario();
        xUsuario = coordenadaXUsuario();

        // TEST Posiciones Barco Usuario y Cpu
        /*
        System.out.println("Barco Cpu " + yCpu + "," + xCpu);
        System.out.println("Barco Usuario " + yUsuario + "," + xUsuario);
        */

        do {
            System.out.println("================================================");
            System.out.println("A los cañones.............................FUEGO!");
            dispUsuarioY = coordenadaYUsuario();
            dispUsuarioX = coordenadaXUsuario();
            comprobacionUsuario = comprobarDisp(dispUsuarioX, xCpu, dispUsuarioY, yCpu);

            // TEST Disparo Usuario
            /*
             * System.out.println(comprobacionUsuario);
             * System.out.println("Disparo Usuario " + dispUsuarioY + "," + dispUsuarioX);
             */

            if (!comprobacionUsuario) {
                System.out.println("================================================");
                System.out.println("AGUA!!!.............................Fallaste!!!!");
                dispCpuY = coordenadaYCpu();
                dispCpuX = coordenadaXCpu();
                comprobacionCpu = comprobarDisp(dispCpuX, xUsuario, dispCpuY, yUsuario);

                // TEST Disparo Cpu
                /*
                 * System.out.println("Disparo Cpu " + dispCpuY + "," + dispCpuX);
                 * System.out.println(comprobacionCpu);
                 */

            }
        } while (comprobacionUsuario == false && comprobacionCpu == false);

        if (comprobacionUsuario) {
            System.out.println("================================================");
            System.out.println("BOOOOOOMMMMMMM!");
            System.out.println("Has destruido el barco enemigo!!");
            System.out.println("El barco enemigo estaba en " + yCpu + "," + xCpu);
        } else {
            System.out.println("================================================");
            System.out.println("BOOOOOOMMMMMMM!");
            System.out.println();
            System.out.println("Vaya.......creo que te vas a tener que ir");
            System.out.println("nadando a casa.");
            System.out.println();
            System.out.println("Te has quedado sin barco :(");
            System.out.println("El barco enemigo estaba en " + yCpu + "," + xCpu);
        }
    }

}
