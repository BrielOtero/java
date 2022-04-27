import java.util.*;
    public class Boletin14 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int valorUsuario=1, contador = 1, total=0; 
            while (valorUsuario != 0){  
                    System.out.println("Introduce el "+(contador)+" número?");
                    System.out.println("Escribe 0 para salir");  
                    valorUsuario = sc.nextInt();
                    ++contador;
                    if (valorUsuario<0){
                        total=total+1;
                    }
            }
            System.out.println("Se introdujeron "+total+" números negativos de un total de "+(contador-2)+".");      
        }    
} 