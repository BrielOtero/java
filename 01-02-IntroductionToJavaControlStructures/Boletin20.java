import java.util.*;
    public class Boletin20 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int valorUsuario;
                    
            System.out.print("Cuantas lineas de asteriscos quieres dibujar: ");
            valorUsuario=sc.nextInt();

            for(int cont=0; cont<=valorUsuario; cont++){
                for(int asteriscos=0; asteriscos<cont; asteriscos++){
                    System.out.print("*");                     
                } 
                System.out.println("");                    
            }

            for(int cont=1; cont<=valorUsuario; cont++){
                for(int espacios=1; espacios<=valorUsuario-cont; espacios++){
                    System.out.print(" ");                     
                } 
                for(int asteriscos=1; asteriscos<=(cont*2)-1; asteriscos++){
                System.out.print("*");
                }
                System.out.println(""); 
            }   
    }
}    
    