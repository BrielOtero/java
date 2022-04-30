import java.util.*;

public class Boletin3 {

    /**
     * Comprueba si un año es Bisiesto
     * 
     * @param ano Año del que comprobaremos si es bisiesto
     * @return True si es Bisiesto, False si no lo es
     */
    public static boolean bisiesto(int ano) {
        if (ano % 100 == 0 && ano % 400 == 0) {
            return true;
        }
        if (ano % 100 == 0) {
            return false;
        }
        if (ano % 4 == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anoUsuario;

        do {
            System.out.println("Introduce un año: ");
            anoUsuario = sc.nextInt();
            System.out.println(bisiesto(anoUsuario));
        } while (anoUsuario != 0);

    }
}
