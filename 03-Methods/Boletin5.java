import java.util.*;

public class Boletin5 {

    /**
     * Calcula la Progresión Geométrica de un número
     * 
     * @param x Número del que calcularemos la Progresión Geometrica
     * @param n La Cantidad de Exponentes hasta los que tenemos que calcular la
     *          Progesión Geométrica
     * @return La Progresión Geometrica de un número
     */
    public static double progresionGeometrica(double x, double n) {
        double calculos = 0;
        for (int i = 0; i <= n; i++) {
            calculos = calculos + Boletin4.potencia(x, i);
        }
        return calculos;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double xUsuario, nUsuario;
        System.out.println("Introduce el valor de x: ");
        xUsuario = sc.nextDouble();
        System.out.println("Introduce el valor de n: ");
        nUsuario = sc.nextDouble();

        System.out.println(progresionGeometrica(xUsuario, nUsuario));
    }

}
