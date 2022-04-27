import java.util.*;
	public class Boletin2{
		public static void main (String args []) {
			Scanner sc= new Scanner (System.in);
			
			int resto1;
			int resto2;
			int numero1;
			int numero2;
			
			
			System.out.print("Introduce un número entero: ");
			numero1=sc.nextInt();
			
			System.out.print("Introduce otro número entero: ");
			numero2=sc.nextInt();
			
			resto1 = numero1%numero2;
			resto2 = numero2%numero1;
				
			if (numero1>numero2) {
				System.out.println("El número mayor es: "+numero1);
			
			} else {	
				if (numero1<numero2){
							System.out.println("El número mayor es: "+numero2);
							} else {
							System.out.println("Los números son iguales");
				}
			}
			if (resto1==0) {
				System.out.println("El número "+numero1 + " es múltiplo de " + numero2);
			} else {
				System.out.println("El número "+numero1+" no es múltiplo de "+numero2);
			}
			
			if (resto2==0) {
				System.out.println("El número "+numero2 + " es múltiplo de " + numero1);
			} else {
				System.out.println("El número "+numero2+" no es múltiplo de "+numero1);
			}
				
		
	}		
}