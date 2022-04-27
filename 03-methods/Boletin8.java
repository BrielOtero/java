import java.util.*;

public class Boletin8 {

    /**
     * Calcula el area de un rectangulo o triangulo
     * 
     * @param base     La base del rectangulo, triangulo al que le calcularemos el
     *                 area.
     * @param altura   La altura del rectangulo, triangulo al que le calcularemos el
     *                 area.
     * @param rectOTri True si es un rectángulo y False si es un triángulo.
     * @return Area del triangulo, rectangulo que le pidamos.
     */
    public static double area(double base, double altura, boolean rectOTri) {
        if (rectOTri ) {
            return base * altura;
        } else {
            return ((base * altura) / 2);
        }
    }

    /**
     * Calcula el area de un circulo
     * 
     * @param radio Radio del circulo al que le calcularemos el area
     * @return Area del circulo
     */
    public static double circulo(double radio) {

        return (Math.PI * radio * radio);
        // DUDA return Math.pow(Math.PI * radio); Porque esto no funciona
    }

    /**
     * Pide al usuario los valores de la base (lado si es un cuadrado) y la altura y
     * calcula su area.
     * 
     * @param rectOTriUsuario True si es un rectángulo y False si es un triángulo.
     */
    public static void usuario(boolean rectOTriUsuario, boolean esCuadrado) {
        Scanner sc = new Scanner(System.in);
        double valor1, valor2;
        System.out.println("\033[H\033[2J");
        System.out.flush();
        if (esCuadrado == true) {
            System.out.println("Introduce el lado: ");
            valor1 = sc.nextDouble();
            valor2 = valor1;
        } else {
            System.out.println("Introduce la base: ");
            valor1 = sc.nextDouble();
            System.out.println("Introduce la altura: ");
            valor2 = sc.nextDouble();
        }

        System.out.println("\033[H\033[2J");
        System.out.flush();

        System.out.println("El resultado es: " + area(valor1, valor2, rectOTriUsuario));

    }

    /**
     * Pide al usuario el radio de un circulo y calcula su area.
     */
    public static void usuarioCirculo() {
        Scanner sc = new Scanner(System.in);
        double valor1;
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("Introduce el radio: ");
        valor1 = sc.nextDouble();
        System.out.println("\033[H\033[2J");
        System.out.flush();
        System.out.println("El resultado es: " + circulo(valor1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;

        System.out.println("\033[H\033[2J");
        System.out.flush();

        do {
            System.out.println("Elige una opción: ");
            System.out.println("1.Area de un triángulo (base*altura/2)");
            System.out.println("2.Area de un rectángulo (base*altura)");
            System.out.println("3.Area de un cuadrado (lado*lado)");
            System.out.println("4.Area de un círculo (Pi*radio^2)");
            System.out.println("5.Salir");
            menu = sc.nextInt();
            switch (menu) {
            case 1:
                usuario(false, false);
                break;
            case 2:
                usuario(true, false);
                break;
            case 3:
                usuario(true, true);
                break;
            case 4:
                usuarioCirculo();
                break;
            case 5:
                break;
            default:
                System.out.println("Opción no válida");
                break;
            }
        } while (menu != 5);

    }
}
