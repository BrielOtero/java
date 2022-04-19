import java.util.*;

public class Boletin3 {
	public static void main (String [] args){
		Scanner sc= new Scanner (System.in);
		int n;//Número usuario
		int m=0;//Contador
		int a=0;//Acumulador
		
		System.out.println("Introduce un número: ");
		n=sc.nextInt();
		

		if (n>0) {
			while (m != n) {
				// System.out.println("Contador = " + m);
				m=m+1;
				a=a+m;
			}

		}
		System.out.println("La suma es = " + a);
	}
}