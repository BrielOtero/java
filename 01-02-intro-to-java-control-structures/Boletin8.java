import java.util.*;
	public class Boletin8{
		public static void main (String arge []) {
			Scanner sc= new Scanner (System.in);
			
			double numero1, numero2, numero3;
						
			System.out.print("Introduce un n�mero: ");
			numero1=sc.nextDouble();
			
			System.out.print("Introduce otro n�mero: ");
			numero2=sc.nextDouble();
			
			System.out.print("Introduce el �ltimo n�mero: ");
			numero3=sc.nextDouble();
			
				
			if (numero1>numero2){
				if (numero1>numero3) {
					System.out.print("El n�mero mayor es: "+numero1);
				} else {
					System.out.print("El n�mero mayor es: "+numero3);
				}
			}else if (numero2>numero3){
				System.out.print("El n�mero mayor es: "+numero2);
			} else {
				System.out.print("El n�mero mayor es: "+numero3);
					
			}
	}		
}