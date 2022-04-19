public class MainPrincipal {
	public static void main(String[] args) {
		
		Collection games = new Collection();

		Videogame game0 = new Videogame();
		Videogame game1 = new Videogame();
		Videogame game2 = new Videogame();

		game0.setTitle("Super Mario 64");
		game0.setYear(1997);
		game0.setManufacturer("Nintendo");
		games.getVideogames().add(game0);

		game1.setTitle("The legend of zelda breath of the wild");
		game1.setYear(2017);
		game1.setManufacturer("Nintendo");
		games.getVideogames().add(game1);
		
		game2.setTitle("Forza horizon 5");
		game2.setYear(2021);
		game2.setManufacturer("Xbox Game Studios");
		games.getVideogames().add(game2);

		System.out.print("\033[H\033[2J");
        System.out.flush();

		games.menu();
	}
	
}
