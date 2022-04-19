import java.util.*;

public class MainPrincipal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Dni dni = new Dni();
		String dniValue;
		boolean check = false;
		char letter = 'a';
		int menu;

		// Test the algorithm
		System.out.println(dni.letter("77542726"));
		System.out.println(dni.letter("77.542.726"));
		System.out.println(dni.letter("7754272"));
		System.out.println(dni.letter("7.75427.26"));
		System.out.println(dni.letter("77.542.72.6"));
		System.out.println(dni.letter("abcdefgh"));
		System.out.println(dni.letter("77.5.2.772"));
		System.out.println(dni.letter("77...2.772"));
		System.out.println(dni.letter("77.555.7.2"));

		if (args.length == 0) {

			do {
				System.out.println("+---------------------------------------------+");
				System.out.println("|              Choose an option               |");
				System.out.println("+---------------------------------------------+");
				System.out.println("|  1. Get DNI Letter                          |");
				System.out.println("+---------------------------------------------+");
				System.out.println("|  2. Check DNI                               |");
				System.out.println("+---------------------------------------------+");
				System.out.println("|  3. Exit                                    |");
				System.out.println("+---------------------------------------------+");
				System.out.println();
				System.out.print("--> ");

				menu = sc.nextInt();

				sc.nextLine();
				switch (menu) {
					case 1:
						check = false;
						do {
							System.out.println();

							if (check) {
								System.out.println("+---------------------------------------------+");
								System.out.println("|        PLEASE select a correct value        |");
							}
							check = false;
							System.out.println("+---------------------------------------------+");
							System.out.println("|       Insert the numbers of your DNI        |");
							System.out.println("+---------------------------------------------+");
							System.out.println("|      With format 33444555 or 33.444.555     |");
							System.out.println("+---------------------------------------------+");
							System.out.println();
							System.out.print("--> ");
							dniValue = sc.nextLine();

							if (dni.letter(dniValue) == '*') {
								check = true;
							}
						} while (check == true);
						System.out.println();
						System.out.println("+---------------------------------------------+");
						System.out.printf("|             Your DNI Letter is: %c           |\n", dni.letter(dniValue));
						break;
					case 2:
						check = false;
						do {
							System.out.println();

							if (check) {
								System.out.println("+---------------------------------------------+");
								System.out.println("|        PLEASE select a correct value        |");
							}
							check = false;
							System.out.println("+---------------------------------------------+");
							System.out.println("|               Insert your DNI               |");
							System.out.println("+---------------------------------------------+");
							System.out.println("|            With format 33444555E            |");
							System.out.println("+---------------------------------------------+");
							System.out.println();
							System.out.print("--> ");
							dniValue = sc.nextLine();
							if (dniValue.length() == 9) {
								letter = dniValue.charAt(8);
								letter = Character.toUpperCase(letter);
								dniValue = dniValue.substring(0, 8);

								if (dni.letter(dniValue) == '*') {
									check = true;
								}
							} else {
								check = true;
							}
						} while (check == true);

						if (dni.letter(dniValue) == letter) {
							System.out.println();
							System.out.println("+---------------------------------------------+");
							System.out.println("|         Your DNI Letter is Correct          |");
						} else {
							System.out.println();
							System.out.println("+---------------------------------------------+");
							System.out.println("|        Your DNI Letter is Incorrect         |");
						}
						break;
					case 3:

						break;
					default:
						System.out.println();
						System.out.println("+---------------------------------------------+");
						System.out.println("|               Invalid Option                |");
						System.out.println("+---------------------------------------------+");
						System.out.println();
						break;
				}
			} while (menu != 3);
		} else {

			if (dni.letter(args[0]) != '*') {

				System.out.println();
				System.out.println("+---------------------------------------------+");
				System.out.printf("|             Your DNI Letter is: %c           |\n", dni.letter(args[0]));
				System.out.println("+---------------------------------------------+");
			} else {
				System.out.println();
				System.out.println("+---------------------------------------------+");
				System.out.println("|            The value is incorrect           |");
				System.out.println("+---------------------------------------------+");
			}
		}
	}
}