import java.util.*;
	public class Boletin4 {
		public static void main (String args []) {
			Scanner sc= new Scanner (System.in);
			
			int n;
			double m;
						
			System.out.print("Introduce un número ENTERO: ");
			n=sc.nextInt();
			
			System.out.print("Introduce otro número REAL: ");
			m=sc.nextDouble();
			
			System.out.printf("Entero en decimal: %d\n", n);
			System.out.printf("Entero en octal: %05o\n", n);
			System.out.printf("Entero en hexa: %X\n", n);
			System.out.printf("Real: %7.3f\n", m);	
		
	}		
}