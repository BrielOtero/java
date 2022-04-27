import java.util.*;

public class MainPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = 0;
        int menu;
        do {

            if (args.length == 0) {
                System.out.println("Enter a year:");
                year = sc.nextInt();
                System.out.println();
            } else {
                year = Integer.valueOf(args[0]);
            }

            Sales sales = new Sales(year);

            sales.graphic();
            System.out.println();
            System.out.printf("The average is: %.2f\n", sales.average());
            System.out.println();

            System.out.println("What do you want to do?");
            System.out.println("1.- Close the program");
            System.out.println("2.- Continue");
            menu = sc.nextInt();

        } while (menu != 1);
    }

}
