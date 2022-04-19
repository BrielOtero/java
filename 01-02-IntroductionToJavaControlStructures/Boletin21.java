import java.util.*;

public class Boletin21 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        int caballo = 0, numeroMovimiento = 0, numeroCaballo = 0, caballo1 = 0, caballo2 = 0, caballo3 = 0,
                caballo4 = 0, menu = 0, pantallaCompleta = 0;

        System.out.print("\033[H\033[2J");
        System.out.flush();

        do {
            System.out.println("----------------ATENCIÓN----------------");
            System.out.println("");
            System.out.println("    Para darte una mejor experiencia    ");
            System.out.println("");
            System.out.println("---------------POR FAVOR----------------");
            System.out.println("");
            System.out.println("  Ponga la ventana en pantalla completa ");
            System.out.println("");
            System.out.println("----------------GRACIAS-----------------");
            System.out.println("");
            System.out.println("       Pulsa 1 cuando estés listo       ");
            System.out.println("");
            System.out.println("----------------------------------------");
            pantallaCompleta = sc.nextInt();
        } while (pantallaCompleta != 1);

        do {

            // #region Inicio

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("");
            System.out.println("");
            System.out.println("============================================================");
            System.out.println("   _____          _____  _____  ______ _____            ");
            System.out.println("  / ____|   /\\   |  __ \\|  __ \\|  ____|  __ \\     /\\    ");
            System.out.println(" | |       /  \\  | |__) | |__) | |__  | |__) |   /  \\   ");
            System.out.println(" | |      / /\\ \\ |  _  /|  _  /|  __| |  _  /   / /\\ \\ ");
            System.out.println(" | |____ / ____ \\| | \\ \\| | \\ \\| |____| | \\ \\  / ____ \\");
            System.out.println("  \\_____/_/    \\_\\_|  \\_\\_|  \\_\\______|_|  \\_\\/_/    \\_\\");
            System.out.println("                       _____  ______ ");
            System.out.println("                      |  __ \\|  ____|                   ");
            System.out.println("                      | |  | | |__                      ");
            System.out.println("                      | |  | |  __|                    ");
            System.out.println("                      | |__| | |____                  ");
            System.out.println("                      |_____/|______|");
            System.out.println("   _____          ____          _      _      ____   _____");
            System.out.println("  / ____|   /\\   |  _ \\   /\\   | |    | |    / __ \\ / ____|");
            System.out.println(" | |       /  \\  | |_) | /  \\  | |    | |   | |  | | (___  ");
            System.out.println(" | |      / /\\ \\ |  _ < / /\\ \\ | |    | |   | |  | |\\___ \\");
            System.out.println(" | |____ / ____ \\| |_) / ____ \\| |____| |___| |__| |____) |");
            System.out.println("  \\_____/_/    \\_\\____/_/    \\_\\______|______\\____/|_____/");
            System.out.println("");
            System.out.println("============================================================");
            System.out.println("");
            System.out.println("");
            System.out.println("                                    _(\\_/) ");
            System.out.println("                                  ,((((^`\\");
            System.out.println("                                 ((((  (6 \\");
            System.out.println("                               ,((((( ,    \\");
            System.out.println("           ,,,_              ,(((((  /\"._  ,`,");
            System.out.println("          ((((\\\\ ,...       ,((((   /    `-.-'");
            System.out.println("          )))  ;'    `\"'\"'\"\"((((   ( ");
            System.out.println("         (((  /            (((      \\");
            System.out.println("          )) |                      |");
            System.out.println("         ((  |        .       \'     |");
            System.out.println("         ))  \\     _ \'      `t   ,.\')");
            System.out.println("         (   |   y;- -,-\"\"\'\"-.\\   \\/");
            System.out.println("         )   / ./  ) /         `\\  \\");
            System.out.println("            |./   ( (           / /\'");
            System.out.println("            ||     \\\\          //\'|");
            System.out.println("            ||      \\\\       _//\'||");
            System.out.println("            ||       ))     |_/  ||");
            System.out.println("            \\_\\     |_/          ||");
            System.out.println("            `\'\"                  \\_\\");
            System.out.println("");

            System.out.println("Selecciona un caballo: ");
            System.out.println("");
            System.out.println("1. Troya");
            System.out.println("2. Rocinante");
            System.out.println("3. Pegaso");
            System.out.println("4. Perdigón");
            caballo = sc.nextInt();

            // #endregion

            // #region Cuenta Atras

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("La carrera comienza en...");
            System.out.println("");
            System.out.println("");
            System.out.println("          3333");
            System.out.println("         33  33");
            System.out.println("            333");
            System.out.println("         33  33");
            System.out.println("          3333");

            Thread.sleep(1000);

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("La carrera comienza en...");
            System.out.println("");
            System.out.println("");
            System.out.println("          2222");
            System.out.println("         22  22");
            System.out.println("            22");
            System.out.println("           22");
            System.out.println("         222222");

            Thread.sleep(1000);

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("La carrera comienza en...");
            System.out.println("");
            System.out.println("");
            System.out.println("         1111");
            System.out.println("           11");
            System.out.println("           11");
            System.out.println("           11");
            System.out.println("         111111");

            Thread.sleep(1000);

            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("");
            System.out.println("");
            System.out.println("   __     __      _ ");
            System.out.println("   \\ \\   / //\\   | |");
            System.out.println("    \\ \\_/ //  \\  | |");
            System.out.println("     \\   // /\\ \\ | |");
            System.out.println("      | |/ ____ \\|_|");
            System.out.println("      |_/_/    \\_(_)");

            Thread.sleep(250);

            System.out.print("\033[H\033[2J");
            System.out.flush();

            // #endregion

            numeroMovimiento = 0;
            numeroCaballo = 0;
            caballo1 = 0;
            caballo2 = 0;
            caballo3 = 0;
            caballo4 = 0;

            // #region Selección de Caballo y Movimiento

            while (caballo1 <= 25 && caballo2 <= 25 && caballo3 <= 25 && caballo4 <= 25) {
                numeroCaballo = (int) (Math.random() * (5 - 1)) + 1;
                numeroMovimiento = (int) (Math.random() * (4 - 1)) + 1;
                if (numeroCaballo == 1) {
                    caballo1 = caballo1 + numeroMovimiento;
                }
                if (numeroCaballo == 2) {
                    caballo2 = caballo2 + numeroMovimiento;
                }
                if (numeroCaballo == 3) {
                    caballo3 = caballo3 + numeroMovimiento;
                }
                if (numeroCaballo == 4) {
                    caballo4 = caballo4 + numeroMovimiento;
                }
                // #endregion

                // #region Movimiento Caballo 1
                System.out.println("");
                System.out.println("");

                for (int espacios = 0; espacios <= caballo1; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("           ,--,");
                for (int espacios = 0; espacios <= caballo1; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     _ ___/ /\\|");
                for (int espacios = 0; espacios <= caballo1; espacios++) {
                    System.out.print(" ");
                }
                System.out.println(" ,;\'( )__, )  ~");
                for (int espacios = 0; espacios <= caballo1; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("//  //   \'--; ");
                for (int espacios = 0; espacios <= caballo1; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("\'   \\     | ^");
                for (int espacios = 0; espacios <= caballo1; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     ^    ^");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                // System.out.println("Caballo1 "+caballo1);

                // #endregion

                // #region Movimiento Caballo 2
                for (int espacios = 0; espacios <= caballo2; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("           ,--,");
                for (int espacios = 0; espacios <= caballo2; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     _ ___/ /\\|");
                for (int espacios = 0; espacios <= caballo2; espacios++) {
                    System.out.print(" ");
                }
                System.out.println(" ,;\'( )__, )  ~");
                for (int espacios = 0; espacios <= caballo2; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("//  //   \'--; ");
                for (int espacios = 0; espacios <= caballo2; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("\'   \\     | ^");
                for (int espacios = 0; espacios <= caballo2; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     ^    ^");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                // #endregion

                // #region Movimiento Caballo 3
                for (int espacios = 0; espacios <= caballo3; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("           ,--,");
                for (int espacios = 0; espacios <= caballo3; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     _ ___/ /\\|");
                for (int espacios = 0; espacios <= caballo3; espacios++) {
                    System.out.print(" ");
                }
                System.out.println(" ,;\'( )__, )  ~");
                for (int espacios = 0; espacios <= caballo3; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("//  //   \'--; ");
                for (int espacios = 0; espacios <= caballo3; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("\'   \\     | ^");
                for (int espacios = 0; espacios <= caballo3; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     ^    ^");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                // #endregion

                // #region Movimiento Caballo 4

                for (int espacios = 0; espacios <= caballo4; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("           ,--,");
                for (int espacios = 0; espacios <= caballo4; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     _ ___/ /\\|");
                for (int espacios = 0; espacios <= caballo4; espacios++) {
                    System.out.print(" ");
                }
                System.out.println(" ,;\'( )__, )  ~");
                for (int espacios = 0; espacios <= caballo4; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("//  //   \'--; ");
                for (int espacios = 0; espacios <= caballo4; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("\'   \\     | ^");
                for (int espacios = 0; espacios <= caballo4; espacios++) {
                    System.out.print(" ");
                }
                System.out.println("     ^    ^");
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");

                // #endregion

                // #region IU Carrera

                System.out.println("");
                System.out.println("                                         ^");
                System.out.println("_________________________________________|META");
                Thread.sleep(250);
                if (caballo1 <= 24 && caballo2 <= 24 && caballo3 <= 24 && caballo4 <= 24) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }

                // #endregion
            }
            // #region Final

            System.out.println("");
            System.out.println("");
            System.out.println("       _ ____");
            System.out.println("     /( ) _   \\");
            System.out.println("    / //   /\\` \\,  ||--||--||-");
            System.out.println("      \\|   |/  \\|  ||--||--||-");
            System.out.println("~^~^~^~~^~~~^~~^^~^^^^^^^^^^^^");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            /*
             * System.out.println("Elección caballo " + caballo);
             * System.out.println("Pasos caballo 1 " + caballo1);
             * System.out.println("Pasos caballo 2 " + caballo2);
             * System.out.println("Pasos caballo 3 " + caballo3);
             * System.out.println("Pasos caballo 4 " + caballo4);
             */
            
            if (caballo == 1) {
                if (caballo1 >= 25) {
                    System.out.println("Tu caballo TROYA ha GANADO!!");
                } else {
                    System.out.println("Tu caballo TROYA ha PERDIDO :(");
                }
            }
            if (caballo == 2) {
                if (caballo2 >= 25) {
                    System.out.println("Tu caballo ROCINANTE ha GANADO!!");
                } else {
                    System.out.println("Tu caballo ROCINANTE ha PERDIDO :(");
                }
            }
            if (caballo == 3) {
                if (caballo3 >= 25) {
                    System.out.println("Tu caballo PEGASO ha GANADO!!");
                } else {
                    System.out.println("Tu caballo PEGASO ha PERDIDO :(");
                }
            }
            if (caballo == 4) {
                if (caballo4 >= 25) {
                    System.out.println("Tu caballo PERDIGÓN ha GANADO!!");
                } else {
                    System.out.println("Tu caballo PERDIGÓN ha PERDIDO :(");
                }
            }
            System.out.println("");
            System.out.println("");

            System.out.println("Quieres volver a jugar? ");
            System.out.println("");
            System.out.println("0. SI");
            System.out.println("1. NO");
            menu = sc.nextInt();

            // #endregion

        } while (menu == 0);

    }
}
