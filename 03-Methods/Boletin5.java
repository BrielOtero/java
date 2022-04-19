import java.util.*;

public class Boletin5 {

    /**
     * Calcula la Progresi�n Geom�trica de un n�mero
     * 
     * @param x N�mero del que calcularemos la Progresi�n Geometrica
     * @param n La Cantidad de Exponentes hasta los que tenemos que calcular la
     *          Progesi�n Geom�trica
     * @return La Progresi�n Geometrica de un n�mero
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
