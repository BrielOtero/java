import java.util.*;

public class Boletin2 {

    /**
     * Pide un numero positivo al usuario
     * 
     * @return El número Positivo
     */

    public static double pedirDato() {
        double numero;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Introduce un numero: ");
            numero = sc.nextDouble();
        } while (numero < 0);

        return numero;

    }

    /**
     * Calcula la superficie de un cilindro
     * 
     * @param radio  El radio del cilindro
     * @param altura La altura del cilindro
     * @return La superficie del silindro
     */
    public static double superficieCilindro(double radio, double altura) {
        double superficie = (2 * Math.PI * radio * altura);
        return superficie;

    }

    /**
     * Muestra un número con 3 decimales
     * 
     * @param real Número real al que le aaplicaremos el formato de 3 decimales
     */

    public static void mostrarDato(double real) {
        System.out.printf("%.3f", real);

    }

    public static void main(String[] args) {

        mostrarDato(superficieCilindro(pedirDato(), pedirDato()));

    }

}
