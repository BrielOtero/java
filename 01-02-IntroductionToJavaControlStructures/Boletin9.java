import java.util.*;
    public class Boletin9 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int n, contador = 1;
            double a=0, b=0;  
            
            System.out.println("Cuantos n�meros deseas introducir?");  
            n = sc.nextInt();  
            while (contador <= n) {   
                    System.out.println("Introduce el "+contador+" n�mero?");  
                    a = sc.nextInt();
                    ++contador;

                    if (b == 0){
                       b = a;
                    }else{
                        if (a>b) {
                         b = a;             
                        }
                    }
            }
            System.out.println("El n�mero m�ximo es: "+b);      
        }    
} 