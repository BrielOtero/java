import java.util.*;
	public class Boletin2{
		public static void main (String args []) {
			Scanner sc= new Scanner (System.in);
			
			int resto1;
			int resto2;
			int numero1;
			int numero2;
			
			
			System.out.print("Introduce un n�mero entero: ");
			numero1=sc.nextInt();
			
			System.out.print("Introduce otro n�mero entero: ");
			numero2=sc.nextInt();
			
			resto1 = numero1%numero2;
			resto2 = numero2%numero1;
				
			if (numero1>numero2) {
				System.out.println("El n�mero mayor es: "+numero1);
			
			} else {	
				if (numero1<numero2){
							System.out.println("El n�mero mayor es: "+numero2);
							} else {
							System.out.println("Los n�meros son iguales");
				}
			}
			if (resto1==0) {
				System.out.println("El n�mero "+numero1 + " es m�ltiplo de " + numero2);
			} else {
				System.out.println("El n�mero "+numero1+" no es m�ltiplo de "+numero2);
			}
			
			if (resto2==0) {
				System.out.println("El n�mero "+numero2 + " es m�ltiplo de " + numero1);
			} else {
				System.out.println("El n�mero "+numero2+" no es m�ltiplo de "+numero1);
			}
				
		
	}		
}