import java.util.*;

public class Boletin4 {
    /**
     * Calcula la potencia de un número
     * 
     * @param base      La base del numero al que le calcularemos la potencia
     * @param exponente El exponente del numero al que le calcularemos la potencia
     * @return Potencia de un número
     */

    public static double potencia(double base, double exponente) {
        double calculos = 1;

        if (exponente >= 0) {

            for (int i = 0; i < exponente; i++) {
                calculos = base * calculos;
            }
            return calculos;
        } else {
            if (exponente == 0) {
                return 1;

            } else {
                for (int i = 0; i > exponente; i--) {
                    calculos = base * calculos;
                }
                return (1 / calculos);
            }
        }
    }

    /**
     * Muestra las n potencia de un número
     * 
     * @param n Cantidad de potencia que se mostraran
     * @param a Número del que se mostraran las potencias
     */
    public static void nPotencias(double n, double a) {
        for (double i = 0; i < n; i++) {
            System.out.println(potencia(a, i));
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double baseUsuario, exponenteUsuario, baseNPotencias, exponenteNPotencias;

        System.out.println("Introduce la base: ");
        baseUsuario = sc.nextDouble();
        System.out.println("Introduce el exponente: ");
        exponenteUsuario = sc.nextDouble();

        System.out.println(potencia(baseUsuario, exponenteUsuario));

        System.out.println("Introduce el n?mero: ");
        baseNPotencias = sc.nextDouble();
        System.out.println("Introduce la cantidad de exponentes: ");
        exponenteNPotencias = sc.nextDouble();

        nPotencias(exponenteNPotencias, baseNPotencias);
    }
}
