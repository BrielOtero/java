import java.util.*;

public class Boletin9 {

    /**
     * Calcula el factorial de un número
     * 
     * @param numero Valor al que se le calculara el factorial
     * @return El factorial de un número
     */
    public static double factorial(double numero) {
        double factorial = 1;
        if (numero == 0) {
            return 1;
        } else {
            for (double i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }
            return factorial;
        }
    }

    /**
     * Calcula el Binomio de Newton.
     * 
     * @param m Valor m que se usar para los calculos de un Binomio de Newton.
     * @param n Valor n que se usar para los calculos de un Binomio de Newton.
     * @return El coeficiente de un Binomio de Newton
     */
    public static double binomioNewton(double m, double n) {
        return factorial(m) / (factorial(n) * factorial(m - n));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double valorM, valorN;

        System.out.println("Normas:");
        System.out.println("M y N tienen que ser mayores que 0");
        System.out.println("M tiene que ser mayor o igual a N");
        do {
            System.out.println("Introduce M: ");
            valorM = sc.nextDouble();
            System.out.println("Introduce N: ");
            valorN = sc.nextDouble();
        } while (valorM <= 0 || valorN <= 0 || valorM < valorN);

        System.out.println(binomioNewton(valorM, valorN));
    }
}
