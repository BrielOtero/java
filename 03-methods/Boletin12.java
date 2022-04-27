public class Boletin12 {
    /**
     * Saca dos números al azar entre 1-6 y los suma y muestra todo esto en
     * pantalla.
     * 
     * @return Devuelve la suma entre dos números aleatorios.
     */
    public static int tirada() {
        int dado1 = (int) (Math.random() * 6 + 1);
        int dado2 = (int) (Math.random() * 6 + 1);
        System.out.println("Resultado Dado 1: " + dado1);
        System.out.println("Resultado Dado 2: " + dado2);
        System.out.println("===========================");
        System.out.println("La suma de los dados es: " + (dado1 + dado2));
        System.out.println("===========================");
        return dado1 + dado2;
    }

    /**
     * Comprobación del juego craps.
     * 
     * @param numeroDados Número que compararemos.
     * @return "0" si el numero que comparamos es igual a 7 o 12. "-1" si es igual a
     *         2 o 3 o 12. "el número que usabamos para comparar" si este esta entre
     *         4-10 distinto de 7.
     */
    public static double comprobacion(int numeroDados) {
        if (numeroDados == 7 || numeroDados == 11) {
            return 0;
        }
        if (numeroDados == 2 || numeroDados == 3 || numeroDados == 12) {
            return -1;
        }
        // if (numeroDados >= 4 && numeroDados <= 10 && numeroDados != 7) {
        return numeroDados;
    }

    public static void main(String[] args) {
        System.out.println("Turno del jugador");
        System.out.println("===========================");
        double turnoJugador = comprobacion(tirada()), turnoCpu;
        if (turnoJugador == 0) {
            System.out.println("GANASTE!!");
        } else {
            if (turnoJugador == -1) {
                System.out.println("PERDISTE!!");
            } else {
                System.out.println("Turno de la CPU");
                System.out.println("===========================");
                turnoCpu = comprobacion(tirada());

                if (turnoCpu == 0) {
                    System.out.println("La CPU GANO!!!");
                } else {
                    if (turnoCpu == -1) {
                        System.out.println("Le GANASTE a la CPU ");
                    } else {
                        if (turnoJugador > turnoCpu) {
                            System.out.println("Le GANASTE a la CPU ");
                        } else {
                            if (turnoJugador < turnoCpu) {
                                System.out.println("El JUGADOR saco " + turnoJugador + " la CPU saco " + turnoCpu);
                                System.out.println("PERDISTE contra la CPU ");
                            } else {
                                System.out.println("El JUGADOR saco " + turnoJugador + " la CPU saco " + turnoCpu);
                                System.out.println("EMPATASTE contra la CPU ");
                            }
                        }
                    }
                }
            }
        }

    }

}
