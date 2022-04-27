import java.util.*;
    public class Boletin19 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int valorUsuario, menu;
                    
            System.out.print("Cuantos asteriscos quieres dibujar: ");
            valorUsuario=sc.nextInt();
     
            for(int cont=1; cont<=valorUsuario; cont++){
                System.out.print("*");                     
            } 
            System.out.println("");
            System.out.println("Como los quieres dibujar: ");
            System.out.println("1. De derecha a izquierda.");
            System.out.println("2. De izquierda a derecha.");
            menu=sc.nextInt();
            if(menu==1){
                for(int asteriscos=valorUsuario; asteriscos>0; asteriscos--){
                    for(int espacios=0; espacios+1<asteriscos; espacios++){
                        System.out.print(" ");                     
                    } 
                    System.out.print("*");
                    System.out.println(""); 
                }    
            } else {
                if (menu==2){
                    for(int asteriscos=0; asteriscos+1<=valorUsuario; asteriscos++){
                        for(int espacios=0; espacios<asteriscos; espacios++){
                            System.out.print(" ");                     
                        } 
                        System.out.print("*");
                        System.out.println("");                     
                    } 
                }
            }

        }    
    }       