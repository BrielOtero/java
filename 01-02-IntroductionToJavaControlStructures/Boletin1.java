import java.security.spec.MGF1ParameterSpec;
import java.util.*;

import javax.management.ValueExp;

public class Boletin1 {
	public static void main (String[] args){
		
			int cont = 1 ;
			
			while (cont < 21) {
				System.out.println("Contador While = " + cont);
				cont=cont+1;
			}
			
			cont = 1;
			
			do {
				System.out.println("Contador Do = " + cont);
				cont=cont+1;
			}while (cont<21);
			
			for (cont=1; cont<21; cont++){
				System.out.println("Contador For = "+cont);
			}	
			
			cont=2;
			
			while (cont < 51) {
				System.out.printf("%5d\n",cont);
				cont=cont+2;
			}
	}
}