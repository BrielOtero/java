import java.util.*;
    public class Boletin17 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int valorUsuario=0, menu=1, suma=0;

            while (menu!=0){
                    do{
                        System.out.println("Introduce un n�mero entre 1 y 50:");
                        valorUsuario=sc.nextInt();
                    } while (valorUsuario <= 0 || valorUsuario > 50);
                    System.out.println("Los m�ltiplos de "+valorUsuario+" son:");
                    suma=0;
                    for (int cont = 1; cont <= 100; cont++) {
                        if (cont % valorUsuario == 0) {
                            suma=suma+cont;
                            System.out.println(cont);
                        }
                    }
                    System.out.println("La suma de los m�ltiplos de "+valorUsuario+", incluyendo el "+valorUsuario+" es:");
                    System.out.println(suma);
                    System.out.println("Quieres volver a jugar?");
                    System.out.println("0. No." );
                    System.out.println("1. Si." );
                    menu=sc.nextInt();
            }
        } 
    }       