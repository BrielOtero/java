package exercise;

import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Collection {

	public static String shorten(String text) {
		if (text.length() > 23) {
			return text.substring(0, 20) + "...";
		} else {
			return text;
		}
	}

	public static void error() {
		System.out.println();
		System.out.println("+---------------------------------+");
		System.out.println("| Please first insert a Videogame |");
		System.out.println("+---------------------------------+");
		System.out.println();

	}

	private ArrayList<Videogame> videogames = new ArrayList<Videogame>();

	public void setVideogames(ArrayList<Videogame> videogames) {
		this.videogames = videogames;
	}

	public ArrayList<Videogame> getVideogames() {
		return videogames;
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);

		int menu;

		String title;
		int year;
		String manufacturer;

		String search;
		String saveData = "";
		boolean noSearch = true;

		int position;
		boolean error;
		String titleRemove;

		int yearRemove;

		File f = null;

		do {
			System.out.println("Choose an option: ");
			System.out.println();
			System.out.println("1. Insert new videogame");
			System.out.println("2. See all the list for videogames");
			System.out.println("3. Search videogames");
			System.out.println("4. Delete videogame");
			System.out.println("5. Delete videogames from a given year");
			System.out.println("6. Exit");
			System.out.print("--> ");
			menu = sc.nextInt();
			sc.nextLine();
			System.out.println();

			switch (menu) {
				case 1:

					Videogame game = new Videogame();

					System.out.println("Write the title: ");
					System.out.print("--> ");
					title = sc.nextLine();
					game.setTitle(title);
					System.out.println();

					System.out.println("Insert the launch year: ");
					System.out.print("--> ");
					year = sc.nextInt();
					game.setYear(year);
					System.out.println();
					sc.nextLine();

					System.out.println("Write the Manufacturer: ");
					System.out.print("--> ");
					manufacturer = sc.nextLine();
					game.setManufacturer(manufacturer);
					System.out.println();

					if (getVideogames().size() == 0) {
						videogames.add(game);
					} else {

						int submenu;
						System.out.println();
						System.out.println("Choose an option: ");
						System.out.println("1. In the beginning");
						System.out.println("2. In the end");
						System.out.print("--> ");
						submenu = sc.nextInt();
						sc.nextLine();

						switch (submenu) {
							case 1:
								videogames.add(0, game);
								System.out.println();
								break;
							case 2:
								videogames.add(game);
								System.out.println();
								break;
							default:
								System.out.println("Invalid option");
								System.out.println();
								break;
						}
					}

					break;
				case 2:
					if (getVideogames().size() > 0) {

						for (Videogame videogame : videogames) {
							System.out.printf(
									"+----------+--------------------------------+------------+---------------------------------------+\n");
							System.out.printf("+ Game %3s | Title: %23s | Year: %4d | Manufacturer: %23s +\n",
									videogames.indexOf(videogame), shorten(videogame.getTitle()),
									videogame.getYear(), shorten(videogame.getManufacturer()));
						}
						System.out.printf(
								"+----------+--------------------------------+------------+---------------------------------------+\n");
						System.out.println();
					} else {
						error();
					}
					break;
				case 3:
					if (getVideogames().size() > 0) {

						noSearch = true;
						System.out.println("Enter your search: ");
						System.out.print("--> ");
						search = sc.nextLine();
						System.out.println();
						System.out.println("Titles that match with your search:");
						System.out.println();

						for (Videogame videogame : videogames) {
							if (videogame.getTitle().startsWith(search.toUpperCase())) {
								System.out.println("--> " + videogame.getTitle());
								noSearch = false;
							}
						}
						if (noSearch) {
							System.out.println("There is no match");
						}
						System.out.println();
					} else {
						error();
					}

					break;
				case 4:
					error = false;
					if (getVideogames().size() != 0) {
						do {
							if (error) {
								System.out.println();
								System.out.println("Please select a correct position");
								System.out.println();
							}

							System.out.println("Select the position (0-N):");
							System.out.print("--> ");
							position = sc.nextInt();
							error = true;
						} while (position > videogames.size() - 1 || position < 0);
						titleRemove = videogames.get(position).getTitle();
						videogames.remove(position);
						sc.nextLine();

						System.out.println();
						System.out.println("+---------------------------------+");
						System.out.printf("| %23s  erased |\n", shorten(titleRemove));
						System.out.println("+---------------------------------+");
						System.out.println();

					} else {
						error();
					}

					break;
				case 5:
					error = false;
					noSearch = true;
					if (getVideogames().size() != 0) {
						do {
							if (error) {
								System.out.println();
								System.out.println("Please select a correct year");
								System.out.println();
							}

							System.out.println("Select the year:");
							System.out.print("--> ");
							yearRemove = sc.nextInt();
							sc.nextLine();
							error = true;

						} while (yearRemove < 0);

						System.out.println();
						System.out.println("+---------------------------------+");

						for (int i = videogames.size() - 1; i >= 0; i--) {
							if (videogames.get(i).getYear() == yearRemove) {

								titleRemove = videogames.get(i).getTitle();
								videogames.remove(videogames.indexOf(videogames.get(i)));

								System.out.printf("| %23s  erased |\n", shorten(titleRemove));
								noSearch = false;
							}

						}
						System.out.println("+---------------------------------+");
						System.out.println();
						if (noSearch) {
							System.out.println("There is no match");
						}
						System.out.println();

					} else {
						error();
					}
					break;
				case 6:
					try (PrintWriter p = new PrintWriter(System.getProperty("user.home") + "/save.txt")) {

						for (Videogame videogame : videogames) {
							saveData += String.format("%s---%d---%s---", videogame.getTitle(), videogame.getYear(),
									videogame.getManufacturer());
						}
						
						p.println(saveData);
						p.close();

					} catch (IOException e) {
						System.err.println("Error saving data");
					}

					break;
				default:
					System.out.println("Invalid option");
					break;
			}
		} while (menu != 6);

	}
}
