import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double base, altura;

        // Crear objeto rectangulo
        Geometria rectangulo = new Geometria(true, 10, 5);

        // Mostrar datos a usuario rectángulo
        System.out.println("RECTANGULO");
        System.out.printf("El AREA del Rectangulo es %2f\n", rectangulo.area());
        System.out.printf("El PERIMETRO del Rectangulo es %2f\n", rectangulo.perimetro());
        System.out.printf("La DIAGONAL del Rectangulo es %2f\n", rectangulo.diagonal());
        System.out.printf("El TIPO es: %s\n", rectangulo.tipo());

        // Pedir datos a usuario triángulo
        System.out.println();
        System.out.println("TRIANGULO");
        System.out.println("Introduce la base:");
        base = sc.nextDouble();
        System.out.println("Introduce la altura:");
        altura = sc.nextDouble();

        // Crear objeto triángulo
        Geometria triangulo = new Geometria();

        triangulo.setBase(base);
        triangulo.setAltura(altura);

        // Mostrar datos a usuario triángulo
        System.out.printf("El AREA del Triangulo es %2f\n", triangulo.area());
        System.out.printf("El PERIMETRO del Triangulo es %2f\n", triangulo.perimetro());
        System.out.printf("La DIAGONAL del Triangulo es %2f\n", triangulo.diagonal());
        System.out.printf("El TIPO es: %s\n", triangulo.tipo());

    }
}
