class MainPrincipal {
	public String bigBoss;

	public void setBigBoss(String bigBoss) {
		this.bigBoss = bigBoss;
	}

	public String getBigBoss() {
		return bigBoss;
	}

	public MainPrincipal() {
		this.bigBoss = "Jar Jar is the Big Boss";
	}

	public static void main(String[] args) {
		String bigBossUp;
		String anotherBigBoss;

		MainPrincipal mainPrincipal = new MainPrincipal();

		System.out.println(mainPrincipal.bigBoss.length());

		System.out.println(mainPrincipal.bigBoss.charAt(0));
		System.out.println(mainPrincipal.bigBoss.charAt(mainPrincipal.bigBoss.length() - 1));
		// System.out.println(mainPrincipal.bigBoss.charAt(100)); Return ERROR
		bigBossUp = mainPrincipal.bigBoss.toUpperCase();

		System.out.println(mainPrincipal.bigBoss.equals(bigBossUp));
		System.out.println(mainPrincipal.bigBoss.equalsIgnoreCase(bigBossUp));

		System.out.println(mainPrincipal.bigBoss.toLowerCase());

		System.out.println(mainPrincipal.bigBoss.endsWith("Boss"));
		System.out.println(mainPrincipal.bigBoss.endsWith("Jar"));

		System.out.println(mainPrincipal.bigBoss.indexOf("Jar"));
		System.out.println(mainPrincipal.bigBoss.lastIndexOf("Jar"));

		anotherBigBoss = mainPrincipal.bigBoss.substring(3, 8);
		System.out.println(anotherBigBoss);

		String[] strings = new String[10];

		System.out.println();

		strings = mainPrincipal.bigBoss.split(" ");

		for (String string : strings) {
			System.out.println(string);
		}

	}
}