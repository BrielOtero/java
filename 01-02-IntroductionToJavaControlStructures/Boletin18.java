import java.util.*;
    public class Boletin18 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            double valorUsuario, factorial=1, contador=1;
                    
                System.out.println("Introduce un número: ");
                valorUsuario=sc.nextDouble();                
                
                for (double cont = 1; cont <= valorUsuario; cont++) {
                    factorial=factorial*cont;// factorial *=cont;
                }
                System.out.println("El factorial de "+valorUsuario+ " hecho por \"FOR\" es: "+(factorial));
                factorial=1;
                
                do{
                    factorial *=contador;
                    contador++;
                } while (contador<=valorUsuario);
                System.out.println("El factorial de "+valorUsuario+ " hecho por \"Do-While\" es: "+(factorial));
                factorial=1;
                contador=1;
                while(contador<=valorUsuario){
                    factorial*=contador;
                    contador++;
                }
                System.out.println("El factorial de "+valorUsuario+ " hecho por \"While\" es: "+(factorial));              
        } 
    }       