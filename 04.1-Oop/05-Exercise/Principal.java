import java.util.*;

public class Principal {

    public static void verDatos(Empresa empresa) {
        Scanner sc = new Scanner(System.in);

        int menu;
        do {
            System.out.println();
            System.out.println("-- Elige una opcion --");
            System.out.println();
            System.out.println("1. Ver todos los datos");
            System.out.println("2. Ver un solo dato");
            System.out.println("3. Salir");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println();
                    System.out.println("-- Empleado 1 --");
                    empresa.iuEmpleado1.mostrar();

                    System.out.println();
                    System.out.println("-- Empleado 2 --");
                    empresa.iuEmpleado2.mostrar();
                    break;
                case 2:
                    int option;
                    do {
                        System.out.println();
                        System.out.println("-- Elige una opcion --");
                        System.out.println();
                        System.out.println("1. Nombre y Apellidos");
                        System.out.println("2. DNI");
                        System.out.println("3. Edad");
                        System.out.println("4. Salario Anual y IRPF");
                        System.out.println("5. Hacienda");
                        System.out.println("6. Salir");
                        option = sc.nextInt();

                        if (option < 1 || option > 6) {
                            System.out.println("Opcion no valida");
                        } else {
                            if (option != 6) {
                                System.out.println();
                                System.out.println("-- Empleado 1 --");
                                empresa.iuEmpleado1.mostrar(option);

                                System.out.println();
                                System.out.println("-- Empleado 2 --");
                                empresa.iuEmpleado2.mostrar(option);
                            }
                        }
                    } while (option != 6);

                    break;
                case 3:

                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (menu != 3);
    }

    public static void modificarDatos(Empresa empresa) {
        Scanner sc = new Scanner(System.in);

        int option1;
        do {
            System.out.println();
            System.out.println("-- Elige una opcion --");
            System.out.println();
            System.out.println("1. Modificar Directivo");
            System.out.println("2. Modificar Empleado 1");
            System.out.println("3. Modificar Empleado 2");
            System.out.println("4. Salir");
            option1 = sc.nextInt();
            switch (option1) {
                case 1:
                    empresa.iuDirectivo.pedir();
                    break;
                case 2:
                    empresa.iuEmpleado1.pedir();
                    break;
                case 3:
                    empresa.iuEmpleado1.pedir();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (option1 != 4);
    }

    public static void main(String[] args) {
        double cobrar, ganancias;
        int menu;
        Scanner sc = new Scanner(System.in);

        Directivo directivo = new Directivo();
        IUDirectivo iuDirectivo = new IUDirectivo(directivo);

        Empleado empleado1 = new Empleado();
        IUEmpleado iuEmpleado1 = new IUEmpleado(empleado1);

        Empleado empleado2 = new Empleado();
        IUEmpleado iuEmpleado2 = new IUEmpleado(empleado2);

        Empresa empresa = new Empresa(directivo, empleado1, empleado2);

        System.out.println();
        System.out.println("-- Empleado 1 --");
        iuEmpleado1.pedir();

        System.out.println();
        System.out.println("-- Empleado 2 --");
        iuEmpleado2.pedir();

        System.out.println();
        System.out.println("-- Directivo --");
        iuDirectivo.pedir();

        System.out.println();
        System.out.println("-- Empresa --");
        System.out.println("Introduce las ganancias de la empresa: ");
        ganancias = sc.nextDouble();
        empresa.setGanancias(ganancias);

        do {
            System.out.println();
            System.out.println("-- Elige una opcion --");
            System.out.println();
            System.out.println("1. Ver datos empleados");
            System.out.println("2. Ver datos directivo");
            System.out.println("3. Modificar datos");
            System.out.println("4. Pagar");
            System.out.println("5. Cobrar");
            System.out.println("6. Salir");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    verDatos(empresa);
                    break;
                case 2:
                    iuDirectivo.mostrar();
                    break;
                case 3:
                    modificarDatos(empresa);
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Las ganancias de la empresa antes de pagar son: " + empresa.getGanancias());
                    System.out.println();
                    empresa.setGanancias((empresa.getGanancias() - (empleado1.getSalarioAnual() + empleado2.getSalarioAnual())));
                    System.out.println("Las ganancias de la empresa despues de pagar son: "
                            + empresa.getGanancias());
                    break;
                case 5:
                    System.out.println("-- Cuanto quieres cobrar? --");
                    cobrar = sc.nextDouble();
                    System.out.println("Las ganancias de la empresa antes de cobrar son: " + empresa.getGanancias());
                    empresa.setGanancias(cobrar + empresa.getGanancias());
                    System.out.println("Las ganancias de la empresa despues de cobrar son: " + empresa.getGanancias());

                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        } while (menu != 6);

    }
}
