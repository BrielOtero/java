import java.util.*;

public class Boletin11 {

    /**
     * Comprueba si tres números coinciden con 2 números aleatorios.
     * 
     * @param numero1 Número 1 que compararemos con los aleatorios.
     * @param numero2 Número 2 que compararemos con los aleatorios.
     * @param numero3 Número 1 que compararemos con los aleatorios.
     */
    public static void comprueba(int numero1, int numero2, int numero3) {
        int numeroOrdenador1 = (int) (Math.random() * 20 + 1), numeroOrdenador2;
        do{
             numeroOrdenador2 = (int) (Math.random() * 20 + 1);

        } while (numeroOrdenador1==numeroOrdenador2);
        
        boolean aciertoOrdenador1, aciertoOrdenador2;

        if (numeroOrdenador1 == numero1 || numeroOrdenador1 == numero2 || numeroOrdenador1 == numero3) {
            aciertoOrdenador1 = true;
        } else {
            aciertoOrdenador1 = false;
        }

        // aciertoOrdenador1 = numeroOrdenador1 == numero1 || numeroOrdenador1 == numero2 || numeroOrdenador1 == numero3;

        if (numeroOrdenador2 == numero1 || numeroOrdenador2 == numero2 || numeroOrdenador2 == numero3) {
            aciertoOrdenador2 = true;
        } else {
            aciertoOrdenador2 = false;
        }



        if (aciertoOrdenador1) {
            System.out.println("Has acertado, tu número " + numeroOrdenador1 + " coincide con el de la máquina");
        } else {
            System.out.println("Tus números " + numero1 + "," + numero2 + "," + numero3
                    + " NO coinciden con el primer número de la máquina "+numeroOrdenador1);
        }
        if (aciertoOrdenador1) {
            System.out.println("Has acertado, tu número " + numeroOrdenador2 + " coincide con el de la máquina");
        } else {
            System.out.println("Tus números " + numero1 + "," + numero2 + "," + numero3
                    + " NO coinciden con el segundo número de la máquina "+numeroOrdenador2);
        }

    }

    /**
     * Permite introducir un número entre 1-20.
     * 
     * @return El número que introduce el usuario entre 1 y 20.
     */
    public static int introduce() {
        Scanner sc = new Scanner(System.in);

        int numero;

        do {
            numero = sc.nextInt();
        } while (numero <= 0 || numero > 20);
        return numero;

    }

    /**
     * Pide 3 números al usuario y los comprueba con dos números aleatorios y te
     * informa si coinciden o no.
     */
    public static void pide() {
        Scanner sc = new Scanner(System.in);

        int numero1, numero2, numero3;
        System.out.println("Introduce: 3 números diferentes entre 1 y 20:");
        System.out.println("Introduce el primer número:");
        numero1 = introduce();
        do {
            System.out.println("Introduce el segundo número:");
            numero2 = introduce();
        } while (numero2 == numero1);
        do {
            System.out.println("Introduce el tercer número:");
            numero3 = introduce();
        } while (numero3 == numero2 || numero3 == numero1);

        comprueba(numero1, numero2, numero3);

    }

    public static void main(String[] args) {
        pide();
    }
}
