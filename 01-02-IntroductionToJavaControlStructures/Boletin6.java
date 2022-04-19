import java.util.*;
    public class Boletin6 {
        public static void main (String [] args){
            
			Scanner sc= new Scanner(System.in);

			double n;
			int menu,a ,b;
			
            do {
				System.out.println("Elige una opción: ");
				System.out.println("1. Cuadrado de un número real." );
				System.out.println("2. Inverso de un número");
                System.out.println("3. Raíz cuadrada de un número");
                System.out.println("4. Operación AND");
                System.out.println("5. Operación OR");
				System.out.println("6. Salir");
                System.out.println("----------------");
				menu=sc.nextInt();

				switch (menu){
					case 1:
                        System.out.println("Introduce un número real: ");
                        n=sc.nextDouble();
                        System.out.println("----------------");
                        System.out.printf("El resultado es %.2f\n", n*n);
                        System.out.println("----------------");
						
					break;
					case 2:
                        do {
                                System.out.println("Introduce un número: ");
                                n=sc.nextDouble();
                        } while (n == 0);
                        System.out.println("----------------");
                        System.out.printf("El resultado es %.4f\n", 1/n);
                        System.out.println("----------------");
        
					break;
					case 3:
                        do {
                            System.out.println("Introduce un número: ");
                            n=sc.nextDouble();
                        } while (n<0);
                        System.out.println("----------------");
                        System.out.printf("El resultado es %.3f\n", Math.sqrt(n));
                        System.out.println("----------------");
                      
					break;
                    case 4:
                        System.out.println("Introduce un número entero: ");
                        a=sc.nextInt();
                        System.out.println("----------------");
                        System.out.println("Introduce otro número entero: ");
                        b=sc.nextInt();
                        System.out.println("----------------");
                        System.out.printf("El resultado es %x\n", a&b);
                        System.out.println("----------------");
					break;
                    case 5:
                        System.out.println("Introduce un número entero: ");
                        a=sc.nextInt();
                        System.out.println("----------------");
                        System.out.println("Introduce otro número entero: ");
                        b=sc.nextInt();
                        System.out.println("----------------");
                        System.out.printf("El resultado es %x\n", a|b);
                        System.out.println("----------------");
                    
                    break;
                    case 6:
					break;
					default:
						System.out.println("Opción no válida");
					break;
				}
			} while (menu != 6);


    }
}