import java.util.*;

public class Boletin10 {
    /**
     * Saca un variable ("1", "x" o "2") aleatoriamente.
     * 
     * @return Un 1, X o 2 aleatoriamente.
     */
    public static char resultado() {

        switch ((int) (Math.random() * 3 + 1)) {
        case 1:
            return '1';
        case 2:
            return 'X';
        case 3:
            return '2';
        }
        return '\0';
    }

    /**
     * Saca un variable ("1", "x" o "2") aleatoriamente ponderada (60% 1, 25% X, 2 15%).
     * 
     * @return 1, X o 2.
     */
    public static char resultadoPonderado() {
        int comparar = (int) (Math.random() * 100 + 1);

        if (comparar <= 60) {
            return '1';
        } else {
            if ( comparar <= 85) {
                return 'X';
            } else {
                return '2';
            }
        }

    }

    /**
     * Muestra en pantalla el resultado del partido.
     * 
     * @param ponderadaONo Valor que nos dice si es ponderado (True) o no (False).
     */
    public static void quinielaAleatoria(boolean ponderadaONo) {
        if (ponderadaONo == false) { // !ponderadaONo
            for (int i = 0; i <= 14; i++) {
                System.out.printf("Resultado partido %2d : %c\n", i, resultado());
            }
        } else {
            for (int i = 0; i <= 14; i++) {
                System.out.printf("Resultado partido %2d : %c\n", i, resultadoPonderado());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;

        System.out.println("Elige una opción: ");
        System.out.println("1. Normal");
        System.out.println("2. Ponderada");
        menu = sc.nextInt();
        switch (menu) {
        case 1:
            quinielaAleatoria(false);
            break;
        case 2:
            quinielaAleatoria(true);
            break;
        default:
            System.out.println("Opción no válida");
            break;
        }
    }
}
