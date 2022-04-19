import java.util.*;

public class Boletin7 {
    /**
     * Comprueba si dos numeros son iguales, o si uno es mayor que otro.
     * 
     * @param numero1 Numero del jugador 1.
     * @param numero2 Numero del jugador 2.
     * @return 0 si el numero del jugador 1 es menor, 2 si el numero del jugador 1
     *         es mayor y 1 si los números de jugador 1 y 2 son iguales.
     */
    public static int menorIgualMayor(int numero1, int numero2) {
        /**
         * switch (){ case 0: break; case 1: break; case 2: break; default:
         * System.out.println("Opción no valida"); break; }
         */
        if (numero1 < numero2) {
            return 0;
        } else {
            if (numero1 > numero2) {
                return 2;
            } else {
                return 1;
            }
        }
    }

    /**
     * Pide un número hasta que este esté entre 1 y 100.
     * 
     * @return El número entre 1 y 100 que el usuario eligió.
     */
    public static int numeroJugadores() {
        Scanner sc = new Scanner(System.in);
        int numeroJugador;
        do {
            System.out.println("Introduce un número entre 1 y 100: ");
            numeroJugador = sc.nextInt();
            if (numeroJugador > 100 || numeroJugador <= 0) {
                System.out.println("ERROR: El número tiene que estar entre 1 y 100");
            }

        } while (numeroJugador > 100 || numeroJugador <= 0);

        return numeroJugador;

    }

    /**
     * Pide un número a un jugador (player2),(Este tiene 5 intentos) y comprueba si
     * es mayor, menor, si ganaste o perdiste con repecto a otro jugador(player1).
     * 
     * @param player1 Numero del jugador 1 (player1) contra el que compite el
     *                jugador 2 (player2).
     */
    public static void ganadorPerdedor(int player1) {
        int player2 = 0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 5; i > 0; i--) {
            System.out.println("Te quedan " + i + " intentos.");
            System.out.println();
            player2 = numeroJugadores();
            System.out.println(player1);
            System.out.println(player2);

            System.out.print("\033[H\033[2J");
            System.out.flush();

            switch (menorIgualMayor(player1, player2)) {
            case 0:
                System.out.println("El número es menor");
                break;
            case 1:
                System.out.println("ACERTASTE, GANASTE!!");
                i = 0;
                break;
            case 2:
                System.out.println("El número es mayor");
                break;
            }
        }
        if (menorIgualMayor(player1, player2) != 1) {
            System.out.println("Perdiste, te quedaste sin intentos!");
            System.out.println("El número era " + player1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int menu, repetir = 0;
        do {
            System.out.println("Modo de juego: ");
            System.out.println("1. Un jugador.");
            System.out.println("2. Dos jugadores.");
            menu = sc.nextInt();
            switch (menu) {
            case 1:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                ganadorPerdedor((int) (Math.random() * 100 + 1));
                break;
            case 2:
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Jugador 1");
                System.out.println();
                ganadorPerdedor(numeroJugadores());

                break;
            default:
                System.out.println("Opción no valida");
                break;
            }
            System.out.println("Quieres volver a jugar: ");
            System.out.println("0. Si.");
            System.out.println("1. No.");
            repetir = sc.nextInt();

        } while (repetir != 1);
    }
}
