public class MainProgram {

	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");
		System.out.flush();
		Menu menu = new Menu();
		menu.menu();
	}

}