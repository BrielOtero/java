import java.util.*;

public class IUDirectivo {
    double dineroGlobal = 0;

    public Directivo directivo;

    public IUDirectivo(Directivo directivo) {
        this.directivo = directivo;
    }

    public void mostrar() {
        System.out.printf(
                "Nombre= %s\nApellidos= %s\nDNI= %s\nEdad= %d\nNombre Departamento= %s\nPorcentaje Beneficos= %f\nGanancias= %f\n",
                directivo.getNombre(), directivo.getApellidos(), directivo.getDni(), directivo.getEdad(),
                directivo.getNombreDepartamento(), directivo.getPorcentajeBeneficios(),
                directivo.ganancias(dineroGlobal));
    }

    public void pedir() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce su Nombre: ");
        directivo.setNombre(sc.nextLine());
        System.out.print("Introduce sus Apellidos: ");
        directivo.setApellidos(sc.nextLine());
        System.out.print("Introduce su DNI: ");
        directivo.setDni(sc.nextLine());
        System.out.print("Introduce su Edad: ");
        directivo.setEdad(sc.nextInt());
        sc.nextLine();
        System.out.print("Introduce su Nombre Departamento: ");
        directivo.setNombreDepartamento(sc.nextLine());
        System.out.print("Introduce su Porcentaje Beneficios: ");
        directivo.setPorcentajeBeneficios(sc.nextDouble());
        sc.nextLine();
        System.out.print("Introduce el Dinero Global de Beneficios: ");
        this.dineroGlobal = sc.nextDouble();
        sc.nextLine();
     
    }
    public void mostrar(int option) {
        switch (option) {
            case 1:
                System.out.println("-------------------------");
                System.out.printf("Nombre= %s\nApellidos= %s\n", directivo.getNombre(), directivo.getApellidos());
                break;
            case 2:
                System.out.println("-------------------------");
                System.out.printf("DNI= %s\n", directivo.getDni());
                break;
            case 3:
                System.out.println("-------------------------");
                System.out.printf("Edad= %d\n", directivo.getEdad());
                break;
            case 4:
                System.out.println("-------------------------");
                System.out.printf("Nombre Departamento= %s\nPorcentaje Beneficios= %f%\n",
                        directivo.getNombreDepartamento(), directivo.getPorcentajeBeneficios());
                break;
                case 5:
                System.out.println("-------------------------");
                System.out.printf("Ganancias: %.2f $\n", directivo.ganancias(this.dineroGlobal));
                break;
            default:
                System.out.println("Opcion no valida, introduce un numero valido:");
                break;
        }
    }

}
