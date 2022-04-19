import java.util.*;
public class Principal {

    public static int menuCampos() {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println();
        System.out.println("Elige una opcion: ");
        System.out.println("1.Nombre y Apellidos");
        System.out.println("2.DNI");
        System.out.println("3.EDAD");
        System.out.println("4.Salario y IRPF");
        System.out.println("5.Hacienda");
        option = sc.nextInt();
        sc.close();
        return option;

    }

    public static void main(String[] args) {
        Empleado empleado = new Empleado();
        IUEmpleado iuEmpleado = new IUEmpleado(empleado);
        iuEmpleado.pedir();
        System.out.println("--------SUS DATOS--------");
        iuEmpleado.mostrar();
        System.out.println("-------------------------");
        System.out.printf("Este ano Hacienda te roba: %f\n", empleado.hacienda());
        System.out.println("-------------------------");
        iuEmpleado.mostrar(menuCampos());

    }
}
