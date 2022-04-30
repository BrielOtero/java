import java.util.*;

public class IUEmpleado {

    public Empleado empleado;

    public IUEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void mostrar() {
        System.out.printf("Nombre=%s\n Apellidos= %s\n DNI= %s\n Edad= %d\n Salario Anual= %f\n IRPF= %f\n",
                empleado.getNombre(), empleado.getApellidos(), empleado.getDni(), empleado.getEdad(),
                empleado.getSalarioAnual(), empleado.getIrpf());
    }

    public void pedir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce su Nombre: ");
        empleado.setNombre(sc.nextLine());
        System.out.print("Introduce sus Apellidos: ");
        empleado.setApellidos(sc.nextLine());
        System.out.print("Introduce su DNI: ");
        empleado.setDni(sc.nextLine());
        System.out.print("Introduce su Edad: ");
        empleado.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.print("Introduce su Salario Anual: ");
        empleado.setSalarioAnual(sc.nextDouble());
        sc.nextLine();
        sc.close();
    }

    public void mostrar(int option) {
        switch (option) {
            case 1:
                System.out.println("-------------------------");
                System.out.printf("Nombre= %s\nApellidos= %s\n", empleado.getNombre(), empleado.getApellidos());
                break;
            case 2:
                System.out.println("-------------------------");
                System.out.printf("DNI= %s\n", empleado.getDni());
                break;
            case 3:
                System.out.println("-------------------------");
                System.out.printf("Edad= %d\n", empleado.getEdad());
                break;
            case 4:
                System.out.println("-------------------------");
                System.out.printf("Salario Anual= %f\nIRPF= %f\n", empleado.getSalarioAnual(), empleado.getIrpf());
                break;
            case 5:
                System.out.println("-------------------------");
                System.out.printf("Hacienda se lleva: %.2f $\n", empleado.hacienda());
                break;
            default:
                System.out.println("Opcion no valida, introduce un numero valido:");
                break;
            }
        
        }
        
    }
