import java.util.*;
	public class Boletin8{
		public static void main (String arge []) {
			Scanner sc= new Scanner (System.in);
			
			double numero1, numero2, numero3;
						
			System.out.print("Introduce un número: ");
			numero1=sc.nextDouble();
			
			System.out.print("Introduce otro número: ");
			numero2=sc.nextDouble();
			
			System.out.print("Introduce el último número: ");
			numero3=sc.nextDouble();
			
				
			if (numero1>numero2){
				if (numero1>numero3) {
					System.out.print("El número mayor es: "+numero1);
				} else {
					System.out.print("El número mayor es: "+numero3);
				}
			}else if (numero2>numero3){
				System.out.print("El número mayor es: "+numero2);
			} else {
				System.out.print("El número mayor es: "+numero3);
					
			}
	}		
}