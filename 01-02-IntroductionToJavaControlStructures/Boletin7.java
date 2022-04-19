import java.util.*;
    public class Boletin7 {
        public static void main (String [] args){
            
			Scanner sc= new Scanner(System.in);

			double media, m, suma = 0;
			int menu,b, contador=1;
             
                    do{
                        do {      
                            System.out.println("--------------------------------------------------------");
                            System.out.println("Introduce el "+contador+" número");
                            System.out.println("Pulsa 0 en cualquier momento para salir"); 
                            System.out.println("--------------------------------------------------------"); 
                            m = sc.nextDouble(); 
                            suma += m;   
                            ++contador;   
                            } while (m != 0);   
                            contador = contador-2;   
                            media = suma/contador;
                            System.out.println("--------------------------------------------------------");    
                            System.out.println("La media es "+media); 
                            System.out.println("--------------------------------------------------------");  
                            contador = 1;
                            suma = 0;
                            System.out.println("Elige una opción: ");
				            System.out.println("1. Volver a calcular ");
				            System.out.println("2. Salir" );
                            menu=sc.nextInt();
                            switch (menu){
                                case 1:
                                break;
                                case 2:
                                break;
                                default:
						        System.out.println("Opción no valida");
					            break;
                            }
                    } while (menu != 2); 
    }
}