import java.util.*;

public class Boletin6 {
    /**
     * Comprueba si un numero es primo o no.
     * @param num El número al cual le comprobaremos si es primo o no.
     * @return True si es primo, false si no es primo. 
     */
    public static boolean primos(int num) {
        if (num <= 1) {
            return false;
        } else {
            for (int i = 2; i < num; i++) {
                if (num % i == 0) {
                    return false;
                }
                if(num % i+2 == 0){
                    return false;
                }
                if(num % i+3 == 0){
                    return false;
                }
                
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroUsuario;

        // System.out.println(primos(4));
        System.out.println("Introduce un número: ");
        numeroUsuario = sc.nextInt();

       System.out.println(primos(numeroUsuario));

    }
}
