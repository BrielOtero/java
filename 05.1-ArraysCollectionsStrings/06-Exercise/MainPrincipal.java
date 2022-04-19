import java.util.*;

public class MainPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;
        int valueSee;
        int valueDelete;
        int n;

        System.out.println("Hello, enter the value n in the matrix:");
        System.out.print("--> ");
        n = sc.nextInt();
        System.out.println();

        Core core = new Core(n);
        int[][] matrix = core.matrix;

        do {
            System.out.println();
            System.out.println("Choose an option: ");
            System.out.println("1. Show");
            System.out.println("2. Sum of all elements");
            System.out.println("3. Sum diagonal");
            System.out.println("4. Sum of the elements except the diagonal");
            System.out.println("5. Sum of the elements of a row");
            System.out.println("6. Show matrix without a row");
            System.out.println("7. Exit");
            System.out.print("--> ");
            menu = sc.nextInt();
            System.out.println();
            switch (menu) {
                case 1:
                    System.out.println();
                    core.showMatrix(matrix);

                    break;
                case 2:
                    System.out.println();
                    System.out.printf("Result: %s\n", core.add());
                    break;
                case 3:
                    System.out.println();
                    System.out.printf("Result: %s\n", core.add(true));
                    break;
                case 4:
                    System.out.println();
                    System.out.printf("Result: %s\n", core.add(false));
                    break;
                case 5: 
                    do {
                        System.out.println("Which row do you want to sum?(Between 0 and N-1)");
                        System.out.print("--> ");
                        valueSee = sc.nextInt();
                    } while (valueSee >= n || valueSee < 0);
                    
                    System.out.println();
                    System.out.println();
                    System.out.printf("Result: %s\n", core.add(valueSee));
                    break;
                case 6:
                do {
                    
                    System.out.println("Which row do you want to delete?(Between 0 and N-1)");
                    System.out.print("--> ");
                    valueDelete = sc.nextInt();
                } while (valueDelete >= n || valueDelete < 0);
                    System.out.println();

                    System.out.println();
                    core.showMatrix(core.deleteRow(valueDelete));
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (menu != 7);
    }
}
