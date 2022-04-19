import java.util.*;
    public class Boletin16 {
        
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int valorJugador1=1, valorJugador2=0, menu=1,cont=5,clean=0; 
            
            while (menu != 0){  
                do{
                    cont=5;
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("---------------------- Adivina un número entre 1 y 100 ----------------------");
                    System.out.println("-----------------------------------------------------------------------------");
                    System.out.println("Jugador 1: Introduce un número entre 1 y 100 para que adivine tu contrincante");
                    System.out.println("-----------------------------------------------------------------------------");
                    valorJugador1=sc.nextInt();
                } while (valorJugador1>100 || valorJugador1<=0);
                
                clean=0;
                do{
                    System.out.println("");
                    clean++;
                } while (clean<100);    
                
                while (cont > 0){
                        do{
                            System.out.println("--------------------------------------------");
                            System.out.println("----- Adivina un número entre 1 y 100 -----");
                            System.out.println("--------------------------------------------");
                            System.out.println("Tienes "+cont+" intentos para adivinarlo");
                            System.out.println("--------------------------------------------");
                            System.out.println("Jugador 2: Introduce un número entre 1 y 100");
                            System.out.println("--------------------------------------------");
                            valorJugador2=sc.nextInt();
                        } while (valorJugador2>100 || valorJugador2<=0);    
                        
                        if (valorJugador1>valorJugador2){
                            System.out.println("----------------------------------------------");
                            System.out.println("El número a acertar es MAYOR");
                        } else {
                            if (valorJugador1<valorJugador2){
                                System.out.println("----------------------------------------------");
                                System.out.println("El número a acertar es MENOR");
                            } else {
                                if (valorJugador1 == valorJugador2){
                                cont=1;
                                }
                            }
                        }
                cont=cont-1; 
            }
                    if(valorJugador1 != valorJugador2){
                        clean=0;
                        do{
                            System.out.println("");
                            clean++;
                        } while (clean<100);
                        System.out.println("PERDISTE!!!!!");
                    } else {
                        clean=0;
                        do{
                            System.out.println("");
                            clean++;
                        } while (clean<100);
                        System.out.println("Acertaste! HAS GANADO!!!!!");
                    }     
        
                    System.out.println("--------------------------------------------");
                    System.out.println("Quieres volver a jugar?");
                    System.out.println("0. No." );
                    System.out.println("1. Si." );
                    System.out.println("--------------------------------------------");
                    menu=sc.nextInt();   
                }
            
    }
} 