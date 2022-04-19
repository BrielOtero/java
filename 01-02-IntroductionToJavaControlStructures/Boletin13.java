import java.util.*;
public class Boletin13 {
    public static void main (String [] args){
        Scanner sc= new Scanner (System.in);
        int n, a=0,b=0; /*a = Acumulador ; b = Acumulador apartado c */
        System.out.println("Introduce un Nº: ");
        n=sc.nextInt();
        
        for (int cont=0; cont<n; cont=cont+2){       
            a=a+cont;   
        }
        System.out.println("La suma de pares es = " + a);
        a=0;
        for (int cont=1; cont<n; cont=cont+2){       
            a=a+cont;   
        }
        System.out.println("La suma de impares es = " + a);
        a=0;
        for (int cont=0; cont<n; cont=cont+1){       
            if((cont % 2) == 0){
                a=a+cont; 
            } else {
                b=b+cont;
            }
        }
        System.out.println("La suma de pares en 1 bucle es = " + a);
        System.out.println("La suma de impares en 1 bucle es = " + b);
    }                
}
