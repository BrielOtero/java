import java.util.*;
    public class Boletin6 {
        public static void main (String [] args){
            
			Scanner sc= new Scanner(System.in);

			double n;
			int menu,a ,b;
			
            do {
				System.out.println("Elige una opci�n: ");
				System.out.println("1. Cuadrado de un n�mero real." );
				System.out.println("2. Inverso de un n�mero");
                System.out.println("3. Ra�z cuadrada de un n�mero");
                System.out.println("4. Operaci�n AND");
                System.out.println("5. Operaci�n OR");
				System.out.println("6. Salir");
                System.out.println("----------------");
				menu=sc.nextInt();

				switch (menu){
					case 1:
                        System.out.println("Introduce un n�mero real: ");
                        n=sc.nextDouble();
                        System.out.println("----------------");
                        System.out.printf("El resultado es %.2f\n", n*n);
                        System.out.println("----------------");
						
					break;
					case 2:
                        do {
                                System.out.println("Introduce un n�mero: ");
                                n=sc.nextDouble();
                        } while (n == 0);
                        System.out.println("----------------");
                        System.out.printf("El resultado es %.4f\n", 1/n);
                        System.out.println("----------------");
        
					break;
					case 3:
                        do {
                            System.out.println("Introduce un n�mero: ");
                            n=sc.nextDouble();
                        } while (n<0);
                        System.out.println("----------------");
                        System.out.printf("El resultado es %.3f\n", Math.sqrt(n));
                        System.out.println("----------------");
                      
					break;
                    case 4:
                        System.out.println("Introduce un n�mero entero: ");
                        a=sc.nextInt();
                        System.out.println("----------------");
                        System.out.println("Introduce otro n�mero entero: ");
                        b=sc.nextInt();
                        System.out.println("----------------");
                        System.out.printf("El resultado es %x\n", a&b);
                        System.out.println("----------------");
					break;
                    case 5:
                        System.out.println("Introduce un n�mero entero: ");
                        a=sc.nextInt();
                        System.out.println("----------------");
                        System.out.println("Introduce otro n�mero entero: ");
                        b=sc.nextInt();
                        System.out.println("----------------");
                        System.out.printf("El resultado es %x\n", a|b);
                        System.out.println("----------------");
                    
                    break;
                    case 6:
					break;
					default:
						System.out.println("Opci�n no v�lida");
					break;
				}
			} while (menu != 6);


    }
}