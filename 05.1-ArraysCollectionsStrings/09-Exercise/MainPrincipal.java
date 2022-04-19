import java.util.ArrayList;
import java.util.*;

public class MainPrincipal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> nUser = new ArrayList<>();
		ArrayList<Integer> cpuUser = new ArrayList<>();

		String num;
		String[] str;

		int success = 0;
		int[] allSuccess = { 0, 0, 0, 0, 0, 0, 0};
		Lotery lotery = new Lotery();
		
		boolean check = false;

		do {
			System.out.print("\033[H\033[2J");
			System.out.flush();

			if (check) {
				System.out.println("+------------------------------------------------+");
				System.out.println("|         Please select a correct value          |");
				nUser.clear();
				
			}
			
			System.out.println("+--------------------------------------------------+");
			System.out.println("| Enter 6 numbers between 1-49 separated by commas |");
			System.out.println("+--------------------------------------------------+");
			System.out.println();
			System.err.println("Hola");
			System.out.print("-> ");
			num = sc.nextLine();
			System.out.println();
			
			check=false;
			
			// Convert
			str = num.split(",");
			
			// Check & convert string to int to vector
			for (String string : str) {
				if(Integer.parseInt(string)<1 || Integer.parseInt(string)>49|| nUser.contains(Integer.parseInt(string)) ){
					check=true;
				}
				nUser.add(Integer.parseInt(string));
			}
			
			//Check size
			if(check==false){
				check = nUser.size()!=6;
			}

		} while (check == true);

		for (int i = 0; i <= 1000000; i++) {
			cpuUser = lotery.fillCol(cpuUser);
			success = lotery.compare(nUser, cpuUser);
			allSuccess[success]++;
		}
		

		System.out.println("+------------------------------------------------+");
		for (int i = 0; i < allSuccess.length; i++) {
			System.out.printf("|     %d lottery hits    -->   %7d times      |\n", i, allSuccess[i]);
			System.out.println("+------------------------------------------------+");
		}
	}

	

}
