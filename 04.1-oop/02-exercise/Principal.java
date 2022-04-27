import java.util.*;

public class Principal {
    public static int pedirDia() {
        Scanner sc = new Scanner(System.in);
        int dia;
        System.out.println("Introduce el Dia:");
        dia = sc.nextInt();
        sc.close();
        return dia;
    }

    public static int pedirMes() {
        Scanner sc = new Scanner(System.in);
        int mes;
        System.out.println("Introduce el Mes:");
        mes = sc.nextInt();
        sc.close();
        return mes;
    }

    public static int pedirAno() {
        Scanner sc = new Scanner(System.in);
        int ano;
        System.out.println("Introduce en Ano:");
        ano = sc.nextInt();
        sc.close();
        return ano;
    }

    public static void main(String[] args) {
        int dia, mes, ano;
        // Pedir datos a usuario rectángulo.
        System.out.println("---Primera Fecha---");
        dia = pedirDia();
        mes = pedirMes();
        ano = pedirAno();

        Fecha fecha1 = new Fecha(dia, mes, ano);
        System.out.println(fecha1.fechaFormateada(true));
        System.out.println(fecha1.fechaFormateada(false));

        System.out.println("---Segunda Fecha---");
        dia = pedirDia();
        mes = pedirMes();
        ano = pedirAno();

        Fecha fecha2 = new Fecha(dia, mes, ano);
        System.out.println(fecha2.fechaFormateada(true));
        System.out.println(fecha2.fechaFormateada(false));
        System.out.println("-----------------");
        System.out.printf("La diferencia entre fechas es de %s anos\n", Fecha.diferenciasFechas(fecha1, fecha2));

    }
}
