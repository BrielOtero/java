package exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class IUApp {
	Scanner sc = new Scanner(System.in);

	int len = 28;
	Format fr = new Format();

	public void Menu() {
		fr.clearScreen();

		int menu;

		do {
			fr.printLine(len);
			fr.printString("Welcome to HexDump", len);
			fr.printLine(len);
			fr.printString("Choose an option:", len);
			fr.printLine(len);
			fr.printString("1. Start Hex", len);
			fr.printString("2. Exit     ", len);
			fr.printLine(len);
			System.out.print("--> ");
			menu = sc.nextInt();
			sc.nextLine();
			switch (menu) {
				case 1:
					startHex();
					break;
				case 2:
					break;

				default:
					fr.clearScreen();
					fr.printLine(len);
					fr.printString("Invalid Option", len);
					break;
			}

		} while (menu != 2);

	}

	public void startHex() {
		String pathFile;
		File f = null;
		fr.clearScreen();
		Boolean error = false;

		do {
			if (error) {
				fr.printLine(len);
				fr.printString("Error: Incorrect Path", len);
			}
			error = false;

			fr.printLine(len);
			fr.printString("Insert the path", len);
			fr.printLine(len);
			System.out.print("--> ");
			pathFile = sc.nextLine();

			fr.clearScreen();

			try {
				f = new File(pathFile);
			} catch (NumberFormatException e) {
				error = true;
			}

			if (!f.isFile() || !f.exists() || !f.canRead()) {
				error = true;
			}

		} while (error);

		try (RandomAccessFile rf = new RandomAccessFile(f, "r")) {
			int byteToPrint = 0;
			rf.seek(0);
			System.out.print("Offset(h) 00");
			for (int i = 1; i <= 15; i++) {
				System.out.printf("  %02X", i);
			}
			System.out.println();
			for (int i = 0; byteToPrint != -1; i++) {
				System.out.printf("%07X0 ", i);
				for (int j = 0; j < 16; j++) {
					byteToPrint = rf.read();
					if (byteToPrint != -1) {
						System.out.printf(" %02X ", byteToPrint);
					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Error on reading: " + e.getMessage());

		} catch (IOException e) {
			System.out.println("Error on writing: " + e.getMessage());

		}
	}

}
