import java.util.*;
    public class Boletin15 {
        public static void main (String [] args){
            Scanner sc= new Scanner(System.in);
            int menu;
            double valorUsuario=0;         
            do {
                System.out.println("-------------------------------");
                System.out.println("Elige una opción: ");
				System.out.println("1. Conversión Euros a Libras." );
                System.out.println("2. Conversión Libras a Euros." );
				System.out.println("3. Salir");
                System.out.println("-------------------------------");
				menu=sc.nextInt();
                switch(menu){
                    case 1:
                    do{
                        //valorUsuario=0;
                        System.out.println("-------------------------------");
                        System.out.println("Introduce la cantidad a convertir:");
                        valorUsuario = sc.nextDouble();
                        if (valorUsuario<0){
                            System.out.println("ERROR: Por favor sólo introduce nº positivos");    
                        }
                    } while (valorUsuario == 0);
                    System.out.println("-------------------------------");
                    System.out.printf("%.2f Euros son %.2f Libras.\n",valorUsuario,valorUsuario*0.85);  
                    break;
                    case 2:
                    do{
                        valorUsuario=0;
                        System.out.println("-------------------------------");
                        System.out.println("Introduce la cantidad a convertir:");
                        valorUsuario = sc.nextDouble();
                        if (valorUsuario<0){
                            System.out.println("ERROR: Por favor sólo introduce nº positivos");    
                        }
                    } while (valorUsuario == 0);
                    System.out.println("-------------------------------");
                    System.out.printf("%.2f Libras son %.2f Euros.\n",valorUsuario,valorUsuario*1.18);
                    break;
                    case 3:
                    break;
                    default:
                        System.out.println("Opción no válida");
                    break;
                }
            } while (menu != 3);      
    }    
} 