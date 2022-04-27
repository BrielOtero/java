import java.util.*;
	public class Boletin10{
		public static void main (String[] args ) {
			Scanner sc= new Scanner (System.in);
			
			int a, b, c;
					
			System.out.print("Introduce un número: ");
			a=sc.nextInt();
			
			System.out.print("Introduce otro número: ");
			b=sc.nextInt();
			
			System.out.println("Antes del intercambio de variables: a=" +a+" b="+b);
			
			c = a;
			a = b;
			b = c;
			
			System.out.println("Después del intercambio de variables: a="+a+" b="+b);	
	}		
}