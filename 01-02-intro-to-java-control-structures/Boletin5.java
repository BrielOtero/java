import java.util.*;
    public class Boletin5 {
        public static void main (String [] args){
            
			Scanner sc= new Scanner(System.in);

			double temp, F, K;
			int menu;
			do {
				System.out.println("Introduce la temperatura en � Celsius: ");
				temp=sc.nextDouble();



				System.out.println("Elige una opci�n: ");
				System.out.println("1. Convertir a Farenheit" );
				System.out.println("2. Convertir a Kelvin");
				System.out.println("3. Salir");
				menu=sc.nextInt();

				switch (menu){
					case 1:
						F=1.8*temp+32;
						System.out.printf("\n%.2f � Farenheit\n", F);
					break;
					case 2:
						K=temp+273;
						System.out.printf("\n%.2f � Kelvin\n", K);
					break;
					case 3:
					break;

					default:
						System.out.println("Opci�n no v�lida");
						break;
				}
			} while (menu != 3);


        }
}
